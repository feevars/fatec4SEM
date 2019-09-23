package com.brunoharnik.estruturadados.vetor.teste;

import com.brunoharnik.estruturadados.vetor.VetorObjetos;

public class Aula10 {

	public static void main(String[] args) {
		
		VetorObjetos vetor = new VetorObjetos(3);
		
		Contato c1 = new Contato("Xexeu", "1234-5678", "contato1@cu.com");
		Contato c2 = new Contato("Alfredo", "9876-2345", "juca@kifure.com");
		Contato c3 = new Contato("Moisés", "6666-6666", "meleca@denariz.br");
		Contato c4 = new Contato("Moisés", "6666-6666", "meleca@denariz.br");
		
		vetor.adiciona(c1);
		vetor.adiciona(c2);
		vetor.adiciona(c3);
		
		System.out.println("Tamanho = " + vetor.tamanho());
		
		int pos = vetor.busca(c4);
		if (pos > -1) {
			System.out.println("O elemento existe no vetor.");		
		}else {
			System.out.println("O elemento NÃO existe no vetor.");
		}
		
		
		System.out.println(vetor);
		
 		
		

	}

}
