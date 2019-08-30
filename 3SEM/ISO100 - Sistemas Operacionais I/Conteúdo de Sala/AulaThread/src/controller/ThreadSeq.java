package controller;

public class ThreadSeq extends Thread {
	
	private int n;

	public ThreadSeq(int n) {
		this.n = n;
	}
	
	public void run() {
		// TODO Auto-generated method stub
		seq();
	}
	
	
	
	public void seq(){
		
		int aux = 0;
		double res = 0;
		String seqtxt = "";
		
		
		for(double i = 1; i <= n; i += 2) {
			
			if(aux == 0) {
				res += (1/i);
				seqtxt += "4 * (1/1";
			}
			else if(aux % 2 != 0) {
				res -= (1/i);
				seqtxt += " - 1/" + i;
			}else{
				res += (1/i);
				seqtxt += " + 1/" + i;
			}
			
			if(i == n) {
				seqtxt += ")";
				res *= 4;
			}
			aux++;
				
		}
		
		System.out.println(seqtxt + "\nn = " + n + "\nResultado da sequência = " + res + "\n\n" );
		
	}
	
}
