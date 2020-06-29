package model.dao;

import model.entities.Estudante;

public interface EstudanteDao {

	public void estudanteCadastro(Estudante estudante);
	
	public void estudanteEditarPerfil(Estudante estudante);

	public void estudanteVerCurso(Integer idCurso);
	
	public void estudanteVerAula(Integer idAula);
	
	public void estudanteRealizarExercicios(Integer idAula);
	
	public void estudanteIniciarCurso(Integer idEstudante, Integer idCurso);
	
	public void estudanteConcluirCurso(Integer idEstudante, Integer idCurso);
	
	public Integer validaCadastroEstudante(Estudante usuario);
	
}
