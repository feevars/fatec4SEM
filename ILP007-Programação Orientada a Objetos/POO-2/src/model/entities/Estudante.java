package model.entities;

import java.util.Date;
import java.util.Set;

public class Estudante extends Usuario {

//	private String matricula;
	private Integer pontos;
	private Set<Curso> inscricoes;

	public Estudante(Integer id, String nome, String sobrenome, String email, String telefone, Date dataNascimento, String cpf,
			String sexo, String matricula, Integer pontos) {
		super(id, nome, sobrenome, email, telefone, dataNascimento, cpf, sexo);
		
//		this.matricula = matricula;
		this.pontos = pontos;
		
	}
	
//	public String getMatricula() {
//		return matricula;
//	}

	public void setMatricula(String matricula) {
//		this.matricula = matricula;
	}

	public Integer getPontos() {
		return pontos;
	}

	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}

	public void inscreverEmCurso() {
		System.out.println("me inscrevi em mais um curso.");
	}

}
