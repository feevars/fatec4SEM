package view;

import javax.swing.JOptionPane;

import controller.ListaDupla;

public class Ex02 {
	
	public static void main(String[] args) {
		
		ListaDupla <Double> l = new ListaDupla<Double>();
		int opcao;
		
		do {
			opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite a opção desejada:"
					+ "\n1 - Inserir na primeira posição"
					+ "\n2 - Inserir na última posição"
					+ "\n3 - Inserir em qualquer posição"
					+ "\n4 - Imprimir a lista"
					+ "\n9 - Sair"));
			
			switch (opcao) {
			case 1: 
					l.inserirPrimeiro(Double.parseDouble(JOptionPane.showInputDialog("Inserir na primeira posição\n\n"
					+ "Digite o valor que você deseja inserir na primeira posição:")));
				
				break;
				
			case 2: 
					l.inserirUltimo(Double.parseDouble(JOptionPane.showInputDialog("Inserir na última posição\n\n"
					+ "Digite o valor que você deseja inserir na última posição:")));
				
				break;
				
			case 3: 
				
					double conteudo = Double.parseDouble(JOptionPane.showInputDialog("Inserir em qualquer posição posição\n\n"
							+ "Digite o valor que você deseja inserir"));
					int posicao = Integer.parseInt(JOptionPane.showInputDialog("Digite a posição (maior que ZERO)."));
					l.inserirNaPosicao(conteudo, posicao);																				
				
				break;
				
			case 4: 
				JOptionPane.showMessageDialog(null, l.imprimirLista());
				break;
				
			case 9:
				JOptionPane.showMessageDialog(null, "Fim");
				break;

			default:
				JOptionPane.showMessageDialog(null, "Opção inválida!");
				break;
			}
			
			
		} while (opcao != 9);
	}
}
