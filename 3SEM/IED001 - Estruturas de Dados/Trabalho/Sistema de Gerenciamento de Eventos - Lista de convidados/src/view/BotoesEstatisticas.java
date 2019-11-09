package view;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;

public class BotoesEstatisticas extends JPanel {

	private static final long serialVersionUID = -7766384107156740142L;
	
	private static final Color CINZA = new Color(75, 82, 103);
	private static final Color AZUL_CLARO = new Color(72, 172, 240);
	private static final Color AZUL_ESCURO = new Color(46, 41, 78);
	private static final Color VIOLETA = new Color(134, 97, 193);

	public BotoesEstatisticas() {
		setBackground(AZUL_ESCURO);
		setPreferredSize(new Dimension(200, 360));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JButton btnDadosGerais = new JButton("<html><p align=\"center\">Dados Gerais</p></html>");
		btnDadosGerais.setForeground(Color.WHITE);
		btnDadosGerais.setBackground(CINZA);
		add(btnDadosGerais);
		
		JButton btnConvidadoPorLote = new JButton("<html><p align=\"center\">Convidado por lote</p></html>");
		btnConvidadoPorLote.setForeground(Color.WHITE);
		btnConvidadoPorLote.setBackground(CINZA);
		add(btnConvidadoPorLote);
		
		JButton btnFaixaEtriaDo = new JButton("<html><p align=\"center\">Faixa etária do público</p></html>");
		btnFaixaEtriaDo.setForeground(Color.WHITE);
		btnFaixaEtriaDo.setBackground(CINZA);
		add(btnFaixaEtriaDo);
		
		JButton btnArrecadaoPorLote = new JButton("<html><p align=\"center\">Arrecadação por lote</p></html>");
		btnArrecadaoPorLote.setForeground(Color.WHITE);
		btnArrecadaoPorLote.setBackground(CINZA);
		add(btnArrecadaoPorLote);
		
		JButton btnDescontoParaAniversariantes = new JButton("<html><p align=\"center\">Desconto para aniversariantes</p></html>");
		btnDescontoParaAniversariantes.setForeground(Color.WHITE);
		btnDescontoParaAniversariantes.setBackground(CINZA);
		add(btnDescontoParaAniversariantes);
		
		JButton btnVipsConcedidos = new JButton("<html><p align=\"center\">VIPs concedidos</p></html>");
		btnVipsConcedidos.setForeground(Color.WHITE);
		btnVipsConcedidos.setBackground(CINZA);
		add(btnVipsConcedidos);

	}

}
