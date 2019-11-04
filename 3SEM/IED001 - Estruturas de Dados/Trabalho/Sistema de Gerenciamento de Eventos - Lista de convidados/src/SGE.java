import java.util.Date;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import model.Evento;

import javax.swing.UIManager.LookAndFeelInfo;

import view.JanelaPrincipal;
import view.MenuInicial;

public class SGE {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {

			@Override
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

				// ITENS COMENTADOS PARA EDITAR A JANELA PRINCIPAL SEM PRECISAR PASSAR POR TUDO
				// DESCOMENTE-OS E COMENTE O MENU INICIAL PARA FACILITAR A EDIÇÃO.
//				Evento ev = new Evento("A", new Date(), 1, new Date(), 1, 1, new Date(), 1, 1,new Date(), 1, 1, 1, 1, null, null);
//				new JanelaPrincipal(ev);
				new MenuInicial();
			}

		});
	}
}
