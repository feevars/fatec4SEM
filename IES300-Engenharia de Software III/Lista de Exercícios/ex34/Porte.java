package ex34;

public enum Porte {

	PEQUENO ('P'),

	MEDIO ('M'),

	GRANDE('G');
	
	private char numero;
	
	private Porte(char numero) {
		this.numero = numero;
	}

	public char getPorte() {
		return numero;
	}
}
