import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GestaoFuncionarios {
	int indice;
	Set<Funcionario> funcionarios = new HashSet<Funcionario>();
	Funcionario func = new Funcionario();
	
	Scanner sc = new Scanner (System.in);
	
	public void criar() {
		funcionarios.add(func);
		System.out.println("Funcionário cadastrado no sistema.");
	}
	
	public void excluir() {
		funcionarios.remove(func); 
		System.out.println("funcionário removido com sucesso.");
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
}
