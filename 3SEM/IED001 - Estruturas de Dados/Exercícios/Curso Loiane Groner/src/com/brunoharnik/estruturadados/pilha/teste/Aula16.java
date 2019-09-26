package com.brunoharnik.estruturadados.pilha.teste;

import com.brunoharnik.estruturadados.pilha.Pilha;

public class Aula16 {

	public static void main(String[] args) {
		
		Pilha<Integer> pilha = new Pilha<Integer>();
		
		System.out.println(pilha.topo());
		
		System.out.println(pilha);
		
		pilha.empilha(51);
		pilha.empilha(666);
		
		System.out.println(pilha.topo());
		
		System.out.println(pilha);
	}

}
