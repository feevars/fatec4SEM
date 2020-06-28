package model.dao;

import model.entities.Aula;

public interface AdminAulaDao {

	void adicionarAula(Aula a);
	
	void removerAula(Aula a);
	
	void editarAula(Aula a);
}
