package model.dao;

import java.util.List;
import java.util.Set;
import model.entities.Aula;
import model.entities.Curso;
import model.entities.Instrutor;

public interface AdminCursoDao {

	Integer cadastrarCurso(Curso curso);
	Boolean cadastrarInstrutorCurso(Integer instrutorId, Integer cursoId);
	Boolean excluirCurso(Integer id);
	Boolean editarCurso(Curso c);
	Boolean adicionarInstrutorCurso(Integer instrutorId, Integer cursoId);
	Set<Aula> listarAulasCurso(Integer cursoId);
	List<Instrutor> listarInstrutores();
	Set<Instrutor> listarInstrutoresPorCurso(Integer cursoId);
	Set<Curso> listarCursosPorInstrutor(Integer instrutorId);
	Boolean verificaAutoria(Integer instrutorId, Integer cursoId);
}
