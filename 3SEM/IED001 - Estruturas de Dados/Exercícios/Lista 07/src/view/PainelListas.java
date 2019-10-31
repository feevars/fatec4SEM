package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import controller.ListaDupla;
import model.Aluno;
import model.Disciplina;
import model.Media;

public class PainelListas extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JScrollPane scrollListas;
	private JTextArea areaListas;
	
	private JPanel painelBotoes;
	private JButton btnImprimeAlunos;
	private JButton btnImprimeDisciplinas;
	private JButton btnImprimeMedias;
	
	public PainelListas(ListaDupla<Media> listaMedias, ListaDupla<Aluno> listaAlunos, ListaDupla<Disciplina> listaDisciplinas) {
				
		this.areaListas = new JTextArea();
		this.scrollListas = new JScrollPane(areaListas);
		this.scrollListas.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.scrollListas.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		this.areaListas.setEditable(false);
		
		this.painelBotoes = new JPanel();
		this.painelBotoes.setLayout(new BoxLayout(this.painelBotoes, BoxLayout.X_AXIS));
		this.btnImprimeAlunos = new JButton("<html>Imprimir Alunos</html>");
		this.btnImprimeDisciplinas = new JButton("<html>Imprimir Disciplinas</html>");
		this.btnImprimeMedias = new JButton("<html>Imprimir Médias</html>");
		this.painelBotoes.add(btnImprimeAlunos);
		this.painelBotoes.add(btnImprimeDisciplinas);
		this.painelBotoes.add(btnImprimeMedias);
		
		this.btnImprimeAlunos.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				alteraTexto("Lista de alunos:\n\n" + listaAlunos.listaString());
			}
		});
		
		this.btnImprimeDisciplinas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				alteraTexto("Lista de disciplinas:\n\n" + listaDisciplinas.listaString());
			}
		});
		
		this.btnImprimeMedias.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				alteraTexto("Lista de médias:\n\n" + listaMedias.listaString());
			}
		});
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(scrollListas);
		this.add(painelBotoes);
	}
	
	public void alteraTexto(String texto) {
		this.areaListas.setText(texto);
	}
}
