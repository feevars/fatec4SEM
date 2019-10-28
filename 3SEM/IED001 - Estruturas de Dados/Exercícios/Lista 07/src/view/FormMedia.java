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

public class FormMedia extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel labelIdAluno;
	private JTextField campoIdAluno;
	private JLabel labelIdDisciplina;
	private JTextField campoIdDisciplina;
	private JLabel labelMedia;
	private JTextField campoMedia;
	
	private JButton btnInicio;
	private JButton btnFinal;
	private JButton btnPosicao;
	
	public FormMedia() {
		
		this.labelIdAluno = new JLabel("<html>ID do aluno:</html>");
		this.campoIdAluno = new JTextField(5);
		JPanel painelIdAluno = new JPanel();
		painelIdAluno.setLayout(new BoxLayout(painelIdAluno, BoxLayout.Y_AXIS));
		painelIdAluno.add(labelIdAluno);
		painelIdAluno.add(campoIdAluno);
		
		this.labelIdDisciplina = new JLabel("<html>ID da disciplina:</html>");
		this.campoIdDisciplina = new JTextField(5);
		JPanel painelIdDisciplina = new JPanel();
		painelIdDisciplina.setLayout(new BoxLayout(painelIdDisciplina, BoxLayout.Y_AXIS));
		painelIdDisciplina.add(labelIdDisciplina);
		painelIdDisciplina.add(campoIdDisciplina);
		
		this.labelMedia = new JLabel("<html>Media:</html>");
		this.campoMedia = new JTextField(4);
		JPanel painelMedia = new JPanel();
		painelMedia.setLayout(new BoxLayout(painelMedia, BoxLayout.Y_AXIS));
		painelMedia.add(labelMedia);
		painelMedia.add(campoMedia);
		
		JPanel painelHorizontal = new JPanel();
		painelHorizontal.setLayout(new BoxLayout(painelHorizontal, BoxLayout.X_AXIS));
		painelHorizontal.add(painelIdAluno);
		painelHorizontal.add(painelIdDisciplina);
		painelHorizontal.add(painelMedia);
		
		this.btnInicio = new JButton("<html><p align=\"center\">Inserir no início</p></html>");
		this.btnFinal = new JButton("<html><p align=\"center\">Inserir no final</p></html>");
		this.btnPosicao = new JButton("<html><p align=\"center\">Inserir na posição</p></html>");

		JPanel painelBotoes = new JPanel();
		painelBotoes.setLayout(new BoxLayout(painelBotoes, BoxLayout.X_AXIS));
		painelBotoes.add(btnInicio);
		painelBotoes.add(btnFinal);
		painelBotoes.add(btnPosicao);
		
		Border margem = BorderFactory.createEmptyBorder(3, 3, 3, 3);
		TitledBorder bordaTitulo = BorderFactory.createTitledBorder("Inserir Média");
		Border bordaComposta = BorderFactory.createCompoundBorder(margem, bordaTitulo);
		
		this.setPreferredSize(new Dimension(300,240));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(bordaComposta);
		this.add(painelHorizontal);
		this.add(painelBotoes);
	}
}
