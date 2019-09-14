package controller;

public enum CorSemaforo {
	
	VERDE(2000), AMARELO(1000), VERMELHO(3000);
	
	private int tempoEspera;
	
	CorSemaforo(int tempoEspera){
		this.tempoEspera = tempoEspera;
	}
	
	public int getTempoEspera() {
		return tempoEspera;
	}
}
