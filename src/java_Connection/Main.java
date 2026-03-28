package java_Connection;

public class Main {
	public static void main(String[] args) {
	    FuncionarioDAO dao = new FuncionarioDAO();

	    System.out.println("Lista após inserção:");
	    dao.listarTodos();



	    // 4. TESTE EXCLUIR
	    // dao.excluir(1); 
	}
}