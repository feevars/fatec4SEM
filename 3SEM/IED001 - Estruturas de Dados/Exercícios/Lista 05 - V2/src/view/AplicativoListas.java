package view;

import javax.swing.JOptionPane;

import controller.ListaDupla;

public class AplicativoListas {

	public static void main(String[] args) {
		
		ListaDupla<Double> lista = new ListaDupla<Double>();
		int opcaoMenu;
		
		do {
			opcaoMenu = Integer.parseInt(JOptionPane.showInputDialog("Lista de números reais\n----------------------\n"
					+ "Digite a opção do menu:\n"
					+ "1 - Inserir na primeira posição\n"
					+ "2 - Inserir na última posição\n"
					+ "3 - Inserir em qualquer posição\n"
					+ "4 - Imprimir lista\n"
					+ "5 - Tamanho da lista\n"
					+ "0 - Sair\n"));
			switch (opcaoMenu) {
			case 1:
				lista.inserePrimeiro(Double.parseDouble(JOptionPane.showInputDialog("Inserir na primeira posição:")));
				break;
			case 2:
				lista.insereUltimo(Double.parseDouble(JOptionPane.showInputDialog("Inserir na última posição:")));
				break;
			case 3:
				int posicao = 0;
				do {
					posicao = Integer.parseInt(JOptionPane.showInputDialog("Digite a posição que você deseja inserir o item: "));
				} while (posicao < 1);
				double conteudo = Double.parseDouble(JOptionPane.showInputDialog("Conteúdo: "));
				lista.inserePosicao(conteudo, posicao);
				break;
			case 4:
				JOptionPane.showMessageDialog(null, lista.imprimeLista());
				break;
			case 5:
				JOptionPane.showMessageDialog(null, "Quantidade de itens na lista:\n" + lista.getQtdNo());
				break;
			case 0:
				//FIM
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida!");
				break;
			}
			
			
		} while (opcaoMenu != 0);
		
	}

}
