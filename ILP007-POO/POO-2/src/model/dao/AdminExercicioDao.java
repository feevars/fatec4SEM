package model.dao;

import java.util.List;

import model.entities.Exercicio;

public interface AdminExercicioDao {
	void cadastrarExercicio(Exercicio exercicio);
	
	boolean excluirExercicio(Integer idExec);
	
	boolean editarExercicio(Exercicio exercicio);
	
	List<Exercicio> getListaExercicios(Integer idAula);
}
