package edu.nobreza;

import java.util.ArrayList;
import java.util.List;

public class Nobre {
public String nome;
	
	public List<Soldado> soldados = new ArrayList<Soldado>();
	public Conselheiro conselheiro = new Conselheiro();
	
	public void governar() {
		System.out.println(nome + " está governando.");
	}
}
