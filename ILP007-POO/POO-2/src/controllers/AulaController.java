package controllers;

import java.util.ArrayList;
import java.util.List;

import model.dao.AdminAulaDao;
import model.dao.implementation.AdminAulaDaoImpl;
import model.entities.Aula;
import model.entities.Curso;
import model.entities.Exercicio;

public class AulaController {
	
	private AdminAulaDao adminAulaDao = new AdminAulaDaoImpl();
	private Curso curso;
	
	
	public AulaController() {}
	
	public List<Exercicio> convertSetToList(List<Exercicio> exercicios) {
		List<Exercicio> exerciciosList = new ArrayList<>(exercicios);
		return exerciciosList;
	}
	
	public void adicionarAula(Aula a) {
		a.setNumAula(curso.getAulas().size()+1);
		adminAulaDao.cadastrarAula(a);
		curso.getAulas().add(a);
	}
	
	public void removerAula(Integer id) {}

	public void editarAula(Integer id) {}

	
	public void getListaDeAulas(Integer idCurso) {
		
	}
}
