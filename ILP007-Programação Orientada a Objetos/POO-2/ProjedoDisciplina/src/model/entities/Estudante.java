package model.entities;

import java.sql.Date;
import java.util.Set;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class Estudante {

	private Integer id;
	private String username;
	private String password;
	private String nome;
	private String sobrenome;
	private String email;
	private String telefone;
	private Date dataNascimento;
	private Integer pontos;
	private Set<Curso> cursosConcluidos;
	
	public Estudante(Integer id, String username, String password, String nome, String sobrenome, String email, String telefone,
			Date dataNascimento, Integer pontos, Set<Curso> cursosConcluidos) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.pontos = pontos;
		this.cursosConcluidos = cursosConcluidos;
	}
	
	public Estudante(Integer id, String username, String nome, String sobrenome, String email, String telefone,
			Date dataNascimento, Integer pontos) {
		super();
		this.id = id;
		this.username = username;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.pontos = pontos;
	}
	
	public Estudante(Integer id){
		this.id = id;
	}
	
	public Estudante() {}

	public Estudante(int id, String username, String nome, String sobrenome) {
		this.id = id;
		this.username = username;
		this.nome = nome;
		this.sobrenome = sobrenome;
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
	
	@NotBlank
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	@NotBlank @Email
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	@Size(min=10, max=13)
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Integer getId() {
		return id;
	}

	public Integer getPontos() {
		return pontos;
	}

	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}

	public Set<Curso> getCursosConcluidos() {
		return cursosConcluidos;
	}

	public void setCursosConcluidos(Set<Curso> cursosConcluidos) {
		this.cursosConcluidos = cursosConcluidos;
	}
	
	public String getNomeDoObjeto() {
		return "Estudante";
	}
}
