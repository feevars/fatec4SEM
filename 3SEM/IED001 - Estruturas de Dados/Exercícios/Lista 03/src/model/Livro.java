package model;

public class Livro {
	
	private int codigo;
	private String nome;
	
	public Livro (int codigo, String nome) {
		this.setCodigo(codigo);
		this.setNome(nome);
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
