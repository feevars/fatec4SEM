package view;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class FormDisciplina extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel labelDisciplina;
	private JTextField campoDisciplina;
	
	private JButton btnInicio;
	private JButton btnFinal;
	private JButton btnPosicao;
	
	public FormDisciplina() {
		
		this.labelDisciplina = new JLabel("Disciplina: ");
		this.campoDisciplina = new JTextField(56);
		this.btnInicio = new JButton("<html><p align=\"center\">Inserir no início</p></html>");
		this.btnFinal = new JButton("<html><p align=\"center\">Inserir no final</p></html>");
		this.btnPosicao = new JButton("<html><p align=\"center\">Inserir na posição</p></html>");
		
		JPanel painelBotoes = new JPanel();
		painelBotoes.setLayout(new BoxLayout(painelBotoes, BoxLayout.X_AXIS));
		painelBotoes.add(btnInicio);
		painelBotoes.add(btnFinal);
		painelBotoes.add(btnPosicao);
		
		Border margem = BorderFactory.createEmptyBorder(3, 3, 3, 3);
		TitledBorder bordaTitulo = BorderFactory.createTitledBorder("Inserir Disciplina");
		Border bordaComposta = BorderFactory.createCompoundBorder(margem, bordaTitulo);
		
		this.setPreferredSize(new Dimension(300,200));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(bordaComposta);
		this.add(labelDisciplina);
		this.add(campoDisciplina);
		this.add(painelBotoes);
	}
}
