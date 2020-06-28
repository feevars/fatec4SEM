package model.dao;

import model.entities.Curso;
import model.entities.Estudante;

public interface EstudanteDao {

	public void cadastrar(Estudante estudante);
	
	public void editarPerfil(Estudante estudante);

	public void verCurso(Integer idCurso);
	
	public void verAula(Integer idAula);
	
	public void realizarExercicios(Integer idAula);
	
	public void iniciarCurso(Integer idEstudante, Integer idCurso);
	
	public void concluirCurso(Integer idEstudante, Integer idCurso);
	
}
