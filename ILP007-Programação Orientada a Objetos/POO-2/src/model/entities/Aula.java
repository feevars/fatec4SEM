package model.entities;

public class Aula {
	
	private Integer id;
	private String nome;
	private String descricao;
	private String linkVideo;
	
	private Aula(Integer id, String nome, String descricao, String linkVideo) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.linkVideo = linkVideo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getLinkVideo() {
		return linkVideo;
	}
	
	public void setLinkVideo(String linkVideo) {
		this.linkVideo = linkVideo;
	}
}
