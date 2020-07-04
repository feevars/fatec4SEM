package model.dao;

import java.util.List;
import model.entities.Aula;
import model.entities.Exercicio;

public interface AdminAulaDao {

	Integer cadastrarAula(Aula aula, Integer cursoId);
		
	void excluirAula(Integer aulaId);
	
	boolean editarAula(Aula aula);
	
	List<Exercicio> listarExercicios(Integer aulaId);
	
	List<Aula> listarAulas();
	
	Aula getAulaPorId(Integer aulaId);
}
