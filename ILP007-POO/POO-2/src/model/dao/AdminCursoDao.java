package model.dao;

import java.util.Set;

import model.entities.Aula;
import model.entities.Curso;

public interface AdminCursoDao {

	Boolean cadastrarCurso(Curso curso, Integer ... idsInstrutores);
	Boolean excluirCurso(Integer id);
	Boolean editarCurso(Curso c);
	Set<Aula> listarAulasCurso(Integer id);
}
