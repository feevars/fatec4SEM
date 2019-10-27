package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import controller.ListaDupla;
import model.Convidado;

public class PainelLista extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JScrollPane painelRolagem;
	private JTextArea listaView;

	private CelulaConvidado[] celulas;

	// public PainelLista() {
	//
	// setPreferredSize(new Dimension(880, 720));
	//
	// listaView = new JTextArea();
	// painelRolagem = new JScrollPane(listaView);
	//
	// listaView.setFont(new Font("Trebuchet MS", Font.BOLD, 11));
	// listaView.setBackground(new Color(46,41,79));
	// listaView.setForeground(Color.WHITE);
	// listaView.setEditable(false);
	// listaView.setEnabled(true);
	//
	//
	// painelRolagem.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	// painelRolagem.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	// painelRolagem.setBackground(Color.BLACK);
	//
	// setLayout(new BorderLayout());
	// setBackground(new Color(46,41,79));
	// add(painelRolagem, BorderLayout.CENTER);
	//
	// setVisible(true);
	// }

	public PainelLista(Convidado[] convidados) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));


		

		setVisible(true);

	}

	public void alteraTexto(String texto) {
		listaView.setText(texto);
	}
}
