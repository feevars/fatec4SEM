package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import controller.ListaDupla;
import model.Aluno;

public class FormAluno extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ListenerFormAluno formListener;
	
	private JLabel labelNome;
	private JTextField campoNome;
	private JLabel labelCurso;
	private JTextField campoCurso;
	private JLabel labelSemestre;
	private JComboBox<String> listaSemestre;

	private JButton btnInicio;
	private JButton btnFinal;
	private JButton btnPosicao;

	public FormAluno(ListaDupla<Aluno> listaAlunos) {

		this.labelNome = new JLabel("Nome:");
		this.campoNome = new JTextField(56);
		this.labelCurso = new JLabel("Curso:");
		this.campoCurso = new JTextField(56);
		this.labelSemestre = new JLabel("Semestre:");
		this.listaSemestre = new JComboBox<String>();
		this.listaSemestre.addItem("1");
		this.listaSemestre.addItem("2");
		this.listaSemestre.addItem("3");
		this.listaSemestre.addItem("4");
		this.listaSemestre.addItem("5");
		this.listaSemestre.addItem("6");
		this.btnInicio = new JButton("<html><p align=\"center\">Inserir no início</p></html>");
		this.btnFinal = new JButton("<html><p align=\"center\">Inserir no final</p></html>");
		this.btnPosicao = new JButton("<html><p align=\"center\">Inserir na posição</p></html>");

		JPanel painelSemestre = new JPanel();
		painelSemestre.setLayout(new BoxLayout(painelSemestre, BoxLayout.X_AXIS));
		painelSemestre.add(labelSemestre);
		painelSemestre.add(listaSemestre);

		JPanel painelBotoes = new JPanel();
		painelBotoes.setLayout(new BoxLayout(painelBotoes, BoxLayout.X_AXIS));
		painelBotoes.add(btnInicio);
		painelBotoes.add(btnFinal);
		painelBotoes.add(btnPosicao);
		
		this.btnInicio.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Aluno novoAluno = new Aluno(listaAlunos.getContaId(), campoNome.getText(), campoCurso.getText(), (listaSemestre.getSelectedIndex() + 1));
				listaAlunos.inserePrimeiro(novoAluno);
				EventoFormAluno ev = new EventoFormAluno(this, listaAlunos.listaString());
				formListener.FormEventOcurred(ev);
				limpaCampos();
			}
		});
		
		Border margem = BorderFactory.createEmptyBorder(3, 3, 3, 3);
		TitledBorder bordaTitulo = BorderFactory.createTitledBorder("Inserir Aluno");
		Border bordaComposta = BorderFactory.createCompoundBorder(margem, bordaTitulo);
		
		this.setPreferredSize(new Dimension(300,360));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(bordaComposta);
		this.add(labelNome);
		this.add(campoNome);
		this.add(labelCurso);
		this.add(campoCurso);
		this.add(painelSemestre);
		this.add(painelBotoes);
	}
	
	private void limpaCampos() {
		this.campoNome.setText("");
		this.campoCurso.setText("");
		this.listaSemestre.setSelectedItem(0);
	}
	
	public void setFormListener(ListenerFormAluno listener) {
		this.formListener = listener;
	}
}
