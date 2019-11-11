package view.estatisticas;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Evento;
import java.awt.CardLayout;

public class JanelaEstatisticas extends JFrame {

	private static final long serialVersionUID = -8825167705725868064L;
	
	private JPanel contentPane;
	
	private BotoesEstatisticas botoesEstatisticas;
	private JPanel painelGraficos;
	private DadosGerais dadosGerais;
	private GraficoConvidadoLote graficoConvidadoLote;
	private GraficoFaixaEtaria graficoFaixaEtaria;
	private GraficoArrecadacao graficoArrecadacao;


	public JanelaEstatisticas(Evento evento) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(720, 360);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		
		contentPane.setLayout(new BorderLayout());
		setContentPane(contentPane);
		
		dadosGerais = new DadosGerais(evento);
		graficoConvidadoLote = new GraficoConvidadoLote(evento);
		graficoFaixaEtaria = new GraficoFaixaEtaria(evento);
		graficoArrecadacao = new GraficoArrecadacao(evento);
		
		CardLayout clPainelGraficos = new CardLayout();
		painelGraficos = new JPanel();
		painelGraficos.setLayout(clPainelGraficos);
		painelGraficos.add(dadosGerais, "Dados Gerais");
		painelGraficos.add(graficoConvidadoLote, "Convidados por Lote");
		painelGraficos.add(graficoFaixaEtaria, "Faixa Etaria");
		painelGraficos.add(graficoArrecadacao, "Arrecadacao");
		
		botoesEstatisticas = new BotoesEstatisticas();
		botoesEstatisticas.setBotoesEstatisticasListener(new BotoesEstatisticasListener() {
			
			@Override
			public void formEventOcurred(BotoesEstatisticasEvent e) {
				
				switch (e.getPainel()) {
				case 0:
					clPainelGraficos.show(painelGraficos, "Dados Gerais");
					break;
				case 1:
					clPainelGraficos.show(painelGraficos, "Convidados por Lote");
					break;
				case 2:
					clPainelGraficos.show(painelGraficos, "Faixa Etaria");
					break;
				case 3:
					clPainelGraficos.show(painelGraficos, "Arrecadacao");
					break;
				default:
					clPainelGraficos.show(painelGraficos, "Dados Gerais");
					break;
				}
			}
		});
		contentPane.add(botoesEstatisticas, BorderLayout.WEST);

		contentPane.add(painelGraficos, BorderLayout.CENTER);

		setVisible(true);
	}

}
