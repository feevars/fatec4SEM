package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Evento;

public class JanelaPrincipal extends JFrame {

	private static final long serialVersionUID = -8759682053898348256L;
	
	private JPanel contentPane;
	private FormConvidado formConvidado;
	private DadosDoEvento dadosDoEvento;
	private BarraDeFerramentas barraDeFerramentas;

	public JanelaPrincipal(Evento evento) {
		formConvidado = new FormConvidado();
		dadosDoEvento = new DadosDoEvento(evento);
		barraDeFerramentas = new BarraDeFerramentas(evento);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1280,720);
		setMinimumSize(getSize());
		setResizable(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(barraDeFerramentas, BorderLayout.NORTH);
		contentPane.add(dadosDoEvento, BorderLayout.SOUTH);
		contentPane.add(formConvidado, BorderLayout.WEST);
		setContentPane(contentPane);
		setVisible(true);
	}

}
