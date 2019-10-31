package model;

public class Disciplina {

	private int id;
	private String nome;

	public Disciplina(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Id: " + id + "\nNome: " + nome + "\n";
	}
}
