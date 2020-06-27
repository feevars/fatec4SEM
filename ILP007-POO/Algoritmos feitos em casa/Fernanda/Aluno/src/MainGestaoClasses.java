import java.util.Scanner;

public class MainGestaoClasses {

	public static void main(String[] args) {
		GestaoAlunos g = new GestaoAlunos();
		
		while(true) {
			System.out.println("Gestão de Alunos"
							  +"\n\nEscolha uma das opções a seguir:"
							  +"\n(C)riar"
							  +"\n(A)tualizar"
							  +"\n(E)xibir"
							  +"\n(R)emover"
							  +"\n(S)air");
			Scanner scan = new Scanner(System.in);
			String textoMaiusculo = scan.nextLine().toUpperCase();
			char letra = textoMaiusculo.charAt(0);
			
			switch (letra) {
			case 'C':
				g.criar();
				break;
			case 'A':
				g.atualizar();
				break;
			case 'E':
				g.exibir();
				break;
			case 'R':
				g.excluir();
				break;
			case 'S':
				System.exit(0);
				break;
			default:
				System.out.println("Opção inválida. Tente novamente.");
				break;
			}
}
	}
}
