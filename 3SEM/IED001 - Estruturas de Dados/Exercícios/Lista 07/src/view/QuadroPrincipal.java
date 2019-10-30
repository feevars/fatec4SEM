package view;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.ListaDupla;
import model.Aluno;
import model.Disciplina;
import model.Media;

public class QuadroPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private FormAluno formAluno;
	private FormDisciplina formDisciplina;
	private FormMedia formMedia;
	private PainelListas painelListas;
	private BarraDeFerramentas barraDeFerramentas;

	private ListaDupla<Aluno> listaAlunos;
	private ListaDupla<Disciplina> listaDisciplinas;
	private ListaDupla<Media> listaMedias;

	public QuadroPrincipal() {

		this.listaAlunos = new ListaDupla<Aluno>();
		this.listaDisciplinas = new ListaDupla<Disciplina>();
		this.listaMedias = new ListaDupla<Media>();

		this.formAluno = new FormAluno(listaAlunos);
		this.formDisciplina = new FormDisciplina(listaDisciplinas);
		this.formMedia = new FormMedia(listaMedias, listaAlunos, listaDisciplinas);
		this.painelListas = new PainelListas(listaMedias, listaAlunos, listaDisciplinas);
		this.barraDeFerramentas = new BarraDeFerramentas(listaMedias, listaAlunos, listaDisciplinas);

		this.formAluno.setFormListener(new ListenerFormAluno() {
			
			@Override
			public void FormEventOcurred(EventoFormAluno e) {
				painelListas.alteraTexto(e.getListaImpressa());
			}
		});

		this.formDisciplina.setFormListener(new ListenerFormDisciplina() {
			
			@Override
			public void FormEventOcurred(EventoFormDisciplina e) {
				painelListas.alteraTexto(e.getListaImpressa());
			}
		});
		this.formMedia.setFormListener(new ListenerFormMedia() {

			@Override
			public void FormEventOcurred(EventoFormMedia e) {
				painelListas.alteraTexto(e.getListaImpressa());
			}
		});
		
		this.barraDeFerramentas.setFormListener(new ListenerBarraDeFerramentas() {
			
			@Override
			public void FormEventOcurred(EventoBarraDeFerramentas e) {
				painelListas.alteraTexto(e.getListaImpressa());				
			}
		});

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

		this.add(barraDeFerramentas, BorderLayout.NORTH);
		this.add(boxEsquerda, BorderLayout.WEST);
		this.add(painelListas, BorderLayout.CENTER);

		this.setVisible(true);
	}
}
