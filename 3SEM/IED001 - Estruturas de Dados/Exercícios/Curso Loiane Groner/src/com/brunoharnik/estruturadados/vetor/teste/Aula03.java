package com.brunoharnik.estruturadados.vetor.teste;

import com.brunoharnik.estruturadados.vetor.Vetor;

public class Aula03 {

	public static void main(String[] args) {

		Vetor vetor = new Vetor(3);
		
		
		vetor.adiciona("Elemento 1");
		vetor.adiciona("Elemento 2");
		vetor.adiciona("Elemento 3");
		
		
		
		for (int i = 0; i < 3; i++) {
			
			System.out.println(vetor);
			
		}

	}

}
