package view;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import model.Convidado;
import model.Evento;

import java.awt.FlowLayout;

public class PainelVisualizacao extends JPanel {

	private static final long serialVersionUID = -2357966167347091351L;

	private static final Color CINZA = new Color(75, 82, 103);

	private JScrollPane scrollVisualizacao;
	private JPanel conteudo;
	private Evento evento;
	
	public PainelVisualizacao(Evento evento) {
		this.evento = evento;
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		setBorder(null);
		setBackground(CINZA);
		setPreferredSize(new Dimension(480, 540));
		conteudo = new JPanel();
		conteudo.setBackground(CINZA);
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
		conteudo.add(celula, 0);
		repaint();
		revalidate();
	}
	
	
	public void carregaListaDupla() {
		conteudo.removeAll();
		for (int i = 0; i < evento.getListaConvidados().getQtdNo(); i++) {
			conteudo.add(new CelulaConvidado(evento, evento.getListaConvidados().getContador().getConteudo()));
			evento.getListaConvidados().setContador(evento.getListaConvidados().getContador().getProximo());
		}
		evento.getListaConvidados().setContador(evento.getListaConvidados().getPrimeiro());
		repaint();
		revalidate();
	}
	
	public void carregaVetorDaLista(Convidado[] vetorConvidados) {
		conteudo.removeAll();
		
		for (int i = 0; i < vetorConvidados.length; i++) {
			conteudo.add(new CelulaConvidado(evento, vetorConvidados[i]));
			
		}
		repaint();
		revalidate();	
	}
	
	public void carregaVetorBusca(Convidado[] vetorBusca, String nome) {
		conteudo.removeAll();
		
		for (int i = 0; i < vetorBusca.length; i++) {
			if (vetorBusca[i].getNome().equalsIgnoreCase(nome) ||
					vetorBusca[i].getNomeSobrenome().equalsIgnoreCase(nome)) {
				conteudo.add(new CelulaConvidado(evento, vetorBusca[i]));
			}
		}
		repaint();
		revalidate();	
	}
}
