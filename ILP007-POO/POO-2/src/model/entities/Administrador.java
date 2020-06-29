package model.entities;

import java.util.Set;
import org.hibernate.validator.constraints.NotBlank;


public class Administrador {
	
	private Integer id;
	private String username;
	private String password;	
	
	public Administrador() {	
	}
	
	public Administrador(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public Administrador(Integer id, String username) {
		super();
		this.id = id;
		this.username = username;
	}

	@NotBlank
    public String getUsername() {
		return username;
	}

	
	public void setUsername(String username) {
		this.username = username;
	}

	@NotBlank
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Integer getId() {
		return id;
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
