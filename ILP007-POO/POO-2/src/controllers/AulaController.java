package controllers;

import java.util.ArrayList;
import java.util.List;

import model.entities.Exercicio;

public class AulaController {

	public List<Exercicio> convertSetToList(List<Exercicio> exercicios) {
		List<Exercicio> exerciciosList = new ArrayList<>(exercicios);
		return exerciciosList;
	}
	
	public void getLista() {
		
	}
}
