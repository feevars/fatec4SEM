package view;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.FlowLayout;

public class PainelVisualizacao extends JPanel {

	private static final long serialVersionUID = -2357966167347091351L;

	private static final Color CINZA = new Color(75, 82, 103);

	private JScrollPane scrollVisualizacao;
	private JPanel conteudo;

	public PainelVisualizacao() {
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		setBorder(null);
		setBackground(CINZA);
		setPreferredSize(new Dimension(480, 540));
		conteudo = new JPanel();
		conteudo.setBorder(null);
		conteudo.setLayout(new BoxLayout(conteudo, BoxLayout.Y_AXIS));
		scrollVisualizacao = new JScrollPane(conteudo);
		scrollVisualizacao.setBorder(null);
		scrollVisualizacao.setViewportBorder(null);
		scrollVisualizacao.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollVisualizacao.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollVisualizacao.setPreferredSize(this.getPreferredSize());
		scrollVisualizacao.setBackground(CINZA);
		add(scrollVisualizacao);
	}

	public void adicionaCelula(CelulaConvidado celula) {
		conteudo.add(celula);
		conteudo.repaint();
		conteudo.revalidate();
		repaint();
		revalidate();

	}

}
