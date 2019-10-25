import javax.swing.SwingUtilities;

import view.QuadroPrincipal;

public class ListaDeConvidados {

	public static void main(String[] args) {
		
		//Chamada de thread do pacote Swing para otimização da execução
		//Melhor do que chamar o JFrame na main.
		SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				new QuadroPrincipal();
			}
		});

	}
}
 