
public class Dinossauro {
	int energia;
	int velocidade;
	int temperatura;
	int humor;

	public void pular() {
		if (energia < 2 || temperatura < 2) {
			System.out.println("Não tenho energia. Preciso co(M)er ou ficar na s(O)mbra");
		} else {
		energia -= 1;
		humor += 1;
		System.out.println("Exercitando-me");
		}
	}

	public void correr() {
		if (energia < 2 || temperatura < 2) {
			System.out.println("fraco...não consigo correr...preciso co(M)er ou ficar na s(O)mbra");
		} else {
			energia -= 2;
		}
	}

	public void comer() {
		energia += 1;
		humor += 1;
		System.out.println("Comendo bastante");
	}

	public void atirar() {
		if (energia < 2 || temperatura < 2) {
			System.out.println("Não tenho energia. Preciso co(M)er ou ficar na s(O)mbra");
		} else {
		energia -= 1;
		humor += 1;
		System.out.println("Atirando nervoso");
		}
	}

	public void tomarSol() {
		velocidade += 1;
		temperatura += 2;
		humor += 1;
		System.out.println("Tomando um solzinho");
	}

	public void ficarNaSombra() {
		energia += 1;
		humor -= 1;
		temperatura -= 1;
		System.out.println("Descansando na sombra...");
	}
	
	public void status() {
		System.out.println("Energia: " +energia);
		System.out.println("Velocidade: " +velocidade);
		System.out.println("Temperatura: " +temperatura);
		System.out.println("Humor: " +humor 
				+"\n----------------------------------------------------------");
	}
}
