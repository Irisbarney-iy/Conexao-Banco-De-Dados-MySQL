package java_Connection;

import java.sql.*;

public class FuncionarioDAO {

    public void inserir(Funcionario f) {
        String sql = "INSERT INTO funcionario (nome, sobrenome, idade, salario) VALUES (?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = ConnectionFactory.createConnection();
            conn.setAutoCommit(false);

            ps = conn.prepareStatement(sql);
            ps.setString(1, f.nome);
            ps.setString(2, f.sobrenome);
            ps.setInt(3, f.idade);
            ps.setDouble(4, f.salario);

            ps.executeUpdate();
            conn.commit();
            System.out.println("Funcionário inserido com sucesso!");

        } catch (SQLException e) {
            try {
                if (conn != null) {
                    conn.rollback();
                    System.err.println("Erro! Rollback efetuado.");
                }
            } catch (SQLException e2) {
                System.err.println("Erro no rollback: " + e2.getMessage());
            }
        } finally {
            try { if (ps != null) ps.close(); if (conn != null) conn.close(); } catch (Exception e) {}
        }
    }

    public void listarTodos() {
        String sql = "SELECT * FROM funcionario";
        try (Connection conn = ConnectionFactory.createConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n--- Lista de Funcionários ---");
            while (rs.next()) { 
                int id = rs.getInt("codigo");
                String nome = rs.getString("nome");
                double salario = rs.getDouble("salario");
                System.out.printf("ID: %d | Nome: %s | Salário: R$ %.2f\n", id, nome, salario);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar: " + e.getMessage());
        }
    }
    
	    public void atualizar(Funcionario f) {
	        String sql = "UPDATE funcionario SET nome = ?, sobrenome = ?, idade = ?, salario = ? WHERE codigo = ?";
	        try (Connection conn = ConnectionFactory.createConnection();
	             PreparedStatement ps = conn.prepareStatement(sql)) {
	            
	            ps.setString(1, f.nome);
	            ps.setString(2, f.sobrenome);
	            ps.setInt(3, f.idade);
	            ps.setDouble(4, f.salario);
	            ps.setInt(5, f.codigo);
	
	            int linhasAfetadas = ps.executeUpdate(); 
	            if (linhasAfetadas > 0) {
	                System.out.println("Registro atualizado com sucesso!");
	            }
	        } catch (SQLException e) {
	            System.err.println("Erro ao atualizar: " + e.getMessage());
	        }
	    }
	    
	    public void excluir(int codigo) {
	        String sql = "DELETE FROM funcionario WHERE codigo = ?";
	        
	        try (Connection conn = ConnectionFactory.createConnection();
	             PreparedStatement ps = conn.prepareStatement(sql)) {
	            
	            ps.setInt(1, codigo);
	            int linhas = ps.executeUpdate();
	            
	            if (linhas > 0) {
	                System.out.println("Funcionário excluído com sucesso!");
	            } else {
	                System.out.println("Nenhum funcionário encontrado com o código: " + codigo);
	            }
	        } catch (SQLException e) {
	            System.err.println("Erro ao excluir: " + e.getMessage());
	        }
	    }
}