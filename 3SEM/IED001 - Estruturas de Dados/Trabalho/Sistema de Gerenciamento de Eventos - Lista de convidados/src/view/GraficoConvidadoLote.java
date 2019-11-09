package view;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.PieDataset;

import model.Evento;

public class GraficoConvidadoLote extends JPanel {

	private static final long serialVersionUID = 5651776008262146598L;

	private Evento evento;
	
	private int qtdLote1;
	private int qtdLote2;
	private int qtdLote3;
	private int qtdPortaria;
	
	
	public GraficoConvidadoLote(Evento evento) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.evento = evento;
		this.qtdPortaria = 0;
		this.qtdLote1 = 0;
		this.qtdLote2 = 0;
		this.qtdLote3 = 0;
		
		contaLotes();
//		criaGrafico();
		
	}
	
	public void criaGrafico() {
		DefaultCategoryDataset dadosNoGrafico = new DefaultCategoryDataset();
		dadosNoGrafico.setValue(qtdLote1, "Lote 1", "");
		dadosNoGrafico.setValue(qtdLote2, "Lote 2", "");
		dadosNoGrafico.setValue(qtdLote3, "Lote 3", "");
		dadosNoGrafico.setValue(qtdPortaria, "Portaria", "");
		
		JFreeChart grafico = ChartFactory.createBarChart("Convites vendidos em cada lote", "A", "B", dadosNoGrafico);
		ChartPanel painelGrafico = new ChartPanel(grafico);
		add(painelGrafico);
	}
	
	private void contaLotes() {
		
		while(evento.getListaConvidados().getContador() != null) {
			if(evento.getListaConvidados().getContador().getConteudo().getLote() == 0) this.qtdPortaria++;
			if(evento.getListaConvidados().getContador().getConteudo().getLote() == 1) this.qtdLote1++;
			if(evento.getListaConvidados().getContador().getConteudo().getLote() == 2) this.qtdLote2++;
			if(evento.getListaConvidados().getContador().getConteudo().getLote() == 3) this.qtdLote3++;
			evento.getListaConvidados().setContador(evento.getListaConvidados().getContador().getProximo());
			System.out.println("Lote 1: " + qtdLote1 + "\nLote 2: " + qtdLote2 + "\nLote 3: " + qtdLote3 + "\nPortaria: " + qtdPortaria);
		}
		evento.getListaConvidados().setContador(evento.getListaConvidados().getPrimeiro());
	}
}
