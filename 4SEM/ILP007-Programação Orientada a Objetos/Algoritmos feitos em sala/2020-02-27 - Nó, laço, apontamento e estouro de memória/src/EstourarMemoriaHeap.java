
public class EstourarMemoriaHeap {

	static int [] vector = new int[100];
	static EstourarMemoriaHeap proximo;
	
	public static void main(String[] args) throws InterruptedException{
		
		System.out.println("Tentando estourar a memória heap...");
		EstourarMemoriaHeap raiz = new EstourarMemoriaHeap();
		EstourarMemoriaHeap ultimo = raiz;
		
		while(true) {
			ultimo.proximo = new EstourarMemoriaHeap();
			ultimo = ultimo.proximo;
			
			Thread.sleep(1);
			
		}
	}

}
