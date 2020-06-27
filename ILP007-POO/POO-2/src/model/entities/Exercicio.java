package model.entities;

public class Exercicio {

	private Integer id;
	private String tituloExercicio;
	private String questaoExercico;
	private String alternativaCorreta;
	private String alternativaIncorreta1;
	private String alternativaIncorreta2;
	private String alternativaIncorreta3;
	private String alternativaIncorreta4;
	private String explicacao;
	private Integer tempoResposta;
	private Integer pontos;
	
	public Exercicio(Integer id, String tituloExercicio, String questaoExercico, String alternativaCorreta,
			String alternativaIncorreta1, String alternativaIncorreta2, String alternativaIncorreta3,
			String alternativaIncorreta4, String explicacao, Integer tempoResposta, Integer pontos) {
		super();
		this.id = id;
		this.tituloExercicio = tituloExercicio;
		this.questaoExercico = questaoExercico;
		this.alternativaCorreta = alternativaCorreta;
		this.alternativaIncorreta1 = alternativaIncorreta1;
		this.alternativaIncorreta2 = alternativaIncorreta2;
		this.alternativaIncorreta3 = alternativaIncorreta3;
		this.alternativaIncorreta4 = alternativaIncorreta4;
		this.explicacao = explicacao;
		this.tempoResposta = tempoResposta;
		this.pontos = pontos;
	}

	public String getTituloExercicio() {
		return tituloExercicio;
	}

	public void setTituloExercicio(String tituloExercicio) {
		this.tituloExercicio = tituloExercicio;
	}

	public String getQuestaoExercico() {
		return questaoExercico;
	}

	public void setQuestaoExercico(String questaoExercico) {
		this.questaoExercico = questaoExercico;
	}

	public String getAlternativaCorreta() {
		return alternativaCorreta;
	}

	public void setAlternativaCorreta(String alternativaCorreta) {
		this.alternativaCorreta = alternativaCorreta;
	}

	public String getAlternativaIncorreta1() {
		return alternativaIncorreta1;
	}

	public void setAlternativaIncorreta1(String alternativaIncorreta1) {
		this.alternativaIncorreta1 = alternativaIncorreta1;
	}

	public String getAlternativaIncorreta2() {
		return alternativaIncorreta2;
	}

	public void setAlternativaIncorreta2(String alternativaIncorreta2) {
		this.alternativaIncorreta2 = alternativaIncorreta2;
	}

	public String getAlternativaIncorreta3() {
		return alternativaIncorreta3;
	}

	public void setAlternativaIncorreta3(String alternativaIncorreta3) {
		this.alternativaIncorreta3 = alternativaIncorreta3;
	}

	public String getAlternativaIncorreta4() {
		return alternativaIncorreta4;
	}

	public void setAlternativaIncorreta4(String alternativaIncorreta4) {
		this.alternativaIncorreta4 = alternativaIncorreta4;
	}

	public String getExplicacao() {
		return explicacao;
	}

	public void setExplicacao(String explicacao) {
		this.explicacao = explicacao;
	}

	public Integer getTempoResposta() {
		return tempoResposta;
	}

	public void setTempoResposta(Integer tempoResposta) {
		this.tempoResposta = tempoResposta;
	}

	public Integer getPontos() {
		return pontos;
	}

	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}

	public Integer getId() {
		return id;
	}
		
}
