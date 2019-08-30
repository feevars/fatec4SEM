package view;

//import controller.ThreadCalc;
import controller.ThreadSeq;

public class Principal {
	
	public static void main(String[] args) {
		
	//	int a = 10;
	//	int b = 2;
	//	int op = 2;
		
		
	/*	for (int op = 0; op < 4; op++) {
			Thread t = new ThreadCalc(a,b, op);
			t.start();
		}*/
		
	
		
	for(int i = 0; i < 10; i++) {
		
		int n = (int) (Math.random() * 99) + 1;
		
		if(n % 2 == 0) {
			
			n = n + 1;
			
		}
		
		Thread s = new ThreadSeq(n);
		s.start();
		
	}
	
	} 
}
