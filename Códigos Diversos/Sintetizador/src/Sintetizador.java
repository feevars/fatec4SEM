import javax.swing.SwingUtilities;

import view.QuadroPrincipal;

public class Sintetizador {

	public static void main(String[] args) {
		
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				
				new QuadroPrincipal();
			}
		});
	}

}
