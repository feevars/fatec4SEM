package model.entities;

import java.util.Set;

public class Aula {

	private Integer id;
	private String titulo;
	private String descricao;
	private String linkVideo;
	private String transcricaoVideo;
	private Integer tempoVideo;
	private Integer numAula;
	private Integer cursoId;
	private Set<Exercicio> exercicios;

	public Aula(Integer id, String titulo, String descricao, String linkVideo, String transcricaoVideo,
			Integer tempoVideo, Integer numAula, Integer cursoId, Set<Exercicio> exercicios) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.linkVideo = linkVideo;
		this.transcricaoVideo = transcricaoVideo;
		this.tempoVideo = tempoVideo;
		this.numAula = numAula;
		this.cursoId = cursoId;
		this.exercicios = exercicios;
	}

	public Aula() {}
	
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

	public String getLinkVideo() {
		return linkVideo;
	}

	public void setLinkVideo(String linkVideo) {
		this.linkVideo = linkVideo;
	}

	public String getTranscricaoVideo() {
		return transcricaoVideo;
	}

	public void setTranscricaoVideo(String transcricaoVideo) {
		this.transcricaoVideo = transcricaoVideo;
	}

	public Integer getTempoVideo() {
		return tempoVideo;
	}

	public void setTempoVideo(Integer tempoVideo) {
		this.tempoVideo = tempoVideo;
	}

	public Set<Exercicio> getExercicios() {
		return exercicios;
	}

	public void setExercicios(Set<Exercicio> exercicios) {
		this.exercicios = exercicios;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumAula() {
		return numAula;
	}

	public void setNumAula(Integer numAula) {
		this.numAula = numAula;
	}

	public Integer getCursoId() {
		return cursoId;
	}

	public void setCursoId(Integer cursoId) {
		this.cursoId = cursoId;
	}
}
