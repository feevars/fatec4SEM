package model;

public class Livro {
	
	private String isbn;
	private String titulo;
	private String autor;
	private String editora;
	private int anoLancamento;
	private int edicao;
	
	public Livro() {
		super();
	}
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public int getAnoLancamento() {
		return anoLancamento;
	}
	public void setAnoLancamento(int anoLancamento) {
		this.anoLancamento = anoLancamento;
	}
	public int getEdicao() {
		return edicao;
	}
	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}

	@Override
	public String toString() {
		return "Livro: \"" + titulo + "\"\nISBN: " + isbn + "\nAutor(a): " + autor + "\nEditora: " + editora
				+ "\nAno de lançamento: " + anoLancamento + "\nEdição: " + edicao;
	}
	
	
	
	
	
}
