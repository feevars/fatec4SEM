import javax.swing.JOptionPane;

public class Principal {
	public static void main(String[] args) {
		final int QTD = 30;
		int [] vetor = new int[QTD];
		String texto = "Vetor inicial:\n";
		
		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = (int) (Math.random() * 99) + 1;
			texto += vetor[i] + "\n";
		}
		JOptionPane.showMessageDialog(null, texto);
		
		
		quicksort(vetor, 0, vetor.length - 1);
		
		texto = "Vetor ordenado:\n";
		for (int i = 0; i < vetor.length; i++) {
			texto += vetor[i] + "\n";
		}
		
		JOptionPane.showMessageDialog(null, texto);
		
	}

	private static void quicksort(int[] vetor, int esquerda, int direita) {
		if (esquerda < direita) {
			int j = separar(vetor, esquerda, direita);
			quicksort(vetor, esquerda, j - 1);
			quicksort(vetor, j + 1, direita);
		}
		
	}

	private static int separar(int[] vetor, int esquerda, int direita) {
		int i = esquerda + 1;
		int j = direita;
		int pivo = vetor[esquerda];
		while (i <= j) {
			if(vetor[i] <= pivo) i++;
			else if(vetor[j] > pivo) j--;
			else if(i <= j) {
				trocar(vetor,i,j);
				i++;
				j--;
			}
		}
		trocar(vetor, esquerda, j);
		return j;
	}

	private static void trocar(int[] vetor, int i, int j) {
		int aux = vetor[i];
		vetor[i] = vetor[j];
		vetor[j] = aux;
		
	}
	
	
}
