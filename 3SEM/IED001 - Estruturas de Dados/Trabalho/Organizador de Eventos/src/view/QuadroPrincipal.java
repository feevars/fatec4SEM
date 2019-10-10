package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public class QuadroPrincipal extends JFrame {
	
	private ListaConvidados listaConvidados;
	
	private FormConvidado formConvidado;
	
	public QuadroPrincipal() {
		
		super("Organizador de Eventos");
		
		setLayout(new BorderLayout());

		
//		listaConvidados = new ListaConvidados();
//		add(listaConvidados, BorderLayout.WEST);
		
		formConvidado = new FormConvidado();
		formConvidado.setPreferredSize(new Dimension(420,199));
		add(formConvidado, BorderLayout.WEST);
		
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(1200,720));
		setSize(1200,720);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
}
