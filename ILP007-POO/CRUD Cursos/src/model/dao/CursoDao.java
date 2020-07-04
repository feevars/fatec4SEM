package model.dao;

import java.util.List;
import java.util.Set;
import model.entities.Aula;
import model.entities.Curso;
import model.entities.Instrutor;

public interface CursoDao {

	Integer cadastrarCurso(Curso curso);
	Boolean excluirCurso(Integer id);
	Boolean editarCurso(Curso c);
	Boolean atualizarInstrutoresCurso(Integer cursoId, Set<Instrutor> instrutores);
	Boolean adicionarInstrutorCurso(Integer instrutorId, Integer cursoId);
	Set<Aula> listarAulasCurso(Integer cursoId);
	List<Instrutor> listarInstrutores();
	Set<Instrutor> listarInstrutoresPorCurso(Integer cursoId);
	Set<Curso> listarCursosPorInstrutor(Integer instrutorId);
	Boolean verificaAutoria(Integer instrutorId, Integer cursoId);
	Curso getCursoPorId(Integer cursoId);
}
