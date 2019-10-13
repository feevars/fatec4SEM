package view;

import javax.swing.JOptionPane;

import controller.ListaDupla;

public class AplicativoListas {

	public static void main(String[] args) {
		ListaDupla<Double> lista = new ListaDupla<Double>();
		int opcMenu;

		do {
			opcMenu = Integer.parseInt(JOptionPane.showInputDialog("Lista de numeros reais \n Digite a opção do menu \n"
					+ "1: Insere na primeira posição\n"
					+ "2: Insere na última posição\n"
					+ "3: Adiciona em qualquer posição\n"
					+ "7: Imprime lista\n"
					+ "8: mostra quantidade de itens na lista\n"
							
					));
			switch (opcMenu) {	

			case 1: lista.inserePrimeiro(Double.parseDouble(JOptionPane.showInputDialog("Inserir na primeira posição:" )));
			break;
			case 2: lista.insereUltimo(Double.parseDouble(JOptionPane.showInputDialog("Inserir na última posição:" )));
			break;
			case 3: 
				double conteudo = Double.parseDouble(JOptionPane.showInputDialog("Conteúdo: " ));
				int posicao = Integer.parseInt(JOptionPane.showInputDialog("posicao: " ));
				lista.inserePosicao(conteudo, posicao);
			break;
			//case 4: removePrimeiro();
			//break;
			//case 5: removeUltimo();
			//break;
			//case 6: removeQualquer();
			//break;
			case 7: JOptionPane.showMessageDialog(null, lista.imprimeLista());
			break;
			case 8: JOptionPane.showMessageDialog(null, "Quantidade de itens na lista: " + lista.getQtdNo());
			break;
			case 0: System.exit(0);
			break;
			default: JOptionPane.showMessageDialog(null, "Opção inválida");
			break;
			

			}


		} while (opcMenu !=0);

	}
}
