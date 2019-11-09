package view.estatisticas;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

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
		criaGrafico();
		
	}
	
	private void contaLotes() {
		
		while(evento.getListaConvidados().getContador() != null) {
			if(evento.getListaConvidados().getContador().getConteudo().getLote() == 0) this.qtdPortaria++;
			if(evento.getListaConvidados().getContador().getConteudo().getLote() == 1) this.qtdLote1++;
			if(evento.getListaConvidados().getContador().getConteudo().getLote() == 2) this.qtdLote2++;
			if(evento.getListaConvidados().getContador().getConteudo().getLote() == 3) this.qtdLote3++;
			evento.getListaConvidados().setContador(evento.getListaConvidados().getContador().getProximo());
		}
		evento.getListaConvidados().setContador(evento.getListaConvidados().getPrimeiro());
	}
	
	public void criaGrafico() {
		DefaultPieDataset dadosNoGrafico = new DefaultPieDataset();
		dadosNoGrafico.setValue("Lote 1: " + qtdLote1, qtdLote1);
		dadosNoGrafico.setValue("Lote 2: " + qtdLote2, qtdLote2);
		dadosNoGrafico.setValue("Lote 3: " + qtdLote3, qtdLote3);
		dadosNoGrafico.setValue("Portaria: " + qtdPortaria, qtdPortaria);

		
		JFreeChart grafico = ChartFactory.createPieChart3D("Quantidade de convites por lote\n"
				+ "Total: " + (qtdLote1 + qtdLote2 + qtdLote3 + qtdPortaria), dadosNoGrafico);
		ChartPanel painelGrafico = new ChartPanel(grafico);
		add(painelGrafico);
	}
}
