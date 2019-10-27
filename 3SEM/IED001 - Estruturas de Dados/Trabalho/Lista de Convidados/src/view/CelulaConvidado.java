package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.Timestamp;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
	
	public CelulaConvidado(
			String id,
			String nome,
			String sobrenome,
			String email,
			String telefone,
			String docTipo,
			String docNum,
			String nascimento,
			boolean vegano,
			boolean vegetariano,
			boolean onivoro,
			boolean outros,
			String observacoes,
			boolean acessibilidade,
			String lote,
			String adicao) {
		this.labelId = new JLabel("Convidado " + id);
		this.labelNomeCompleto = new JLabel(nome + " " + sobrenome);
		
		this.labelEmail = new JLabel(email);
		this.labelTelefone = new JLabel(telefone);
		this.labelDocumento = new JLabel(docTipo + ": " + docNum);
		this.labelNascimento = new JLabel(nascimento);
		this.labelAlimentar = new JLabel("Modelo alientar: ");
		if(vegano) this.labelAlimentar.setText(labelAlimentar.getText() + "[Vegano]");
		if(vegetariano)	this.labelAlimentar.setText(labelAlimentar.getText() + "[Vegetariano]");
		if(onivoro) this.labelAlimentar.setText(labelAlimentar.getText() + "[Onívoro]");
		if(vegano) this.labelAlimentar.setText(labelAlimentar.getText() + "[Outros]");
		this.labelAcessibilidade = new JLabel();
		if(acessibilidade) this.labelAcessibilidade.setText("Necessita de recursos de acessibilidade.");
		
		JPanel painelInfo = new JPanel();
		painelInfo.setLayout(new BoxLayout(painelInfo, BoxLayout.Y_AXIS));
		painelInfo.add(labelEmail);
		painelInfo.add(labelTelefone);
		painelInfo.add(labelDocumento);
		painelInfo.add(labelNascimento);
		painelInfo.add(labelAlimentar);
		painelInfo.add(labelAcessibilidade);
		painelInfo.setPreferredSize(new Dimension(300,120));
		
		this.labelObservacoes = new JLabel("Observações:\n" + observacoes);
		this.labelAdicao = new JLabel("Adicionado em: " + adicao);
		this.labelLote = new JLabel("Lote: " + lote);
		
		this.setLayout(new BorderLayout());
		this.add(labelId, BorderLayout.LINE_START);
		this.add(labelNomeCompleto, BorderLayout.NORTH);
		this.add(painelInfo, BorderLayout.EAST);
		this.add(labelObservacoes, BorderLayout.CENTER);
		this.add(labelAdicao, BorderLayout.SOUTH);
	}
}
