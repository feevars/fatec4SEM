package view;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AppFuncionarios {

	public static void main(String[] args) {
		
		int opcaoMenu;
		
		
		
		do {
			opcaoMenu = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção desejada:\n"
					+ "1: Adicionar na primeira posição\n"
					+ "2: Adicionar na última posição\n"
					+ "3: Adicionar em em uma posição escolhida\n"));
			
			switch (opcaoMenu) {
			case 1:
				JFrame janela = new JFrame();
				FormFuncionario formFuncionario = new FormFuncionario();
				janela.setLayout(new FlowLayout());
				janela.setMinimumSize(new Dimension(300,300));
				janela.add(formFuncionario);
				janela.setLocationRelativeTo(null);
				janela.pack();
				janela.setVisible(true);
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
