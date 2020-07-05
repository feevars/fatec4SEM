package model.dao;

import java.util.Set;

import model.entities.Curso;

public interface CursoDao {

	Integer inserir(Curso curso);
	Boolean atualizar(Curso curso);
	Boolean removerRa(String ra);
	Curso pesquisarPorRa(String ra);
	Set<Curso> listarTodosOsCursos();
}
