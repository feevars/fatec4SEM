package model.dao;

import model.entities.Curso;

public interface CursoDao {

	Integer cadastrarCurso(Curso curso);
	Boolean excluirCurso(Integer id);
	Boolean editarCurso(Curso c);
	Boolean adicionarInstrutorCurso(Integer instrutorId, Integer cursoId);
	Boolean verificaAutoria(Integer instrutorId, Integer cursoId);
	Curso getCursoPorId(Integer cursoId);
}
