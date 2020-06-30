package model.dao;

import model.entities.Estudante;

public interface EstudanteDao {
	
	public Boolean estudanteLogin(String username, String email, String password);

	public void estudanteCadastro(Estudante estudante);
	
	public Boolean estudanteEditarPerfil(Estudante estudante, Boolean eInstrutor);
	
	public Boolean estudanteExcluirPerfil(Integer id);

	public void estudanteVerCurso(Integer idCurso);
	
	public void estudanteVerAula(Integer idAula);
	
	public void estudanteRealizarExercicios(Integer idAula);
	
	public Boolean estudanteIniciarCurso(Integer idEstudante, Integer idCurso);
	
	public Boolean estudanteConcluirCurso(Integer idEstudante, Integer idCurso);
	
	public Integer validaCadastroEstudante(Estudante usuario);
	
	public Estudante getEstudantePorId(Integer id);
	
	public Estudante getEstudantePorUsername(String username);
	
}
