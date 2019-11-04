package view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextArea;

public class CelulaConvidado extends JPanel {

	private static final long serialVersionUID = 8005257527912286592L;

	public CelulaConvidado() {
		setPreferredSize(new Dimension(880, 140));
		setBorder(new CompoundBorder(new EmptyBorder(3, 3, 3, 3), new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Nome", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0))));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{120, 0, 240, 40, 0};
		gridBagLayout.rowHeights = new int[]{80, 40, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblId = new JLabel("id");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 0;
		add(lblId, gbc_lblId);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBorder(new TitledBorder(null, "Observa\u00E7\u00F5es", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 0;
		add(scrollPane, gbc_scrollPane);
		
		JTextArea txtrObservacoes = new JTextArea();
		txtrObservacoes.setEnabled(false);
		txtrObservacoes.setEditable(false);
		txtrObservacoes.setLineWrap(true);
		scrollPane.setViewportView(txtrObservacoes);
		
		JPanel painelDados = new JPanel();
		GridBagConstraints gbc_painelDados = new GridBagConstraints();
		gbc_painelDados.insets = new Insets(0, 0, 5, 5);
		gbc_painelDados.fill = GridBagConstraints.HORIZONTAL;
		gbc_painelDados.gridx = 2;
		gbc_painelDados.gridy = 0;
		add(painelDados, gbc_painelDados);
		painelDados.setLayout(new BoxLayout(painelDados, BoxLayout.Y_AXIS));
		
		JLabel lblEmail = new JLabel("Email: ");
		painelDados.add(lblEmail);
		
		JLabel lblTelefone = new JLabel("Telefone: ");
		painelDados.add(lblTelefone);
		
		JLabel lblDocumento = new JLabel("Rg:");
		painelDados.add(lblDocumento);
		
		JLabel lblDataDeNascimento = new JLabel("Data de nascimento:");
		painelDados.add(lblDataDeNascimento);
		
		JPanel painelBotoes = new JPanel();
		GridBagConstraints gbc_painelBotoes = new GridBagConstraints();
		gbc_painelBotoes.insets = new Insets(0, 0, 5, 0);
		gbc_painelBotoes.gridx = 3;
		gbc_painelBotoes.gridy = 0;
		add(painelBotoes, gbc_painelBotoes);
		painelBotoes.setLayout(new BoxLayout(painelBotoes, BoxLayout.Y_AXIS));
		
		JButton btnEditar = new JButton("editar");
		painelBotoes.add(btnEditar);
		
		JButton btnExcluir = new JButton("excluir");
		painelBotoes.add(btnExcluir);
		
		JLabel lblLote = new JLabel("lote");
		GridBagConstraints gbc_lblLote = new GridBagConstraints();
		gbc_lblLote.insets = new Insets(0, 0, 0, 5);
		gbc_lblLote.gridx = 0;
		gbc_lblLote.gridy = 1;
		add(lblLote, gbc_lblLote);
		
		JLabel lblAdicao = new JLabel("Adicao");
		GridBagConstraints gbc_lblAdicao = new GridBagConstraints();
		gbc_lblAdicao.insets = new Insets(0, 0, 0, 5);
		gbc_lblAdicao.gridx = 1;
		gbc_lblAdicao.gridy = 1;
		add(lblAdicao, gbc_lblAdicao);
		
		JLabel lblAcessibilidade = new JLabel("Acessibilidade");
		GridBagConstraints gbc_lblAcessibilidade = new GridBagConstraints();
		gbc_lblAcessibilidade.insets = new Insets(0, 0, 0, 5);
		gbc_lblAcessibilidade.gridx = 2;
		gbc_lblAcessibilidade.gridy = 1;
		add(lblAcessibilidade, gbc_lblAcessibilidade);
		
		JLabel lblVip = new JLabel("VIP");
		GridBagConstraints gbc_lblVip = new GridBagConstraints();
		gbc_lblVip.gridx = 3;
		gbc_lblVip.gridy = 1;
		add(lblVip, gbc_lblVip);
		
	}

}
