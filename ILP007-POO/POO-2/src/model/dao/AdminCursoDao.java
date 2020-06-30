package model.dao;

import java.util.List;
import java.util.Set;

import model.entities.Aula;
import model.entities.Curso;
import model.entities.Instrutor;

public interface AdminCursoDao {

	Boolean cadastrarCurso(Curso curso, Integer ... idsInstrutores);
	Boolean excluirCurso(Integer id);
	Boolean editarCurso(Curso c);
	Set<Aula> listarAulasCurso(Integer id);
	List<Instrutor> listarInstrutores();
	List<Instrutor> listarInstrutoresCurso(Integer cursoId);
}
