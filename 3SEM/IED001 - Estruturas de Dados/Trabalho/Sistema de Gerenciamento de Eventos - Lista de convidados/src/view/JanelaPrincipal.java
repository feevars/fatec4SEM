package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class JanelaPrincipal extends JFrame {

	private JPanel contentPane;
	private FormConvidado formConvidado;

	public JanelaPrincipal() {
		formConvidado = new FormConvidado();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1280,720);
		setMinimumSize(getSize());
		setResizable(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(formConvidado, BorderLayout.WEST);
		setContentPane(contentPane);
		setVisible(true);
	}

}
