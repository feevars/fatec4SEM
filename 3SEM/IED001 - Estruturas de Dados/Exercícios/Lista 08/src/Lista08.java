import controller.HeapSort;

public class Lista08{
	
	/**
	 * Método principal da Lista 08 - Estruturas de Dados
	 * FATEC Zona Leste - Professor Fábio Pereira da Silva
	 * 
	 * Desenvolvedor: Bruno Bega Harnik
	 */
	public static void main(String[] args) {
		
		int [] vetor = {87, 6, 3, 5, 1, 9, 42, 43, 57, 71, 23,21, 98};
		
		System.out.println("Vetor do exercício:");
		System.out.println(HeapSort.printaVetor(vetor));
		
		HeapSort.sortMaximo(vetor);
		System.out.println("\n\nHeapSort (Máximo):");
		System.out.println(HeapSort.printaVetor(vetor));
		
		HeapSort.sortMinimo(vetor);
		System.out.println("\n\nHeapSort (Mínimo):");
		System.out.println(HeapSort.printaVetor(vetor));
	}
}
