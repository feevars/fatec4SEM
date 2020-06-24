
public class Cliente {

	static int numConsultas;
	
	
	public static int obterNumConsultas() {
		return numConsultas;
	}
	
	public static void zerarConsultasAcumuladas(int numConsultas) {
		numConsultas = numConsultas*0;
	}
}
