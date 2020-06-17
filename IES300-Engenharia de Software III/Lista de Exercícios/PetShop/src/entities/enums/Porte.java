package entities.enums;

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
