interface Ordenador {
	void ordena(int[] A);
}
class HeapSort implements Ordenador {
	public HeapSort(){
		int a [] = new int [5];
		a[0]= 11;
		a[1] = 1;
		a[2]= 2;
		a[3] = 49;
		a[4] = 7;
		ordena(a);
	}
	
	static void refazHeapMax(int A[], int i, int compHeap) {
		int esq, dir, maior, temp;
		esq = 2 * i + 1; // esquerda(i) => 2 * i + 1
		dir = 2 * i + 2; // direita (i) => 2 * i + 2
		if (esq < compHeap && A[esq] > A[i]) {
			maior = esq;
		} else {
			maior = i;
		}
		if (dir < compHeap && A[dir] > A[maior]) {
			maior = dir;
		}
		if (maior != i) {
			// trocar A[i] <==> A[maior]
			temp = A[i];
			A[i] = A[maior];
			A[maior] = temp;
			// Ajusta a posicao onde estava o maior
			refazHeapMax(A, maior, compHeap);
		}
	}
	static void constroiHeapMaxIterativo(int[] A) {
		int compHeap = A.length;
		for (int i = (A.length) / 2 - 1; i >= 0; i--) {
			refazHeapMax(A, i, compHeap);
		}
	}
	static void constroiHeapMaxRec(int[] A, int i) {
		int n = A.length;
		if (i < n/2){
			constroiHeapMaxRec(A, 2*i+1);
			constroiHeapMaxRec(A, 2*i+2);
			refazHeapMax(A, i, n);
		}
	}
	
	public void ordena(int A[]) {
		int i, compHeap, temp;
		// Constroi o heap maximo do arranjo todo
		compHeap = A.length;
		//constroiHeapMax(A);
		constroiHeapMaxRec(A,0);
		for (i = A.length - 1; i > 0; --i) {
			temp = A[0];
			A[0] = A[i];
			A[i] = temp;
			// Diminui o heap, pois A[i] esta posicionado
			compHeap--;
			refazHeapMax(A, 0, compHeap);
		}
		
		for (int c=0;c<A.length;c++){
		System.out.println(A[c]);
		}
	}

	public static void main(String[]args){
	new HeapSort();
	}
}
