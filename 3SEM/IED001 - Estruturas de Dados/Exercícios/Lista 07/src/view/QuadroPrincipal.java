package view;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class QuadroPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private FormAluno formAluno;
	private FormDisciplina formDisciplina;
	private FormMedia formMedia;

	public QuadroPrincipal() {
		
		this.formAluno = new FormAluno();
		this.formDisciplina = new FormDisciplina();
		this.formMedia = new FormMedia();

		JPanel boxEsquerda = new JPanel();
		boxEsquerda.setLayout(new BoxLayout(boxEsquerda, BoxLayout.Y_AXIS));
		boxEsquerda.add(formAluno);
		boxEsquerda.add(formDisciplina);
		boxEsquerda.add(formMedia);

		this.setTitle("Estrutura de Dados - Lista 07");
		this.setLayout(new BorderLayout());
		this.setSize(800, 600);
		this.setMinimumSize(this.getSize());
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.add(boxEsquerda, BorderLayout.WEST);
		
		this.setVisible(true);
	}
}
