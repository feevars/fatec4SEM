package model;

public class Media {

	private int idAluno;
	private int idDisciplina;
	private double mediaFinal;

	public Media(int idAluno, int idDisciplina, double mediaFinal) {
		this.idAluno = idAluno;
		this.idDisciplina = idDisciplina;
		this.mediaFinal = mediaFinal;
	}

	public int getIdAluno() {
		return idAluno;
	}

	public int getIdDisciplina() {
		return idDisciplina;
	}

	public double getMediaFinal() {
		return mediaFinal;
	}

	public void setMediaFinal(double mediaFinal) {
		this.mediaFinal = mediaFinal;
	}
	
	public String toString() {
		return "Id Aluno: " + idAluno + "\tId da Disciplina: " + idDisciplina + "\nMédia: " + mediaFinal + "\n";
	}
}
