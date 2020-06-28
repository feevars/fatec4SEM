package model.dao;

import model.entities.Exercicio;

public interface AdminExercicioDao {
	void cadastrarExercicio(Exercicio exercicio);
	
	void excluirExercicio(Integer id);
	
	boolean editarExercicio(Exercicio exercicio);
}
