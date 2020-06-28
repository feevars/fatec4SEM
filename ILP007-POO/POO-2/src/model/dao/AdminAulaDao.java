package model.dao;

import java.util.List;
import java.util.Set;

import model.entities.Aula;
import model.entities.Exercicio;

public interface AdminAulaDao {

	void cadastrarAula(Aula aula);
	
	void excluirAula(Integer id);
	
	boolean editarAula(Aula aula);
	
	boolean exibirAula(Integer id);
	
	List<Exercicio> listarExercicios(Set<Exercicio> exercicios);
}
