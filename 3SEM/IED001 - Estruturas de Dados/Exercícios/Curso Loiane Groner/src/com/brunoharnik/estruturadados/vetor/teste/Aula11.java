package com.brunoharnik.estruturadados.vetor.teste;

import com.brunoharnik.estruturadados.vetor.Lista;

public class Aula11 {

	public static void main(String[] args) {
		
		Lista<Contato> vetor = new Lista<Contato>(1);
		
		Contato c1 = new Contato("Xexeu", "1234-5678", "contato1@cu.com");
		Contato c2 = new Contato("Alfredo", "9876-2345", "juca@kifure.com");
		Contato c3 = new Contato("Moisés", "6666-6666", "meleca@denariz.br");

		vetor.adiciona(c1);
		vetor.adiciona(c2);
		
		System.out.println(vetor);

	}

}
