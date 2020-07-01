package model.dao;

import java.util.List;
import model.entities.Aula;
import model.entities.Exercicio;

public interface AdminAulaDao {

	void cadastrarAula(Aula aula, Integer cursoId);
		
	void excluirAula(Integer id);
	
	boolean editarAula(Aula aula);
	
	List<Exercicio> listarExercicios(Integer idAula);
	
	List<Aula> listarAulas();
}
