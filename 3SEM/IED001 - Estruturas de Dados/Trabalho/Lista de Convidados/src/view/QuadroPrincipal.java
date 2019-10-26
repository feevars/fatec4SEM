package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import controller.ListaDupla;
import model.Convidado;

public class QuadroPrincipal<T> extends JFrame {

	private static final long serialVersionUID = 1L;

	// Variáveis iniciadas pelo QuadroPrincipal
	private ListaDupla<Convidado> listaConvidados;
	private FormConvidado formConvidado;
	private PainelLista painelLista;
	private BarraDeFerramentas barraDeFerramentas;

	// Construtor do QuadroPrincipal
	public QuadroPrincipal() {
		super("Lista de Convidados");

		setLayout(new BorderLayout());
		
		listaConvidados = new ListaDupla<Convidado>();
		formConvidado = new FormConvidado(listaConvidados, painelLista);
		painelLista = new PainelLista();
		
		barraDeFerramentas = new BarraDeFerramentas();
		
		add(barraDeFerramentas, BorderLayout.NORTH);
		
		add(painelLista, BorderLayout.CENTER);
		
		add(formConvidado, BorderLayout.WEST);
		
		formConvidado.setFormListener(new FormListener() {
			public void formEventOcurred(FormEvent e) {
				
				painelLista.alteraTexto(listaConvidados.imprimeLista());
			}
		});
		

		setSize(1280, 720);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
