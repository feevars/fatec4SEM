import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		final int QTD = 11;
		int [] vetor = {10,9,8,7,6,5,4,3,2,1,0};
		int [] vetorAux = new int[QTD];
		
		String textoInicial = "Vetor aleatório:\n";
		String textoFinal = "\n\nVetor ordenado:\n";
		
		
		for (int i = 0; i < vetor.length; i++) {
			//vetor[i] = (int) (Math.random() * 99) + 1;
			textoInicial += "[" + vetor[i] + "]";
		}
		
		
		mergeSort(vetor, vetorAux, 0, vetor.length - 1);
		
		for (int i = 0; i < vetor.length; i++) {
			textoFinal += "[" + vetor[i] + "]";
		}
		
		JOptionPane.showMessageDialog(null, textoInicial + textoFinal);
		
	}

	private static void mergeSort(int[] vetor, int[] vetorAux, int inicio, int fim) {
		if (inicio < fim) {
			int meio = (inicio + fim) / 2;
			mergeSort(vetor, vetorAux, inicio, meio);
			mergeSort(vetor, vetorAux, meio + 1, fim);
			intercalar(vetor, vetorAux, inicio, meio, fim);
		}
		
	}

	private static void intercalar(int[] vetor, int[] vetorAux, int inicio, int meio, int fim) {
		for (int k = inicio; k <= fim; k++) {
			vetorAux[k] = vetor[k];
		}
		int i = inicio;
		int j = meio + 1;
		
		for (int k = inicio; k <= fim; k++) {
			if(i > meio) vetor[k] = vetorAux[j++];
			else if (j > fim) vetor[k] = vetorAux[i++];
			else if (vetorAux[i] < vetorAux[j]) vetor[k] = vetorAux[i++];
			else vetor[k] = vetorAux[j++];
		}
	}
}
