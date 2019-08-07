package view;

import controller.OperacoesController;

public class Principal {

	public static void main(String[] args) {
		
		OperacoesController op = new OperacoesController();
		//op.concatenaString();
		//op.concatenaBuffer();
		String frase = "Hoje a noite está escura e fria.";
		op.operacaoString(frase);
	}
	
}
