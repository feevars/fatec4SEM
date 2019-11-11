package view.estatisticas;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;

import model.Evento;

public class GraficoFaixaEtaria extends JPanel {

	private static final long serialVersionUID = -4297938510553493269L;

	private Evento evento;

	private int qtdDatas;

	private int clMenosDe12;
	private int cl12a18;
	private int cl18a25;
	private int cl25a35;
	private int cl35a45;
	private int cl45a55;
	private int cl55a65;
	private int clMaisDe65;

	public GraficoFaixaEtaria(Evento evento) {

		this.evento = evento;

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		this.clMenosDe12 = 0;
		this.cl12a18 = 0;
		this.cl18a25 = 0;
		this.cl25a35 = 0;
		this.cl35a45 = 0;
		this.cl45a55 = 0;
		this.cl55a65 = 0;
		this.clMaisDe65 = 0;

		this.qtdDatas = 0;

		populaClassesEstatisticas();
		criaGrafico();
	}

	private void populaClassesEstatisticas() {

		while (evento.getListaConvidados().getContador() != null) {
			if (evento.getListaConvidados().getContador().getConteudo().getIdade() < 12
					&& evento.getListaConvidados().getContador().getConteudo().getIdade() != -1)
				this.clMenosDe12++;
			else if (evento.getListaConvidados().getContador().getConteudo().getIdade() >= 12
					&& evento.getListaConvidados().getContador().getConteudo().getIdade() < 18)
				this.cl12a18++;
			else if (evento.getListaConvidados().getContador().getConteudo().getIdade() >= 18
					&& evento.getListaConvidados().getContador().getConteudo().getIdade() < 25)
				this.cl18a25++;
			else if (evento.getListaConvidados().getContador().getConteudo().getIdade() >= 25
					&& evento.getListaConvidados().getContador().getConteudo().getIdade() < 35)
				this.cl25a35++;
			else if (evento.getListaConvidados().getContador().getConteudo().getIdade() >= 35
					&& evento.getListaConvidados().getContador().getConteudo().getIdade() < 45)
				this.cl35a45++;
			else if (evento.getListaConvidados().getContador().getConteudo().getIdade() >= 45
					&& evento.getListaConvidados().getContador().getConteudo().getIdade() < 55)
				this.cl45a55++;
			else if (evento.getListaConvidados().getContador().getConteudo().getIdade() >= 55
					&& evento.getListaConvidados().getContador().getConteudo().getIdade() < 65)
				this.cl55a65++;
			else if (evento.getListaConvidados().getContador().getConteudo().getIdade() >= 65)
				this.clMaisDe65++;

			if (evento.getListaConvidados().getContador().getConteudo().getIdade() != -1) {
				this.qtdDatas++;
			}
			evento.getListaConvidados().setContador(evento.getListaConvidados().getContador().getProximo());
		}
		evento.getListaConvidados().setContador(evento.getListaConvidados().getPrimeiro());
	}

	public void criaGrafico() {

		DefaultCategoryDataset dadosDoGrafico = new DefaultCategoryDataset();
		dadosDoGrafico.addValue(clMenosDe12, "Menos de 12", "");
		dadosDoGrafico.addValue(cl12a18, "12~18", "");
		dadosDoGrafico.addValue(cl18a25, "18~25", "");
		dadosDoGrafico.addValue(cl25a35, "25~35", "");
		dadosDoGrafico.addValue(cl35a45, "35~45", "");
		dadosDoGrafico.addValue(cl45a55, "45~55", "");
		dadosDoGrafico.addValue(cl55a65, "55~65", "");
		dadosDoGrafico.addValue(clMaisDe65, "Mais de 65", "");

		JFreeChart grafico = ChartFactory.createBarChart("Faixa etária do público\n", "Faixa etária", "Quantidade de convidados", dadosDoGrafico);
		grafico.addSubtitle(new TextTitle(this.qtdDatas + " convidados possuem registro de data de nascimento."));
		
		ChartPanel painelGrafico = new ChartPanel(grafico);
		add(painelGrafico);
	}
}
