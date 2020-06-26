package model.entities;

import java.util.Date;
import java.util.Set;

public class Administrador extends Usuario {
	
	public Administrador(Integer id, String nome, String sobrenome, String email, String telefone, Date dataNascimento,
			String cpf, String sexo) {
		super(id, nome, sobrenome, email, telefone, dataNascimento, cpf, sexo);
		// TODO Auto-generated constructor stub
	}

	
    public boolean adicionarNovoCurso(Curso curso, Set<Curso> cursos) {
    	for (Curso c : cursos) {
			if (c == curso){
				//fazer uma classe de alerts pra só puxar os alerts de lá
				System.out.println(("curso ja existe"));
			}
		}
    	return false;
    }
}
