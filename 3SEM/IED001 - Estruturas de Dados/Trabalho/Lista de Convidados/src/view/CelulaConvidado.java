package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Timestamp;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class CelulaConvidado extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel labelId;
	private JLabel labelIdTitulo;
	private JLabel labelEmail;
	private JLabel labelTelefone;
	private JLabel labelDocumento;
	private JLabel labelNascimento;
	private JLabel labelAlimentar;
	private JLabel labelObservacoes;
	private JLabel labelAcessibilidade;
	private JLabel labelLote;
	private JLabel labelAdicao;

	private JButton btnEditar;
	private JButton btnExcluir;

	private Font fonteInfo = new Font("Trebuchet Ms", Font.ITALIC, 11);
	private Font fonteNome = new Font("Trebuchet Ms", Font.ITALIC, 18);
	private Font fonteID = new Font("Trebuchet Ms", Font.BOLD, 32);
	private Font fonteBaixo = new Font("Courier New", Font.BOLD, 14);

	private Icon iconeEditar = new ImageIcon("src/assets/icone_editar_convidado.png");
	private Icon iconeExcluir = new ImageIcon("src/assets/icone_excluir_convidado.png");

	private Color azulEscuro = new Color(46, 41, 79);
	private Color azulClaro = new Color(72, 172, 240);
	private Color cinzaEscuro = new Color(75, 82, 103);
	private Color roxinho = new Color(134, 97, 193);

	public CelulaConvidado(int id, String nome, String sobrenome, String email, String telefone, String docTipo,
			String docNum, Date nascimento, boolean vegano, boolean vegetariano, boolean onivoro, boolean outros,
			String observacoes, boolean acessibilidade, String lote, Timestamp timestamp) {

		this.labelIdTitulo = new JLabel("Convidado:");
		setPreferredSize(new Dimension(480, 180));
		estiloLabelInfo(labelIdTitulo);
		labelIdTitulo.setForeground(azulClaro);
		this.labelId = new JLabel("" + id);
		labelId.setForeground(roxinho);
		labelId.setFont(fonteID);
		JPanel painelId = new JPanel();
		painelId.setLayout(new BoxLayout(painelId, BoxLayout.Y_AXIS));
		painelId.add(labelIdTitulo);
		painelId.add(Box.createHorizontalGlue());
		painelId.add(labelId);
		painelId.setBackground(cinzaEscuro);
		painelId.setPreferredSize(new Dimension(160, 160));

		this.labelEmail = new JLabel("Email: " + email);
		estiloLabelInfo(labelEmail);
		this.labelTelefone = new JLabel("Telefone: " + telefone);
		estiloLabelInfo(labelTelefone);
		this.labelDocumento = new JLabel(docTipo + ": " + docNum);
		estiloLabelInfo(labelDocumento);
		this.labelNascimento = new JLabel("Nascido em: " + nascimento.toString());
		estiloLabelInfo(labelNascimento);
		this.labelAlimentar = new JLabel("Modelo alientar: ");
		if (vegano)
			this.labelAlimentar.setText(labelAlimentar.getText() + "[Vegano]");
		if (vegetariano)
			this.labelAlimentar.setText(labelAlimentar.getText() + "[Vegetariano]");
		if (onivoro)
			this.labelAlimentar.setText(labelAlimentar.getText() + "[Onívoro]");
		if (vegano)
			this.labelAlimentar.setText(labelAlimentar.getText() + "[Outros]");
		estiloLabelInfo(labelAlimentar);
		this.labelAcessibilidade = new JLabel();
		if (acessibilidade)
			this.labelAcessibilidade.setText("Necessita de recursos de acessibilidade.");
		estiloLabelBaixo(labelAcessibilidade);
		labelAcessibilidade.setForeground(Color.RED.darker());

		JPanel painelInfo = new JPanel();
		painelInfo.setLayout(new BoxLayout(painelInfo, BoxLayout.Y_AXIS));
		painelInfo.setBackground(azulEscuro);
		painelInfo.add(labelEmail);
		painelInfo.add(labelTelefone);
		painelInfo.add(labelDocumento);
		painelInfo.add(labelNascimento);
		painelInfo.add(labelAlimentar);
		painelInfo.setPreferredSize(new Dimension(300, 120));

		JPanel painelMeio = new JPanel();
		Border margemObservacoes = BorderFactory.createEmptyBorder(3, 3, 0, 3);
		TitledBorder bordaObservacoes = BorderFactory.createTitledBorder("Observacoes");
		bordaObservacoes.setTitleFont(fonteInfo);
		bordaObservacoes.setBorder(new LineBorder(Color.WHITE, 1, true));
		bordaObservacoes.setTitleColor(Color.WHITE);
		Border bordaCompostaObs = BorderFactory.createCompoundBorder(margemObservacoes, bordaObservacoes);

		labelObservacoes = new JLabel("<html><p width=\"240\" align=\"center\">" + observacoes + "</p></html>");
		estiloLabelInfo(labelObservacoes);
		painelMeio.setBorder(bordaCompostaObs);
		painelMeio.setBackground(cinzaEscuro);
		painelMeio.add(labelObservacoes);

		JPanel painelCima = new JPanel();
		painelCima.setLayout(new BoxLayout(painelCima, BoxLayout.X_AXIS));
		this.labelAdicao = new JLabel("Adicionado em: " + timestamp);
		estiloLabelInfo(labelAdicao);
		labelAdicao.setPreferredSize(new Dimension(620, 30));
		btnEditar = new JButton();
		btnExcluir = new JButton();
		estiloBotaoCima(btnEditar);
		estiloBotaoCima(btnExcluir);
		btnEditar.setIcon(iconeEditar);
		btnExcluir.setIcon(iconeExcluir);
		painelCima.setPreferredSize(new Dimension(720, 20));
		painelCima.setBackground(azulClaro);
		painelCima.add(labelAdicao);
		painelCima.add(btnEditar);
		painelCima.add(btnExcluir);

		this.labelLote = new JLabel("Lote: " + lote);
		estiloLabelBaixo(labelLote);
		JPanel painelBaixo = new JPanel();
		painelBaixo.setLayout(new BoxLayout(painelBaixo, BoxLayout.X_AXIS));
		painelBaixo.setBackground(azulClaro);
		painelBaixo.add(labelLote);
		painelBaixo.add(labelAcessibilidade);
		this.setLayout(new BorderLayout());
		this.setBackground(azulEscuro);

		Border margemExterna = BorderFactory.createEmptyBorder(0, 3, 0, 3);
		TitledBorder bordaTitulo = BorderFactory.createTitledBorder(nome + " " + sobrenome);
		bordaTitulo.setTitleFont(fonteNome);
		bordaTitulo.setBorder(new LineBorder(azulClaro, 2, true));
		bordaTitulo.setTitleColor(azulClaro);
		Border bordaComposta = BorderFactory.createCompoundBorder(margemExterna, bordaTitulo);
		this.setBorder(bordaComposta);

		this.add(painelCima, BorderLayout.NORTH);
		this.add(painelId, BorderLayout.WEST);
		this.add(painelInfo, BorderLayout.EAST);
		this.add(painelMeio, BorderLayout.CENTER);
		this.add(painelBaixo, BorderLayout.SOUTH);
		this.setPreferredSize(new Dimension(720, 172));
	}

	public JLabel estiloLabelInfo(JLabel l) {

		l.setFont(fonteInfo);
		l.setForeground(Color.WHITE);
		Border margemInfo = BorderFactory.createEmptyBorder(3, 6, 2, 6);
		l.setBorder(margemInfo);

		return l;
	}

	public JLabel estiloLabelBaixo(JLabel l) {

		l.setFont(fonteBaixo);
		l.setForeground(new Color(46, 41, 79));
		Border margemInfo = BorderFactory.createEmptyBorder(3, 3, 3, 3);
		l.setBorder(margemInfo);

		return l;
	}

	public JButton estiloBotaoCima(JButton b) {
		b.setSize(30, 30);
		b.setPreferredSize(b.getSize());
		b.setMaximumSize(b.getSize());
		b.setAlignmentX(Component.RIGHT_ALIGNMENT);
		b.setBackground(azulClaro);

		return b;
	}

}
