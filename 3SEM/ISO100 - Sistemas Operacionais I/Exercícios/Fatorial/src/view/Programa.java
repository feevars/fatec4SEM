package view;

import javax.swing.JOptionPane;

import controller.FatorialLoop;
import controller.FatorialRecursivo;

public class Programa {

	public static void main(String[] args) {
		
		int n;
		
		do {
			n = Integer.parseInt(JOptionPane.showInputDialog("Digite o número que você deseja calcular o fatorial:"
					+ "\n(inteiro entre 1 e 100000)"));
		} while (n < 1 && n > 100000);
		
		
		FatorialLoop fl = new FatorialLoop(n);
		
		try {
			fl.start();
			fl.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		FatorialRecursivo fr = new FatorialRecursivo(n);

		try {
			fr.start();
			fr.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		

		JOptionPane.showMessageDialog(null, fl.getResultado() + fr.getResultado(), "Fatoriais", 1);
	}

}
