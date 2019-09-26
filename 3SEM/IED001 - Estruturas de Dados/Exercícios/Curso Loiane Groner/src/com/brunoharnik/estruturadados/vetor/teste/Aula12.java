package com.brunoharnik.estruturadados.vetor.teste;

import java.util.ArrayList;

public class Aula12 {

	public static void main(String[] args) {

		ArrayList<String> arrayList = new ArrayList<String>();
		
		arrayList.add("A");
		arrayList.add("C");

		System.out.println(arrayList);
		
		arrayList.add(1, "B");

		System.out.println(arrayList);
		
		boolean existe = arrayList.contains("Fuleco");
		if (existe) {
			System.out.println("Elemento existe.");
		}else {
			System.out.println("Não há.");
		}
		
		int pos = arrayList.indexOf("J");
		
		if (pos > -1) {
			System.out.println("O elemento está na posição " + pos + " do array.");
		}else {
			System.out.println("O elemento não existe no array. Resposta do indexOf: " + pos);
		}
		
		System.out.println(arrayList.get(2));
		
		arrayList.remove(0);
		arrayList.remove("B");
		
		System.out.println(arrayList);
		
		System.out.println(arrayList.size());
		
		
	}

}
