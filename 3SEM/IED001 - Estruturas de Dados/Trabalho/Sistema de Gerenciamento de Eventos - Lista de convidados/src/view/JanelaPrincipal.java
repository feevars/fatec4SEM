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

	public JanelaPrincipal(Evento evento) {
		formConvidado = new FormConvidado();
		dadosDoEvento = new DadosDoEvento(evento);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1280,720);
		setMinimumSize(getSize());
		setResizable(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(dadosDoEvento, BorderLayout.NORTH);
		contentPane.add(formConvidado, BorderLayout.WEST);
		setContentPane(contentPane);
		setVisible(true);
	}

}
