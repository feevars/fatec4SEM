package com.brunoharnik.estruturadados.pilha.teste;

import com.brunoharnik.estruturadados.pilha.Pilha;

public class Aula17 {

	public static void main(String[] args) {
		
		Pilha<Integer> pilha = new Pilha<Integer>();
		
		pilha.empilha(234);
		pilha.empilha(456);
		pilha.empilha(789);
		
		System.out.println(pilha);
		
		System.out.println("Desempilhando o elemento " + pilha.desempilha());
		
		System.out.println(pilha);
		
	}

}
