package view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import controller.MetodosLista;
import model.Convidado;
import model.Evento;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;

public class CelulaConvidado extends JPanel implements MetodosLista {

	private static final long serialVersionUID = 8005257527912286592L;

	private JButton btnExcluir;

	private static final Color CINZA = new Color(75, 82, 103);
	private static final Color AZUL_CLARO = new Color(72, 172, 240);
	private static final Color VIOLETA = new Color(134, 97, 193);

	public CelulaConvidado(Evento evento, Convidado convidado) {
		setPreferredSize(new Dimension(460, 140));
		setMaximumSize(getPreferredSize());
		setBorder(
				new CompoundBorder(new EmptyBorder(3, 3, 3, 3),
						new TitledBorder(
								new EtchedBorder(EtchedBorder.RAISED, new Color(255, 255, 255),
										new Color(134, 97, 193)),
								convidado.getNome() + " " + convidado.getSobreNome(), TitledBorder.LEFT,
								TitledBorder.TOP, null, new Color(255, 255, 255))));
		setBackground(CINZA);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 80, 320, 40, 0 };
		gridBagLayout.rowHeights = new int[] { 84, 20, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JLabel lblId = new JLabel("<html><p align=\"Left\">Id:</p><p align=\"Center\" width=\"80\"><b>"
				+ convidado.getId() + "</b></p></html>");
		lblId.setForeground(Color.WHITE);
		lblId.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblId.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 0;
		add(lblId, gbc_lblId);

		JPanel painelDados = new JPanel();
		painelDados.setBackground(CINZA);
		GridBagConstraints gbc_painelDados = new GridBagConstraints();
		gbc_painelDados.anchor = GridBagConstraints.NORTH;
		gbc_painelDados.insets = new Insets(0, 0, 5, 5);
		gbc_painelDados.fill = GridBagConstraints.HORIZONTAL;
		gbc_painelDados.gridx = 1;
		gbc_painelDados.gridy = 0;
		add(painelDados, gbc_painelDados);
		painelDados.setLayout(new BoxLayout(painelDados, BoxLayout.Y_AXIS));

		JLabel lblEmail = new JLabel("<html><p align=\"Left\">Email: " + convidado.getEmail() + "</p></html>");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		painelDados.add(lblEmail);

		JLabel lblTelefone = new JLabel("<html><p align=\"Left\">Telefone: " + convidado.getTelefone() + "</p></html>");
		lblTelefone.setForeground(Color.WHITE);
		lblTelefone.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		painelDados.add(lblTelefone);

		JLabel lblDocumento = new JLabel("<html><p align=\"Left\">" + convidado.getTipoDocumento() + ": "
				+ convidado.getNumDocumento() + "</p></html>");
		lblDocumento.setForeground(Color.WHITE);
		lblDocumento.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		painelDados.add(lblDocumento);

		String idade = "";

		if (convidado.getIdade() != -1) {
			idade = " - " + convidado.getIdade() + " anos";
		}

		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = " ";
		if (convidado.getNascimento() != null)
			dataFormatada = df.format(convidado.getNascimento());
		JLabel lblDataDeNascimento = new JLabel(
				"<html><p align=\"Left\">Data de Nascimento: " + dataFormatada + idade + "</p></html>");
		lblDataDeNascimento.setForeground(Color.WHITE);
		if (MetodosLista.isAniversariante(evento, convidado)) {
			lblDataDeNascimento.setForeground(AZUL_CLARO);
			lblDataDeNascimento.setText("<html><p align=\"Left\">Data de Nascimento: " + dataFormatada + idade + "</p></html>");
		}
		lblDataDeNascimento.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		painelDados.add(lblDataDeNascimento);

		JLabel lblAcessibilidade = new JLabel(" ");
		lblAcessibilidade.setForeground(AZUL_CLARO);
		if (convidado.isAcessibilidade())
			lblAcessibilidade.setText("Necessita de recursos de acessibilidade.");
		lblAcessibilidade.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		painelDados.add(lblAcessibilidade);

		JPanel painelBotoes = new JPanel();
		painelBotoes.setBackground(CINZA);
		GridBagConstraints gbc_painelBotoes = new GridBagConstraints();
		gbc_painelBotoes.anchor = GridBagConstraints.NORTHEAST;
		gbc_painelBotoes.insets = new Insets(0, 0, 5, 0);
		gbc_painelBotoes.gridx = 2;
		gbc_painelBotoes.gridy = 0;
		add(painelBotoes, gbc_painelBotoes);
		painelBotoes.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));

		btnExcluir = new JButton("");
		btnExcluir.setHorizontalTextPosition(SwingConstants.CENTER);
		btnExcluir.setIconTextGap(0);
		btnExcluir.setPreferredSize(new Dimension(25, 25));
		btnExcluir.setMaximumSize(btnExcluir.getPreferredSize());
		btnExcluir.setMinimumSize(btnExcluir.getPreferredSize());
		btnExcluir.setBackground(CINZA);
		btnExcluir.setToolTipText("Excluir convidado");
		btnExcluir.setIcon(new ImageIcon(CelulaConvidado.class.getResource("/assets/icone_excluir_convidado.png")));
		painelBotoes.add(btnExcluir);

		JLabel lblLote = new JLabel();
		lblLote.setForeground(Color.WHITE);
		if (convidado.getLote() == 0)
			lblLote.setText("Portaria");
		else
			lblLote.setText(convidado.getLote() + "º lote");
		lblLote.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		GridBagConstraints gbc_lblLote = new GridBagConstraints();
		gbc_lblLote.insets = new Insets(0, 0, 0, 5);
		gbc_lblLote.gridx = 0;
		gbc_lblLote.gridy = 1;
		add(lblLote, gbc_lblLote);

		JLabel lblAdicao = new JLabel("Adicionado em: " + convidado.getAdicao());
		lblAdicao.setForeground(Color.WHITE);
		lblAdicao.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		GridBagConstraints gbc_lblAdicao = new GridBagConstraints();
		gbc_lblAdicao.anchor = GridBagConstraints.WEST;
		gbc_lblAdicao.insets = new Insets(0, 0, 0, 5);
		gbc_lblAdicao.gridx = 1;
		gbc_lblAdicao.gridy = 1;
		add(lblAdicao, gbc_lblAdicao);

		JLabel lblVip = new JLabel(" ");
		lblVip.setForeground(Color.WHITE);
		if (convidado.isVip()) {
			lblVip.setIcon(new ImageIcon(CelulaConvidado.class.getResource("/assets/icone_vip.png")));
			lblVip.setText("VIP");
		}
		lblVip.setForeground(VIOLETA);
		lblVip.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		GridBagConstraints gbc_lblVip = new GridBagConstraints();
		gbc_lblVip.gridx = 2;
		gbc_lblVip.gridy = 1;
		add(lblVip, gbc_lblVip);

		btnExcluir.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				if (convidado.getLote() == 1) {
					evento.setQtdLote1(evento.getQtdLote1() + 1);
				} else if (convidado.getLote() == 2) {
					evento.setQtdLote2(evento.getQtdLote2() + 1);
				} else if (convidado.getLote() == 3) {
					evento.setQtdLote3(evento.getQtdLote3() + 1);
				}
				evento.getListaConvidados().removeId(convidado.getId());
				
				removeAll();
				revalidate();
				repaint();
				
			}
		});
	}



	}
