package view.estatisticas;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;

import controller.MetodosLista;
import model.Evento;

public class GraficoArrecadacao extends JPanel implements MetodosLista {

	private static final long serialVersionUID = -4297938510553493269L;

	private Evento evento;

	private double lote1;
	private double lote2;
	private double lote3;
	private double portaria;
	
	private double valor;
	
	private int aniversariantes;
	
	private int vips;

	public GraficoArrecadacao(Evento evento) {

		this.evento = evento;

		this.lote1 = 0;
		this.lote2 = 0;
		this.lote3 = 0;
		this.portaria = 0;
		
		this.valor = 1;
		
		this.vips = 0;
		
		this.aniversariantes = 0;

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		populaClassesEstatisticas();
		criaGrafico();
	}

	private void populaClassesEstatisticas() {

		while (evento.getListaConvidados().getContador() != null) {
			
			if (MetodosLista.isAniversariante(evento, evento.getListaConvidados().getContador().getConteudo())) {
				valor = (100 - evento.getDescontoAniversariante()) * 0.01;
				aniversariantes++;
			}
			if(!evento.getListaConvidados().getContador().getConteudo().isVip()) {				
				if(evento.getListaConvidados().getContador().getConteudo().getLote() == 1) lote1 += evento.getValorLote1() * valor;
				else if(evento.getListaConvidados().getContador().getConteudo().getLote() == 2) lote2 += evento.getValorLote2() * valor;
				else if(evento.getListaConvidados().getContador().getConteudo().getLote() == 3) lote3 += evento.getValorLote2() * valor;
				else if(evento.getListaConvidados().getContador().getConteudo().getLote() == 0) portaria += evento.getValorPortaria() * valor;
			}else {
				vips++;
			}
			valor = 1;
			evento.getListaConvidados().setContador(evento.getListaConvidados().getContador().getProximo());
		}
		evento.getListaConvidados().setContador(evento.getListaConvidados().getPrimeiro());
		valor = lote1 + lote2 + lote3 + portaria;
	}

	public void criaGrafico() {

		DefaultCategoryDataset dadosDoGrafico = new DefaultCategoryDataset();
		dadosDoGrafico.addValue(lote1, "Lote 1", "");
		dadosDoGrafico.addValue(lote2, "Lote 2", "");
		dadosDoGrafico.addValue(lote3, "Lote 3", "");
		dadosDoGrafico.addValue(portaria, "Portaria", "");

		JFreeChart grafico = ChartFactory.createBarChart("Arrecadação por lote – Total: R$" + valor + "\n", "Lote",
				"Arrecadação", dadosDoGrafico);
		grafico.addSubtitle(new TextTitle(vips + " são VIP e não pagam.\nFoi considerado o desconto dado para " + aniversariantes + " aniversariantes."));

		ChartPanel painelGrafico = new ChartPanel(grafico);
		add(painelGrafico);
	}
}
