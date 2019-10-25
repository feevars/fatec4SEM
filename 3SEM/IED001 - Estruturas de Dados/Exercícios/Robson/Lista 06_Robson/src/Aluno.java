
public class Aluno {
	int ra;
	String nome;
	String turma;
	String semestre;
	
	private Aluno(int ra, String nome, String turma, String semestre) {
		super();
		this.ra = ra;
		this.nome = nome;
		this.turma = turma;
		this.semestre = semestre;
	}

	public int getRa() {
		return ra;
	}

	public void setRa(int ra) {
		this.ra = ra;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	
	
	
	
	
}
