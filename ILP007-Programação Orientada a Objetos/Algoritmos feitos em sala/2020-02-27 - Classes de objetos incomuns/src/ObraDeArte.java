import java.util.Date;

public abstract class ObraDeArte {

	String titulo;
	String descricao;
	Artista autor;
	Date dataCriacao;
	
	public ObraDeArte(String titulo, String descricao, Artista autor, Date dataCriacao) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
		this.autor = autor;
		this.dataCriacao = dataCriacao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Artista getAutor() {
		return autor;
	}

	public void setAutor(Artista autor) {
		this.autor = autor;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
}
