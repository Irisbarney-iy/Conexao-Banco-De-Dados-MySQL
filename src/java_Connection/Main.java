package java_Connection;

public class Main {
	public static void main(String[] args) {
	    FuncionarioDAO dao = new FuncionarioDAO();

	    Funcionario f = new Funcionario();
	    f.nome = "Irisbarney";
	    f.sobrenome = "Damasceno";
	    f.idade = 17;
	    f.salario = 9000.0;
	    dao.inserir(f);

	    System.out.println("Lista após inserção:");
	    dao.listarTodos();

	    f.codigo = 1; 
	    f.salario = 5500.0;
	    dao.atualizar(f);
	    
	    // Esse comando é para exluir, por isso está como comentário
	    // dao.excluir(1); 
	}
}