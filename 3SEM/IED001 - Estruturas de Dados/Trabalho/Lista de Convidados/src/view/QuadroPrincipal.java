package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class QuadroPrincipal<T> extends JFrame {

	private static final long serialVersionUID = 1L;

	// Variáveis iniciadas pelo QuadroPrincipal
	private FormConvidado formConvidado;
	private PainelLista<T> painelLista;

	// Construtor do QuadroPrincipal
	public QuadroPrincipal() {
		super("Lista de Convidados");

		setLayout(new BorderLayout());

		formConvidado = new FormConvidado();
		add(formConvidado, BorderLayout.WEST);

		painelLista = new PainelLista<T>();
		add(painelLista, BorderLayout.CENTER);

		setSize(1280, 720);
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
