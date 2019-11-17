import controller.HeapSort;

public class Lista08{

	public static void main(String[] args) {
		
		
		
		int [] vetor = {87, 6, 3, 5, 1, 9, 42, 43, 57, 71, 23,21, 98};
		
		System.out.println(HeapSort.printaVetor(vetor));
		
		HeapSort.sortMaximo(vetor);
		System.out.println(HeapSort.printaVetor(vetor));
		
		HeapSort.sortMinimo(vetor);
		System.out.println(HeapSort.printaVetor(vetor));

	}

}
