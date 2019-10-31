package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import controller.ListaDupla;
import controller.MetodosAdicionais;
import model.Aluno;
import model.Disciplina;
import model.Media;

public class FormMedia extends JPanel implements MetodosAdicionais {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ListenerFormMedia formListener;

	private JLabel labelIdAluno;
	private JTextField campoIdAluno;
	private JLabel labelIdDisciplina;
	private JTextField campoIdDisciplina;
	private JLabel labelMedia;
	private JTextField campoMedia;

	private JButton btnInicio;
	private JButton btnFinal;
	private JButton btnPosicao;

	public FormMedia(ListaDupla<Media> listaMedias, ListaDupla<Aluno> listaAlunos,
			ListaDupla<Disciplina> listaDisciplinas) {

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

		this.btnInicio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!MetodosAdicionais.checkIdAlunos(Integer.parseInt(campoIdAluno.getText()), listaAlunos)) {
					JOptionPane.showMessageDialog(null,
							"Não exite aluno com o ID inserido." + "\nImpossível adicionar nova média.");
				} else if (!MetodosAdicionais.checkIdDisciplinas(Integer.parseInt(campoIdDisciplina.getText()),
						listaDisciplinas)) {
					JOptionPane.showMessageDialog(null,
							"Não exite disciplina com o ID inserido." + "\nImpossível adicionar nova média.");
				} else if (MetodosAdicionais.checkExisteMedia(Integer.parseInt(campoIdAluno.getText()),
						Integer.parseInt(campoIdDisciplina.getText()), listaMedias)) {
					JOptionPane.showMessageDialog(null, "Já existe uma média do aluno " + campoIdAluno.getText()
							+ " na disciplina " + campoIdDisciplina.getText() + "\nImpossível adicionar nova média.");
				} else if (MetodosAdicionais.checkIdAlunos(Integer.parseInt(campoIdAluno.getText()), listaAlunos)
						&& MetodosAdicionais.checkIdDisciplinas(Integer.parseInt(campoIdDisciplina.getText()),
								listaDisciplinas)
						&& !MetodosAdicionais.checkExisteMedia(Integer.parseInt(campoIdAluno.getText()),
								Integer.parseInt(campoIdDisciplina.getText()), listaMedias)) {
					Media novaMedia = new Media(Integer.parseInt(campoIdAluno.getText()),
							Integer.parseInt(campoIdDisciplina.getText()), Double.parseDouble(campoMedia.getText()));
					listaMedias.inserePrimeiro(novaMedia);
					EventoFormMedia ev = new EventoFormMedia(this, listaMedias.listaString());
					formListener.FormEventOcurred(ev);
					limpaCampos();
				}
			}
		});

		this.btnPosicao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!MetodosAdicionais.checkIdAlunos(Integer.parseInt(campoIdAluno.getText()), listaAlunos)) {
					JOptionPane.showMessageDialog(null,
							"Não exite aluno com o ID inserido." + "\nImpossível adicionar nova média.");
				} else if (!MetodosAdicionais.checkIdDisciplinas(Integer.parseInt(campoIdDisciplina.getText()),
						listaDisciplinas)) {
					JOptionPane.showMessageDialog(null,
							"Não exite disciplina com o ID inserido." + "\nImpossível adicionar nova média.");
				} else if (MetodosAdicionais.checkExisteMedia(Integer.parseInt(campoIdAluno.getText()),
						Integer.parseInt(campoIdDisciplina.getText()), listaMedias)) {
					JOptionPane.showMessageDialog(null, "Já existe uma média do aluno " + campoIdAluno.getText()
							+ " na disciplina " + campoIdDisciplina.getText() + "\nImpossível adicionar nova média.");
				} else if (MetodosAdicionais.checkIdAlunos(Integer.parseInt(campoIdAluno.getText()), listaAlunos)
						&& MetodosAdicionais.checkIdDisciplinas(Integer.parseInt(campoIdDisciplina.getText()),
								listaDisciplinas)
						&& !MetodosAdicionais.checkExisteMedia(Integer.parseInt(campoIdAluno.getText()),
								Integer.parseInt(campoIdDisciplina.getText()), listaMedias)) {
					int posicao = Integer.parseInt(JOptionPane.showInputDialog(
							"Digite a posição da lista em que você de seja inserir a nova informação de média."));
					Media novaMedia = new Media(Integer.parseInt(campoIdAluno.getText()),
							Integer.parseInt(campoIdDisciplina.getText()), Double.parseDouble(campoMedia.getText()));
					if(posicao < 2) {
						JOptionPane.showMessageDialog(null, "A posição é inferior a 2.\n"
								+ "Inserindo na primeira posição.");
						listaMedias.inserePrimeiro(novaMedia);						
					}else if (posicao > listaMedias.getQtdNo()) {
						JOptionPane.showMessageDialog(null, "A posição é maior do que o tamanho da lista."
								+ "Inserindo na última posição.");
						listaMedias.insereUltimo(novaMedia);
					}else {
						listaMedias.inserePosicao(novaMedia, posicao);
					}
					EventoFormMedia ev = new EventoFormMedia(this, listaMedias.listaString());
					formListener.FormEventOcurred(ev);
					limpaCampos();
				}
			}
		});

		this.btnFinal.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!MetodosAdicionais.checkIdAlunos(Integer.parseInt(campoIdAluno.getText()), listaAlunos)) {
					JOptionPane.showMessageDialog(null,
							"Não exite aluno com o ID inserido." + "\nImpossível adicionar nova média.");
				} else if (!MetodosAdicionais.checkIdDisciplinas(Integer.parseInt(campoIdDisciplina.getText()),
						listaDisciplinas)) {
					JOptionPane.showMessageDialog(null,
							"Não exite disciplina com o ID inserido." + "\nImpossível adicionar nova média.");
				} else if (MetodosAdicionais.checkExisteMedia(Integer.parseInt(campoIdAluno.getText()),
						Integer.parseInt(campoIdDisciplina.getText()), listaMedias)) {
					JOptionPane.showMessageDialog(null, "Já existe uma média do aluno " + campoIdAluno.getText()
							+ " na disciplina " + campoIdDisciplina.getText() + "\nImpossível adicionar nova média.");
				} else if (MetodosAdicionais.checkIdAlunos(Integer.parseInt(campoIdAluno.getText()), listaAlunos)
						&& MetodosAdicionais.checkIdDisciplinas(Integer.parseInt(campoIdDisciplina.getText()),
								listaDisciplinas)
						&& !MetodosAdicionais.checkExisteMedia(Integer.parseInt(campoIdAluno.getText()),
								Integer.parseInt(campoIdDisciplina.getText()), listaMedias)) {
					Media novaMedia = new Media(Integer.parseInt(campoIdAluno.getText()),
							Integer.parseInt(campoIdDisciplina.getText()), Double.parseDouble(campoMedia.getText()));
					listaMedias.insereUltimo(novaMedia);
					EventoFormMedia ev = new EventoFormMedia(this, listaMedias.listaString());
					formListener.FormEventOcurred(ev);
					limpaCampos();
				}
			}
		});

		Border margem = BorderFactory.createEmptyBorder(3, 3, 3, 3);
		TitledBorder bordaTitulo = BorderFactory.createTitledBorder("Inserir Média");
		Border bordaComposta = BorderFactory.createCompoundBorder(margem, bordaTitulo);

		this.setPreferredSize(new Dimension(300, 240));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(bordaComposta);
		this.add(painelHorizontal);
		this.add(painelBotoes);
	}

	private void limpaCampos() {
		this.campoIdAluno.setText("");
		this.campoIdDisciplina.setText("");
		this.campoMedia.setText("");
	}

	public void setFormListener(ListenerFormMedia listener) {
		this.formListener = listener;
	}
}
