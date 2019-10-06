package view;

import javax.swing.JOptionPane;

import controller.*;

public class Tela {

	public static int menu() {

		String textoMenu = "Menu:\n"
				+ "1: Adicionar na primeira posição\n"
				+ "2: Adicionar na última posição\n"
				+ "3: Remover\n"
				+ "4: Localizar\n"
				+ "5: Imprimir lista\n"
				+ "6: Quantidade na lista\n"
				+ "7: Encerrar programa";

		return Integer.parseInt(JOptionPane.showInputDialog(textoMenu));
	}

	public static void main(String[] args) {

		ListaEncadeada lista = new ListaEncadeada();
		String letra;
		int opcao;

		do {
			opcao = menu();
			switch (opcao) {
			case 1:
				letra = JOptionPane.showInputDialog("Inserindo na primeira posição.\n"
						+ "Digite o caractere que deseja armazenar: ");
				lista.inserirPrimeiro(letra);
				break; 
			case 2:
				letra = JOptionPane.showInputDialog("Inserindo na ÚLTIMA posição.\n"
						+ "Digite o caractere que deseja armazenar: ");
				lista.inserirUltimo(letra);
				break; 
			case 3:
				if (lista.estaVazia()) {
					JOptionPane.showMessageDialog(null, "A lista está vazia...");
				}else {
					String deletar = JOptionPane.showInputDialog("Deletar caractere.\n"
							+ "Digite o caractere que deseja deletar:");

					if (lista.removerNo(deletar)) {
						JOptionPane.showMessageDialog(null, deletar + " foi removido.");
					} else {
						JOptionPane.showMessageDialog(null, "Não foi possível remover " + deletar + ",\n"
								+ "pois não está na lista.");
					}
				}
				break;
			case 4:
				if (lista.estaVazia()) {
					JOptionPane.showMessageDialog(null, "A lista está vazia...");
				} else {
					String busca = JOptionPane.showInputDialog("Localizar caractere.\n"
							+ "Digite o caractere que deseja pesquisar:");	
					JOptionPane.showMessageDialog(null, lista.pesquisarNo(busca));
				}
				break;
			case 5: 
				JOptionPane.showMessageDialog(null, lista.imprimirLista());
				break;
			case 6:
				JOptionPane.showMessageDialog(null, "A lista contém " + lista.getQtdNo() + " caracteres.");
				break;
			case 7:
				JOptionPane.showMessageDialog(null, "Fim do programa.");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida!");
				break;
			}
		} while (opcao != 7);
		System.exit(0);
	}
}
