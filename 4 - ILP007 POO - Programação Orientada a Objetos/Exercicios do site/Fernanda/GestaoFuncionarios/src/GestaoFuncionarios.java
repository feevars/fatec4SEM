import java.util.Scanner;

public class GestaoFuncionarios {

	int indice;
	Funcionario[] funcionarios = new Funcionario();
	Funcionario func = new Funcionario();
	
	Scanner sc = new Scanner (System.in);
	
	public void criar() {
		Funcionario func = new Funcionario();
	}
	
	public void atualizar() {
		
	}
	
	public void excluir() {
		
	}
	
	public void exibir() {
		System.out.println("Digite um número de matrícula/registro: ");
		String input = sc.nextLine();
		for (Funcionario func : funcionarios) {
			if (input.equals(func.id)) {
				System.out.println(func.toString());
			}
		}
	}
	
	public void menu() {
		
	}
}