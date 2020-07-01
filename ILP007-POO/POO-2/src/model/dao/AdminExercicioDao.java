package model.dao;

import model.entities.Exercicio;

public interface AdminExercicioDao {
	void cadastrarExercicio(Exercicio exercicio);
	
	boolean excluirExercicio(Integer id);
	
	boolean editarExercicio(Exercicio exercicio);
}
