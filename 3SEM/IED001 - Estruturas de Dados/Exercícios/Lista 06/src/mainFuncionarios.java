import javax.swing.SwingUtilities;

import view.QuadroPrincipal;

public class mainFuncionarios {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				new QuadroPrincipal();
			}
		});

	}
}
 