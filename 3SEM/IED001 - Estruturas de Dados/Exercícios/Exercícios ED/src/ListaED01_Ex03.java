import javax.swing.JOptionPane;

public class ListaED01_Ex03 {
	
	static int qtd = 100;

	public static void main(String[] args) {
		
		int [] vetor = new int [qtd];
		int aux;
		String resultado = "Vetor fora de ordem:\n";
		
		for(int i = 0; i < qtd; i++) {
			vetor[i] = (int) (Math.random() * 200) - 100;
			resultado += "[" + vetor[i] + "]";
			if((i + 1) % 10 == 0) {
				resultado += "\n";
			}
		}

		for (int i = 0; i < qtd; i++) {
			for(int j = 0; j < qtd; j++) {
				if(vetor[j] > vetor[i]) {
					aux = vetor[i];
					vetor[i] = vetor[j];
					vetor[j] = aux;
				}
			}
		}
		
		resultado += "\nVetor ordenado:\n";
		
		for(int i = 0; i < qtd; i++) {
			resultado += "[" + vetor[i] + "]";
			if((i + 1) % 10 == 0) {
				resultado += "\n";
			}
		}
		
		JOptionPane.showMessageDialog(null, resultado);		
	}
}
