package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public class QuadroPrincipal extends JFrame {
	
	private BarraDeFerramentas barraDeFerramentas;
	
	private FormConvidado formConvidado;
	
	private TabelaConvidados tabelaConvidados;
	
	public QuadroPrincipal() {
		
		super("Organizador de Eventos");
		
		setLayout(new BorderLayout());
		
		barraDeFerramentas = new BarraDeFerramentas();
		add(barraDeFerramentas, BorderLayout.NORTH);
		
		formConvidado = new FormConvidado();
		formConvidado.setPreferredSize(new Dimension(400,720));
		add(formConvidado, BorderLayout.WEST);
		
		tabelaConvidados = new TabelaConvidados();
		add(tabelaConvidados, BorderLayout.CENTER);
		
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(1200,720));
		setSize(1200,720);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
}