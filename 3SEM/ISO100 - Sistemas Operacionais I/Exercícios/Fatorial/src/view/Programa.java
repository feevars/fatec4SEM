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
		} while (n < 1);
		
		
		FatorialRecursivo fr = new FatorialRecursivo(n);
		FatorialLoop fl = new FatorialLoop(n);
		
		try {
			fr.start();
			fr.join();
			fl.start();
			fl.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		JOptionPane.showMessageDialog(null, fr.getResultado() + fl.getResultado(), "Fatoriais", 1);
	}

}
