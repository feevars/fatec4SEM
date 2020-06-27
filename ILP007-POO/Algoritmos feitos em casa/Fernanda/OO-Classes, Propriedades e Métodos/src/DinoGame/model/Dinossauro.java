package model;

public class Dinossauro {
	int energia;
	int velocidade;
	int temperatura;
	int humor;

	public void pular() {
		if (energia < 2 || temperatura < 2) {
			System.out.println("cansado demais para pular...preciso co(M)er ou ficar na s(O)mbra");
		} else {
		energia -= 1;
		humor += 1;
		System.out.println("exercício, vamos lá!!");
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
		System.out.println("nham nham nham nham raaawwesrrrrr");
	}

	public void atirar() {
		if (energia < 2 || temperatura < 2) {
			System.out.println("fraco...preciso co(M)er ou ficar na s(O)mbra");
		} else {
		energia -= 1;
		humor += 1;
		System.out.println("pew pew pew... raaawssssrrrr");
		}
	}

	public void tomarSol() {
		velocidade += 1;
		temperatura += 2;
		humor += 1;
		System.out.println("raaaaaawsrrr...banho de soooool");
	}

	public void ficarNaSombra() {
		energia += 1;
		humor -= 1;
		temperatura -= 1;
		System.out.println("Skeep descansando... mas Skeep prefere o sol...");
	}
	
	public void status() {
		System.out.println("Energia: " +energia);
		System.out.println("Velocidade: " +velocidade);
		System.out.println("Temperatura: " +temperatura);
		System.out.println("Humor: " +humor 
				+"\n----------------------------------------------------------");
	}
	
	//public void verifica () {
		//verificaEnergia();
		//verificaTemperatura();
		//verificaHumor();
		//verificaVelocidade();
		//if (energia < 2) {
			//System.out.println("Skeep fraco... escolha co(M)er ou ficar na s(O)mbra");
		//} else if (temperatura > )
}
