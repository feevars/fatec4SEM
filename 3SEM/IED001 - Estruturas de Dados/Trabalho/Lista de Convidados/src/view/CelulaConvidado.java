package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Timestamp;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class CelulaConvidado extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel labelId;
	private JLabel labelNomeCompleto;
	private JLabel labelEmail;
	private JLabel labelTelefone;
	private JLabel labelDocumento;
	private JLabel labelNascimento;
	private JLabel labelAlimentar;
	private JLabel labelObservacoes;
	private JLabel labelAcessibilidade;
	private JLabel labelLote;
	private JLabel labelAdicao;

	private Font fontInfo = new Font("Trebuchet Ms", Font.ITALIC, 11);

	public CelulaConvidado(int i, String nome, String sobrenome, String email, String telefone, String docTipo,
			String docNum, Date nascimento, boolean vegano, boolean vegetariano, boolean onivoro, boolean outros,
			String observacoes, boolean acessibilidade, String lote, Timestamp timestamp) {
		this.labelId = new JLabel("Convidado " + i);
		this.labelNomeCompleto = new JLabel(nome + " " + sobrenome);

		this.labelEmail = new JLabel(email);
		estiloLabelInfo(labelEmail);
		this.labelTelefone = new JLabel(telefone);
		estiloLabelInfo(labelTelefone);
		this.labelDocumento = new JLabel(docTipo + ": " + docNum);
		estiloLabelInfo(labelDocumento);
		this.labelNascimento = new JLabel(nascimento.toString());
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
		estiloLabelInfo(labelAcessibilidade);
		this.labelAdicao = new JLabel("Adicionado em: " + timestamp);
		estiloLabelInfo(labelAdicao);

		JPanel painelInfo = new JPanel();
		painelInfo.setLayout(new BoxLayout(painelInfo, BoxLayout.Y_AXIS));
		painelInfo.add(labelEmail);
		painelInfo.add(labelTelefone);
		painelInfo.add(labelDocumento);
		painelInfo.add(labelNascimento);
		painelInfo.add(labelAlimentar);
		painelInfo.add(labelAcessibilidade);
		painelInfo.add(labelAdicao);
		painelInfo.setSize(new Dimension(600, 120));

		this.labelObservacoes = new JLabel("Observações:\n" + observacoes);
		this.labelLote = new JLabel("Lote: " + lote);

		this.setLayout(new BorderLayout());
		this.add(labelId, BorderLayout.WEST);
		this.add(labelNomeCompleto, BorderLayout.NORTH);
		this.add(painelInfo, BorderLayout.EAST);
		this.add(labelObservacoes, BorderLayout.CENTER);
		this.add(labelLote, BorderLayout.SOUTH);

		this.setPreferredSize(new Dimension(300, 100));
	}

	public JLabel estiloLabelInfo(JLabel l) {

		l.setFont(fontInfo);
		Border margemInfo = BorderFactory.createEmptyBorder(6, 6, 6, 6);
		l.setBorder(margemInfo);
		
		
		return l;
	}
}
