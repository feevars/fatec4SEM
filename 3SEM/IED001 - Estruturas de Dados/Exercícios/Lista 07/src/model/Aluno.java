package model;

public class Aluno {

	private int id;
	private String nome;
	private String curso;
	private int semestre;

	public Aluno(int id, String nome, String curso, int semestre) {
		this.id = id;
		this.nome = nome;
		this.curso = curso;
		this.semestre = semestre;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public int getSemestre() {
		return semestre;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}

	public int getId() {
		return id;
	}
}
