package model.entities;

public enum nivelCurso {
	BASICO(1),
	INTERMEDIARIO(2),
	AVANCADO(3);
	
	private int indice;

	nivelCurso(int indice) {
		this.indice = indice;
	}
	
	public int getIndice() {
		return indice;
	}
}
