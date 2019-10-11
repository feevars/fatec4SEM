 package view;

import java.sql.Date;

import javax.swing.SwingUtilities;

import controller.ListaDupla;
import model.Convidado;

public class App {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new QuadroPrincipal();
				
				ListaDupla<Convidado> listaConvidados = new ListaDupla<Convidado>();
				listaConvidados.inserirPrimeiro(new Convidado(0, "Bruno", "Harnik", "brunoharnik@gmail.com", "11 987879197", new Date(19870306), true, true, true, false, "Fresco que só ele...", "VIP"));
				System.out.println(listaConvidados);
			}
		});
	}

}
