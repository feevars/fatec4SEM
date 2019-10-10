package controller;

import java.math.BigInteger;

public class FatorialLoop extends Thread{

	private long n;
	private String resultado;
	
	public FatorialLoop(long n) {
		this.n = n;
	}
	
	public String getResultado() {
		return resultado;
	}
	
	@Override
	public void run() {
		long tempoInicio = System.nanoTime();
		resultado = "Fatorial em loop de " + n + ":\n" + fatorial(n) + "\n\nTempo de execução: " + ((double)(System.nanoTime() - tempoInicio) / 100000) + " milissegundos.\n\n";
	}
	
	public BigInteger fatorial(long n) {
		
		BigInteger fatorial = BigInteger.valueOf(n);
		
		for (int i = 1; i < n; i++) {
			fatorial = fatorial.multiply(BigInteger.valueOf(i));
		}
		
		return fatorial;
	}

}
