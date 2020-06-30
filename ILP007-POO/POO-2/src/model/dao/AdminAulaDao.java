package model.dao;

import java.util.List;
import java.util.Set;

import model.entities.Aula;
import model.entities.Exercicio;

public interface AdminAulaDao {

	void cadastrarAula(Aula aula);
	
	void excluirAula(Integer id);
	
	boolean editarAula(Aula aula);
	
	List<Exercicio> listarExercicios(Integer idAula);
	
	List<Aula> listarAulas();
}
