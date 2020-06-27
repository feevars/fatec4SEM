package model.entities;

import java.util.Date;
import java.util.Set;

public class Estudante extends Usuario {

	public Estudante(Integer id, String username, String nome, String sobrenome, String email, String telefone,
			Date dataNascimento, Integer pontos, Set<Curso> cursosConcluidos) {
		super(id, username, nome, sobrenome, email, telefone, dataNascimento, pontos, cursosConcluidos);
		// TODO Auto-generated constructor stub
	}


}
