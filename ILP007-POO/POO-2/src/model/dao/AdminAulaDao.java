package model.dao;

import java.util.List;
import model.entities.Aula;

public interface AdminAulaDao {

	void cadastrarAula(Aula aula);
	
	void excluirAula(Integer id);
	
	boolean editarAula(Aula aula);
	
	List<Aula> listarAula(Aula aula);
}
