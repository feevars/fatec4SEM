import java.awt.event.WindowEvent;
import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;

import view.QuadroPrincipal;

public class ListaDeConvidados {

	public static void main(String[] args) {

		// Chamada de thread do pacote Swing para otimização da execução
		// Melhor do que chamar o JFrame na main.
		SwingUtilities.invokeLater(new Runnable() {

			public void run() {
				try {
					for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
						if ("Nimbus".equals(info.getName())) {
							UIManager.setLookAndFeel(info.getClassName());
							break;
						}
					}
				} catch (UnsupportedLookAndFeelException e) {
					// handle exception
				} catch (ClassNotFoundException e) {
					// handle exception
				} catch (InstantiationException e) {
					// handle exception
				} catch (IllegalAccessException e) {
					// handle exception
				}
				new QuadroPrincipal();
			}
		});
	}
}
