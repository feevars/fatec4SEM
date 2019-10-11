package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.Date;

import javax.swing.JFrame;

import controller.ListaDupla;
import model.Convidado;

public class QuadroPrincipal extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BarraDeFerramentas barraDeFerramentas;
	private FormConvidado<Convidado> formConvidado;
	private TabelaConvidados tabelaConvidados;
	
	private ListaDupla<Convidado> listaConvidados;

	public QuadroPrincipal() {
		
		super("Organizador de Eventos");
		
		setLayout(new BorderLayout());
		
		barraDeFerramentas = new BarraDeFerramentas();
		add(barraDeFerramentas, BorderLayout.NORTH);
		
		listaConvidados = new ListaDupla();
		
		formConvidado = new FormConvidado<Convidado>(listaConvidados);
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
