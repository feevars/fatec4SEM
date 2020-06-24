
public enum Consulta {
	NORMAL('N'),
	RETORNO('R'),
	VACINA('V'),
	CIRURGIA('C');
	
	private char letra;
	
	private Consulta(char letra) {
		this.letra = letra;
	}

	public char getConsulta() {
		return letra;
	}
}
