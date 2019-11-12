package view.estatisticas;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.awt.Font;
import javax.swing.border.EmptyBorder;

import controller.MetodosLista;
import model.Evento;

import java.awt.Color;

public class DadosGerais extends JPanel implements MetodosLista {

	private static final long serialVersionUID = 1133228908361691330L;

//	private static final Color CINZA = new Color(75, 82, 103);
	private static final Color AZUL_CLARO = new Color(72, 172, 240);
	private static final Color AZUL_ESCURO = new Color(46, 41, 78);
//	private static final Color VIOLETA = new Color(134, 97, 193);
	
	private static DecimalFormat decimalFormat = new DecimalFormat("#.##");

	public DadosGerais(Evento evento) {
		setBackground(AZUL_ESCURO);
		setBorder(new EmptyBorder(12, 12, 12, 12));
		setPreferredSize(new Dimension(520, 360));
		setLayout(new BorderLayout(0, 0));

		JPanel painelTitulo = new JPanel();
		painelTitulo.setBackground(AZUL_ESCURO);
		add(painelTitulo, BorderLayout.NORTH);
		GridBagLayout gbl_painelTitulo = new GridBagLayout();
		gbl_painelTitulo.columnWidths = new int[] { 300, 220, 0 };
		gbl_painelTitulo.rowHeights = new int[] { 0, 0, 0 };
		gbl_painelTitulo.columnWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		gbl_painelTitulo.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		painelTitulo.setLayout(gbl_painelTitulo);

		JLabel lblNomeDoEvento = new JLabel(evento.getNome());
		lblNomeDoEvento.setForeground(Color.WHITE);
		lblNomeDoEvento.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		GridBagConstraints gbc_lblNomeDoEvento = new GridBagConstraints();
		gbc_lblNomeDoEvento.anchor = GridBagConstraints.WEST;
		gbc_lblNomeDoEvento.insets = new Insets(0, 0, 5, 5);
		gbc_lblNomeDoEvento.gridx = 0;
		gbc_lblNomeDoEvento.gridy = 0;
		painelTitulo.add(lblNomeDoEvento, gbc_lblNomeDoEvento);

		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatadaEvento = df.format(evento.getDataEvento());
		JLabel lblDataDoEvento = new JLabel(dataFormatadaEvento);
		lblDataDoEvento.setForeground(Color.WHITE);
		lblDataDoEvento.setFont(new Font("Trebuchet MS", Font.PLAIN, 16));
		GridBagConstraints gbc_lblDataDoEvento = new GridBagConstraints();
		gbc_lblDataDoEvento.anchor = GridBagConstraints.EAST;
		gbc_lblDataDoEvento.insets = new Insets(0, 0, 5, 0);
		gbc_lblDataDoEvento.gridx = 1;
		gbc_lblDataDoEvento.gridy = 0;
		painelTitulo.add(lblDataDoEvento, gbc_lblDataDoEvento);

		JLabel lblLimiteConvidados = new JLabel("Máximo de convidados: " + evento.getQtdConvites());
		lblLimiteConvidados.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblLimiteConvidados = new GridBagConstraints();
		gbc_lblLimiteConvidados.anchor = GridBagConstraints.WEST;
		gbc_lblLimiteConvidados.insets = new Insets(0, 0, 0, 5);
		gbc_lblLimiteConvidados.gridx = 0;
		gbc_lblLimiteConvidados.gridy = 1;
		painelTitulo.add(lblLimiteConvidados, gbc_lblLimiteConvidados);

		JLabel lblConvidadosRegistrados = new JLabel(
				"Convidados registrados: " + evento.getListaConvidados().getQtdNo());
		lblConvidadosRegistrados.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblConvidadosRegistrados = new GridBagConstraints();
		gbc_lblConvidadosRegistrados.anchor = GridBagConstraints.EAST;
		gbc_lblConvidadosRegistrados.gridx = 1;
		gbc_lblConvidadosRegistrados.gridy = 1;
		painelTitulo.add(lblConvidadosRegistrados, gbc_lblConvidadosRegistrados);

		JPanel painelConteudo = new JPanel();
		painelConteudo.setBackground(AZUL_ESCURO);
		add(painelConteudo, BorderLayout.CENTER);
		GridBagLayout gbl_painelConteudo = new GridBagLayout();
		gbl_painelConteudo.columnWidths = new int[] { 150, 0, 150, 0 };
		gbl_painelConteudo.rowHeights = new int[] { 0, 25, 25, 25, 25, 25, 25, 25, 25, 25, 0 };
		gbl_painelConteudo.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_painelConteudo.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		painelConteudo.setLayout(gbl_painelConteudo);

		JLabel lblQtdlote = new JLabel("Lote 1: " + MetodosLista.qtdConvidadoLote(evento)[1]);
		lblQtdlote.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblQtdlote = new GridBagConstraints();
		gbc_lblQtdlote.anchor = GridBagConstraints.WEST;
		gbc_lblQtdlote.insets = new Insets(0, 0, 5, 5);
		gbc_lblQtdlote.gridx = 0;
		gbc_lblQtdlote.gridy = 1;
		painelConteudo.add(lblQtdlote, gbc_lblQtdlote);

		JLabel lblArrecadacaolote = new JLabel("R$ " + decimalFormat.format(MetodosLista.arrecadacaoLote(evento)[1]));
		lblArrecadacaolote.setForeground(Color.GREEN);
		GridBagConstraints gbc_lblArrecadacaolote = new GridBagConstraints();
		gbc_lblArrecadacaolote.anchor = GridBagConstraints.WEST;
		gbc_lblArrecadacaolote.insets = new Insets(0, 0, 5, 5);
		gbc_lblArrecadacaolote.gridx = 0;
		gbc_lblArrecadacaolote.gridy = 2;
		painelConteudo.add(lblArrecadacaolote, gbc_lblArrecadacaolote);

		JLabel lblQtdVips = new JLabel(MetodosLista.qtdVips(evento) + " VIPs");
		lblQtdVips.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblQtdVips = new GridBagConstraints();
		gbc_lblQtdVips.anchor = GridBagConstraints.EAST;
		gbc_lblQtdVips.insets = new Insets(0, 0, 5, 0);
		gbc_lblQtdVips.gridx = 2;
		gbc_lblQtdVips.gridy = 2;
		painelConteudo.add(lblQtdVips, gbc_lblQtdVips);

		JLabel lblQtdlote_1 = new JLabel("Lote 2: " + MetodosLista.qtdConvidadoLote(evento)[2]);
		lblQtdlote_1.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblQtdlote_1 = new GridBagConstraints();
		gbc_lblQtdlote_1.anchor = GridBagConstraints.WEST;
		gbc_lblQtdlote_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblQtdlote_1.gridx = 0;
		gbc_lblQtdlote_1.gridy = 3;
		painelConteudo.add(lblQtdlote_1, gbc_lblQtdlote_1);
		
				JLabel lblMediaIdade = new JLabel("<html><p align=\"center\">Média de idade do público:</p><p align=\"center\">"
						+ decimalFormat.format(MetodosLista.mediaIdadePublico(evento)) + " anos</p></html>");
				lblMediaIdade.setForeground(AZUL_CLARO);
				GridBagConstraints gbc_lblMediaIdade = new GridBagConstraints();
				gbc_lblMediaIdade.insets = new Insets(0, 0, 5, 5);
				gbc_lblMediaIdade.gridx = 1;
				gbc_lblMediaIdade.gridy = 3;
				painelConteudo.add(lblMediaIdade, gbc_lblMediaIdade);

		JLabel lblPerdavips = new JLabel("R$ " + decimalFormat.format(MetodosLista.perdaVips(evento)));
		lblPerdavips.setForeground(Color.RED);
		GridBagConstraints gbc_lblPerdavips = new GridBagConstraints();
		gbc_lblPerdavips.anchor = GridBagConstraints.EAST;
		gbc_lblPerdavips.insets = new Insets(0, 0, 5, 0);
		gbc_lblPerdavips.gridx = 2;
		gbc_lblPerdavips.gridy = 3;
		painelConteudo.add(lblPerdavips, gbc_lblPerdavips);

		JLabel lblArrecadacaolote_1 = new JLabel("R$ " + decimalFormat.format(MetodosLista.arrecadacaoLote(evento)[2]));
		lblArrecadacaolote_1.setForeground(Color.GREEN);
		GridBagConstraints gbc_lblArrecadacaolote_1 = new GridBagConstraints();
		gbc_lblArrecadacaolote_1.anchor = GridBagConstraints.WEST;
		gbc_lblArrecadacaolote_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblArrecadacaolote_1.gridx = 0;
		gbc_lblArrecadacaolote_1.gridy = 4;
		painelConteudo.add(lblArrecadacaolote_1, gbc_lblArrecadacaolote_1);

		JLabel lblQtdlote_2 = new JLabel("Lote 3: " + MetodosLista.qtdConvidadoLote(evento)[3]);
		lblQtdlote_2.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblQtdlote_2 = new GridBagConstraints();
		gbc_lblQtdlote_2.anchor = GridBagConstraints.WEST;
		gbc_lblQtdlote_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblQtdlote_2.gridx = 0;
		gbc_lblQtdlote_2.gridy = 5;
		painelConteudo.add(lblQtdlote_2, gbc_lblQtdlote_2);

		JLabel lblQtdaniversariantes = new JLabel("Aniversariantes: " + MetodosLista.qtdAniversariantes(evento));
		lblQtdaniversariantes.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblQtdaniversariantes = new GridBagConstraints();
		gbc_lblQtdaniversariantes.anchor = GridBagConstraints.EAST;
		gbc_lblQtdaniversariantes.insets = new Insets(0, 0, 5, 0);
		gbc_lblQtdaniversariantes.gridx = 2;
		gbc_lblQtdaniversariantes.gridy = 5;
		painelConteudo.add(lblQtdaniversariantes, gbc_lblQtdaniversariantes);

		JLabel lblArrecadacaolote_2 = new JLabel("R$ " + decimalFormat.format(MetodosLista.arrecadacaoLote(evento)[3]));
		lblArrecadacaolote_2.setForeground(Color.GREEN);
		GridBagConstraints gbc_lblArrecadacaolote_2 = new GridBagConstraints();
		gbc_lblArrecadacaolote_2.anchor = GridBagConstraints.WEST;
		gbc_lblArrecadacaolote_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblArrecadacaolote_2.gridx = 0;
		gbc_lblArrecadacaolote_2.gridy = 6;
		painelConteudo.add(lblArrecadacaolote_2, gbc_lblArrecadacaolote_2);

		JLabel lblDescontoaniversariantes = new JLabel("R$ " + decimalFormat.format(MetodosLista.perdaAniversariantes(evento)));
		lblDescontoaniversariantes.setForeground(Color.RED);
		GridBagConstraints gbc_lblDescontoaniversariantes = new GridBagConstraints();
		gbc_lblDescontoaniversariantes.anchor = GridBagConstraints.EAST;
		gbc_lblDescontoaniversariantes.insets = new Insets(0, 0, 5, 0);
		gbc_lblDescontoaniversariantes.gridx = 2;
		gbc_lblDescontoaniversariantes.gridy = 6;
		painelConteudo.add(lblDescontoaniversariantes, gbc_lblDescontoaniversariantes);

		JLabel lblQtdportaria = new JLabel("Portaria: " + MetodosLista.qtdConvidadoLote(evento)[0]);
		lblQtdportaria.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblQtdportaria = new GridBagConstraints();
		gbc_lblQtdportaria.anchor = GridBagConstraints.WEST;
		gbc_lblQtdportaria.insets = new Insets(0, 0, 5, 5);
		gbc_lblQtdportaria.gridx = 0;
		gbc_lblQtdportaria.gridy = 7;
		painelConteudo.add(lblQtdportaria, gbc_lblQtdportaria);

		JLabel lblArrecadacaoportaria = new JLabel("R$ " + decimalFormat.format(MetodosLista.arrecadacaoLote(evento)[0]));
		lblArrecadacaoportaria.setForeground(Color.GREEN);
		GridBagConstraints gbc_lblArrecadacaoportaria = new GridBagConstraints();
		gbc_lblArrecadacaoportaria.anchor = GridBagConstraints.WEST;
		gbc_lblArrecadacaoportaria.insets = new Insets(0, 0, 5, 5);
		gbc_lblArrecadacaoportaria.gridx = 0;
		gbc_lblArrecadacaoportaria.gridy = 8;
		painelConteudo.add(lblArrecadacaoportaria, gbc_lblArrecadacaoportaria);

		JLabel lblArrecadacaoTotal = new JLabel(
				"<html><p align=\"center\">Arrecadação total:</p><p align=\"center\">R$ " + decimalFormat.format((MetodosLista.arrecadacaoLote(evento)[0] + MetodosLista.arrecadacaoLote(evento)[1]
						+ MetodosLista.arrecadacaoLote(evento)[2] + MetodosLista.arrecadacaoLote(evento)[3])) + "</p></html>");
		lblArrecadacaoTotal.setForeground(Color.GREEN);
		GridBagConstraints gbc_lblArrecadacaoTotal = new GridBagConstraints();
		gbc_lblArrecadacaoTotal.insets = new Insets(0, 0, 0, 5);
		gbc_lblArrecadacaoTotal.gridx = 1;
		gbc_lblArrecadacaoTotal.gridy = 9;
		painelConteudo.add(lblArrecadacaoTotal, gbc_lblArrecadacaoTotal);

	}

}
