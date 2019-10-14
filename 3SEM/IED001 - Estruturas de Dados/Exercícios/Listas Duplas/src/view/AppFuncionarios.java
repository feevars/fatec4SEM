package view;

import javax.swing.JOptionPane;

public class AppFuncionarios {

	public static void main(String[] args) {
		
		int opcaoMenu;
		
		
		
		do {
			opcaoMenu = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção desejada:\n"
					+ "1: Adicionar na primeira posição"
					+ "2: Adicionar na última posição"
					+ "3: Adicionar em em uma posição escolhida"));
			
			switch (opcaoMenu) {
			case 1:
				
				break;
				
			case 2:
				
				break;
				
			case 3:
				
				break;
				
			case 0:
				JOptionPane.showMessageDialog(null, "Fim do programa.");
				break;

			default:
				JOptionPane.showMessageDialog(null, "Opção inválida!");
				break;
			}
			
			
		} while (opcaoMenu != 0);
	}

}
