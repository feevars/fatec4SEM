package controller;

import java.math.BigInteger;

public class FatorialRecursivo extends Thread {
	
	private long n;
	private String resultado;
	
	public FatorialRecursivo(long n) {
		this.n = n;
	}


	public String getResultado() {
		return resultado;
	}

	@Override
	public void run() {
		long tempoInicio = System.nanoTime();
		resultado = "Fatorial recursivo de " + n + ":\n" + fatorial(n) + "\n\nTempo de execução: " + ((double) (System.nanoTime() - tempoInicio) / 100000) + " milissegundos.\n\n";
	}
	
	public BigInteger fatorial(long n) {
		
		BigInteger numero = BigInteger.ONE;
		BigInteger fatorial = BigInteger.valueOf(n);
		
		if(n == 1) {
			return numero;
		}else {
			return fatorial.multiply(fatorial(n-1));
		}
	}
}
