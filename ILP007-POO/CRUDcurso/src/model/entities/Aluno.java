package model.entities;

import java.time.LocalDate;

import javax.validation.constraints.Size;

public class Aluno {

	private Integer id;
	private String ra;
	private String nome;
	private LocalDate nascimento;

	public Aluno(Integer id, String ra, String nome, LocalDate nascimento) {
		this.id = id;
		this.ra = ra;
		this.nome = nome;
		this.nascimento = nascimento;
	}

	public Integer getId() {
		return id;
	}
	@Size(min = 5, max = 5, message = "RA pode ser somente de 5 dígitos.")
	public String getRa() {
		return ra;
	}

	public void setRa(String ra) {
		this.ra = ra;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}

}
