package controller;

public class OperacoesController {
	
	public OperacoesController(){
		super();
	}
	
	public void concatenaString(){
		String palavra = "";
		
		double tempoInicial = System.nanoTime();
		for(int i = 0; i < 32768; i++){
			palavra += "a";
		}
		double tempoFinal = System.nanoTime();
		double tempoTotal = tempoFinal - tempoInicial;
		tempoTotal = tempoTotal/Math.pow(10, 9);
		System.out.println("Concatenado: " + tempoTotal + " segundos");
	}
	
	public void concatenaBuffer(){
		StringBuffer buffer = new StringBuffer();
		
		double tempoInicial = System.nanoTime();
		for(int i = 0; i < 32768; i++){
			buffer.append("a");
		}
		double tempoFinal = System.nanoTime();
		double tempoTotal = tempoFinal - tempoInicial;
		tempoTotal = tempoTotal/Math.pow(10, 9);
		System.out.println("Em buffer: " + tempoTotal + " segundos");
	}
	public void operacaoString(String frase){
		String[] vetorPalavras = frase.split(" ");
		for (String palavra : vetorPalavras){
			System.out.println(palavra);
		}
	}
}
