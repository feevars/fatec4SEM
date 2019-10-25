
import javax.swing.JOptionPane;

import controller.MergeSort;

public class Principal {
	public static void main(String[] args) {
		
		final int QTD = 5;
		int [] vetor = new int[QTD];
		
		String textoInicial = "Vetor aleatório:\n";
		String textoFinal = "\n\nVetor ordenado:\n";
		
		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = (int) (Math.random() * 99) + 1;
			textoInicial += "[" + vetor[i] + "]";
		}
		
		MergeSort m = new MergeSort();
		m.mergeSort(vetor);
		
		for (int i = 0; i < vetor.length; i++) {
			textoFinal += "[" + vetor[i] + "]";
		}
		
		JOptionPane.showMessageDialog(null, textoInicial + textoFinal);
		
	}
}
