package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import java.awt.GridLayout;
import javax.swing.JSpinner;
import java.awt.Component;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;

import controller.ListaConvidados;
import model.Evento;

import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.Dimension;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.ComponentOrientation;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.text.ParseException;

public class WizardNovoEvento extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1006753769296547218L;

	private JPanel contentPane;
	private JPanel painelConteudo;
	private JPanel painelBotoes;
	private JTextField txtNomeDoEvento;

	private int convitesRestantes, cl1, cl2, cl3;

	public WizardNovoEvento() {
		setTitle("Novo Evento");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 360);
		setResizable(false);
		setMinimumSize(this.getSize());
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

		painelConteudo = new JPanel();
		contentPane.add(painelConteudo);
		painelConteudo.setLayout(new CardLayout(0, 0));

		JPanel painelEtapa1 = new JPanel();
		painelConteudo.add(painelEtapa1, "painelEtapa1");
		painelEtapa1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JPanel painelNomeDoEvento = new JPanel();
		painelEtapa1.add(painelNomeDoEvento);
		painelNomeDoEvento.setLayout(new BoxLayout(painelNomeDoEvento, BoxLayout.X_AXIS));

		JLabel lblNomeDoEvento = new JLabel("Nome do evento:");
		painelNomeDoEvento.add(lblNomeDoEvento);

		txtNomeDoEvento = new JTextField();
		txtNomeDoEvento.setText("Evento Perfeito");
		painelNomeDoEvento.add(txtNomeDoEvento);
		txtNomeDoEvento.setColumns(35);

		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		painelEtapa1.add(separator);

		JPanel painelDataDoEvento = new JPanel();
		painelDataDoEvento.setPreferredSize(new Dimension(300, 26));
		painelEtapa1.add(painelDataDoEvento);
		painelDataDoEvento.setLayout(new BoxLayout(painelDataDoEvento, BoxLayout.X_AXIS));

		JLabel lblDataDoEvento = new JLabel("Data do Evento:");
		painelDataDoEvento.add(lblDataDoEvento);

		JDateChooser escolhaDataEvento = new JDateChooser();
		escolhaDataEvento.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		painelDataDoEvento.add(escolhaDataEvento);

		JPanel painelQtdPessoas = new JPanel();
		painelEtapa1.add(painelQtdPessoas);
		painelQtdPessoas.setLayout(new BoxLayout(painelQtdPessoas, BoxLayout.X_AXIS));

		JLabel lblQtdConvidados = new JLabel("Limite de convidados:");
		painelQtdPessoas.add(lblQtdConvidados);

		JSpinner spinnerQtdConvidados = new JSpinner();
		spinnerQtdConvidados.setModel(new SpinnerNumberModel(500, 1, 100000, 10));
		spinnerQtdConvidados.setPreferredSize(new Dimension(100, 26));
		spinnerQtdConvidados.setMinimumSize(new Dimension(100, 26));
		painelQtdPessoas.add(spinnerQtdConvidados);

		JPanel painelEtapa2 = new JPanel();
		painelConteudo.add(painelEtapa2, "painelEtapa2");
		painelEtapa2.setLayout(new BoxLayout(painelEtapa2, BoxLayout.Y_AXIS));

		JLabel lblLotes = new JLabel("Lotes:");
		lblLotes.setAlignmentX(Component.CENTER_ALIGNMENT);
		painelEtapa2.add(lblLotes);

		JPanel painelLotes = new JPanel();
		painelEtapa2.add(painelLotes);
		painelLotes.setLayout(new BoxLayout(painelLotes, BoxLayout.X_AXIS));

		JPanel painelLote1 = new JPanel();
		painelLote1.setBorder(new CompoundBorder(new EmptyBorder(3, 3, 3, 3),
				new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Lote 1", TitledBorder.CENTER,
						TitledBorder.TOP, null, new Color(0, 0, 0))));
		painelLotes.add(painelLote1);
		painelLote1.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblValor1 = new JLabel("Valor:");
		lblValor1.setHorizontalAlignment(SwingConstants.LEFT);
		painelLote1.add(lblValor1);

		JSpinner spinnerValor1 = new JSpinner();
		spinnerValor1.setModel(new SpinnerNumberModel(0, 0.0, 5000, 0.01));
		painelLote1.add(spinnerValor1);

		JLabel lblDataLimite1 = new JLabel("Data limite:");
		lblDataLimite1.setHorizontalAlignment(SwingConstants.LEFT);
		painelLote1.add(lblDataLimite1);

		JDateChooser escolhaDataLote1 = new JDateChooser();
		painelLote1.add(escolhaDataLote1);

		JLabel lblConvitesDisponveis1 = new JLabel("Convites disponíveis:");
		painelLote1.add(lblConvitesDisponveis1);

		JSpinner spinnerConvites1 = new JSpinner();
		spinnerConvites1.setValue((int) spinnerQtdConvidados.getValue() / 3);
		painelLote1.add(spinnerConvites1);

		JPanel painelLote2 = new JPanel();
		painelLote2.setBorder(new CompoundBorder(new EmptyBorder(3, 3, 3, 3),
				new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Lote 2", TitledBorder.CENTER,
						TitledBorder.TOP, null, new Color(0, 0, 0))));
		painelLotes.add(painelLote2);
		painelLote2.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblValor2 = new JLabel("Valor:");
		lblValor2.setHorizontalAlignment(SwingConstants.LEFT);
		painelLote2.add(lblValor2);

		JSpinner spinnerValor2 = new JSpinner();
		spinnerValor2.setModel(new SpinnerNumberModel(0, 0.0, 5000, 0.01));
		painelLote2.add(spinnerValor2);

		JLabel lblDataLimite2 = new JLabel("Data limite:");
		lblDataLimite2.setHorizontalAlignment(SwingConstants.LEFT);
		painelLote2.add(lblDataLimite2);

		JDateChooser escolhaDataLote2 = new JDateChooser();
		painelLote2.add(escolhaDataLote2);

		JLabel lblConvitesDisponiveis2 = new JLabel("Convites disponíveis:");
		painelLote2.add(lblConvitesDisponiveis2);

		JSpinner spinnerConvites2 = new JSpinner();
		spinnerConvites2.setValue((int) spinnerQtdConvidados.getValue() / 3);
		;
		painelLote2.add(spinnerConvites2);

		JPanel painelLote3 = new JPanel();
		painelLote3.setBorder(new CompoundBorder(new EmptyBorder(3, 0, 3, 3),
				new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Lote 3", TitledBorder.CENTER,
						TitledBorder.TOP, null, new Color(0, 0, 0))));
		painelLotes.add(painelLote3);
		painelLote3.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblValor3 = new JLabel("Valor:");
		lblValor3.setHorizontalAlignment(SwingConstants.LEFT);
		painelLote3.add(lblValor3);

		JSpinner spinnerValor3 = new JSpinner();
		spinnerValor3.setModel(new SpinnerNumberModel(0, 0.0, 5000, 0.01));
		painelLote3.add(spinnerValor3);

		JLabel lblDataLimite3 = new JLabel("Data limite:");
		lblDataLimite3.setHorizontalAlignment(SwingConstants.LEFT);
		painelLote3.add(lblDataLimite3);

		JDateChooser escolhaDataLote3 = new JDateChooser();
		painelLote3.add(escolhaDataLote3);

		JLabel lblConvitesDisponiveis3 = new JLabel("Convites disponíveis:");
		painelLote3.add(lblConvitesDisponiveis3);

		JSpinner spinnerConvites3 = new JSpinner();
		spinnerConvites3.setValue((int) spinnerQtdConvidados.getValue() / 3);
		;
		painelLote3.add(spinnerConvites3);

		JPanel painelDetalhes = new JPanel();
		painelEtapa2.add(painelDetalhes);
		painelDetalhes.setLayout(new BoxLayout(painelDetalhes, BoxLayout.X_AXIS));

		JPanel painelPortaria = new JPanel();
		painelDetalhes.add(painelPortaria);
		painelPortaria.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblValorPortaria = new JLabel("Valor do convite na portaria:");
		painelPortaria.add(lblValorPortaria);

		JSpinner spinnerValorPortaria = new JSpinner();
		spinnerValorPortaria.setPreferredSize(new Dimension(100, 26));
		spinnerValorPortaria.setModel(new SpinnerNumberModel(0, 0.0, 5000, 0.01));
		painelPortaria.add(spinnerValorPortaria);

		JPanel painelAniversariante = new JPanel();
		painelDetalhes.add(painelAniversariante);

		JLabel lblAniversariante = new JLabel("Desconto para aniversariantes do mês:");
		painelAniversariante.add(lblAniversariante);

		JSlider sliderAniversariante = new JSlider();
		sliderAniversariante.setValue(0);
		painelAniversariante.add(sliderAniversariante);

		JPanel painelInferior = new JPanel();
		FlowLayout flowLayout = (FlowLayout) painelInferior.getLayout();
		flowLayout.setAlignment(FlowLayout.TRAILING);
		contentPane.add(painelInferior);

		JButton btnCancelar = new JButton("Cancelar");
		painelInferior.add(btnCancelar);

		painelBotoes = new JPanel();
		painelInferior.add(painelBotoes);
		painelBotoes.setLayout(new CardLayout(0, 0));

		JPanel painelBtnEtapa1 = new JPanel();
		painelBotoes.add(painelBtnEtapa1, "name_32958374635459");
		FlowLayout fl_painelBtnEtapa1 = (FlowLayout) painelBtnEtapa1.getLayout();
		fl_painelBtnEtapa1.setAlignment(FlowLayout.RIGHT);

		JPanel painelBtnEtapa2 = new JPanel();
		painelBotoes.add(painelBtnEtapa2, "name_32958389460452");

		JButton btnAvancar = new JButton("Avançar");
		painelBtnEtapa1.add(btnAvancar);

		JButton btnVoltar = new JButton("Voltar");
		painelBtnEtapa2.add(btnVoltar);

		JButton btnIniciarLista = new JButton("Iniciar lista");
		painelBtnEtapa2.add(btnIniciarLista);

		convitesRestantes = (int) spinnerQtdConvidados.getValue() % 3;

		cl1 = ((int) spinnerQtdConvidados.getValue() / 3) + convitesRestantes;
		cl2 = cl3 = ((int) spinnerQtdConvidados.getValue() / 3);

		spinnerConvites1.setValue(cl1);
		spinnerConvites2.setValue(cl2);
		spinnerConvites3.setValue(cl3);

		spinnerConvites1.setModel(new SpinnerNumberModel(cl1, 0, cl1, 1));
		spinnerConvites2.setModel(new SpinnerNumberModel(cl2, 0, cl2, 1));
		spinnerConvites3.setModel(new SpinnerNumberModel(cl3, 0, cl3, 1));

		btnAvancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout clConteudo = (CardLayout) painelConteudo.getLayout();
				CardLayout clBotoes = (CardLayout) painelBotoes.getLayout();
				clConteudo.next(painelConteudo);
				clBotoes.next(painelBotoes);
			}
		});

		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout clConteudo = (CardLayout) painelConteudo.getLayout();
				CardLayout clBotoes = (CardLayout) painelBotoes.getLayout();
				clConteudo.previous(painelConteudo);
				clBotoes.previous(painelBotoes);
			}
		});
		spinnerQtdConvidados.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				convitesRestantes = (int) spinnerQtdConvidados.getValue() % 3;

				cl1 = ((int) spinnerQtdConvidados.getValue() / 3) + convitesRestantes;
				cl2 = cl3 = ((int) spinnerQtdConvidados.getValue() / 3);

				spinnerConvites1.setValue(cl1);
				spinnerConvites2.setValue(cl2);
				spinnerConvites3.setValue(cl3);

				spinnerConvites1.setModel(new SpinnerNumberModel(cl1, 0, cl1, 1));
				spinnerConvites2.setModel(new SpinnerNumberModel(cl2, 0, cl2, 1));
				spinnerConvites3.setModel(new SpinnerNumberModel(cl3, 0, cl3, 1));
			}
		});

		spinnerConvites1.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				cl1 = (int) spinnerConvites1.getValue();
				convitesRestantes = (int) spinnerQtdConvidados.getValue() - cl1 - cl2 - cl3;

				spinnerConvites2.setModel(
						new SpinnerNumberModel(cl2, 0, cl2 + (convitesRestantes / 2) + (convitesRestantes % 2), 1));
				spinnerConvites2.setValue(cl2);
				spinnerConvites3.setModel(new SpinnerNumberModel(cl3, 0, cl3 + (convitesRestantes / 2), 1));
				spinnerConvites3.setValue(cl3);
			}
		});

		spinnerConvites2.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				cl2 = (int) spinnerConvites2.getValue();
				convitesRestantes = (int) spinnerQtdConvidados.getValue() - cl1 - cl2 - cl3;

				spinnerConvites1.setModel(
						new SpinnerNumberModel(cl1, 0, cl1 + (convitesRestantes / 2) + (convitesRestantes % 2), 1));
				spinnerConvites1.setValue(cl1);
				spinnerConvites3.setModel(new SpinnerNumberModel(cl3, 0, cl3 + (convitesRestantes / 2), 1));
				spinnerConvites3.setValue(cl3);
			}
		});

		spinnerConvites3.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				cl3 = (int) spinnerConvites3.getValue();
				convitesRestantes = (int) spinnerQtdConvidados.getValue() - cl1 - cl2 - cl3;

				spinnerConvites1.setModel(
						new SpinnerNumberModel(cl1, 0, cl1 + (convitesRestantes / 2) + (convitesRestantes % 2), 1));
				spinnerConvites1.setValue(cl1);
				spinnerConvites2.setModel(new SpinnerNumberModel(cl2, 0, cl2 + (convitesRestantes / 2), 1));
				spinnerConvites2.setValue(cl2);
			}
		});

		convitesRestantes = (int) spinnerQtdConvidados.getValue() - (int) spinnerConvites1.getValue()
				- (int) spinnerConvites2.getValue() - (int) spinnerConvites3.getValue();

		sliderAniversariante.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				lblAniversariante
						.setText(sliderAniversariante.getValue() + "% de desconto para aniversariantes do mês.");
			}
		});

		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new MenuInicial();
			}
		});

		btnIniciarLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validaBotao(txtNomeDoEvento, escolhaDataEvento, escolhaDataLote1, escolhaDataLote2,
						escolhaDataLote3)) {
					ListaConvidados listaConvidados = new ListaConvidados();
					Evento novoEvento = new Evento(txtNomeDoEvento.getText(), escolhaDataEvento.getDate(),
							Integer.parseInt(spinnerQtdConvidados.getValue().toString()), escolhaDataLote1.getDate(),
							Integer.parseInt(spinnerConvites1.getValue().toString()),
							Double.parseDouble(spinnerValor1.getValue().toString()), escolhaDataLote2.getDate(),
							Integer.parseInt(spinnerConvites2.getValue().toString()),
							Double.parseDouble(spinnerValor2.getValue().toString()), escolhaDataLote3.getDate(),
							Integer.parseInt(spinnerConvites3.getValue().toString()),
							Double.parseDouble(spinnerValor3.getValue().toString()),
							Double.parseDouble(spinnerValorPortaria.getValue().toString()),
							sliderAniversariante.getValue(),
							listaConvidados,
							null);
					dispose();
					try {
						new JanelaPrincipal(novoEvento);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Um novo evento possui as seguintes validações:\n"
							+ "• O campo de nome deve possuir pelo menos 1 caractere e não pode ser uma \"barra de espaço\";\n"
							+ "• Nenhum campo de data pode ser nulo;\n"
							+ "• Um evento só pode ser marcado, pelo menos, daqui a 4 dias;\n"
							+ "• A data limite do Lote 3 deve ser anterior à data do evento;\n"
							+ "• A data limite do Lote 2 deve ser anterior à data do limte do Lote 3;\n"
							+ "• A data limite do Lote 1 deve ser anterior à data do limte do Lote 2;\n"
							+ "• A data limite do Lote 1 deve ser posterior à data de hoje.\n\n"
							+ "Por favor, verifique os campos e tente novamente.");
				}
			}
		});

		setVisible(true);
	}

	public boolean validaBotao(JTextField campoNomeDoEvento, JDateChooser campoDataDoEvento,
			JDateChooser campoDataLote1, JDateChooser campoDataLote2, JDateChooser campoDataLote3) {
		Date hoje = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(hoje);
		c.add(Calendar.DATE, 4);
		Date daquiQuatroDias = c.getTime();

		if (campoNomeDoEvento.getText().length() > 0
			&& campoNomeDoEvento.getText() != " "
			&& campoDataDoEvento.getDate() != null
			&& campoDataLote1.getDate() != null
			&& campoDataLote2.getDate() != null
			&& campoDataLote3.getDate() != null			
			&& campoDataDoEvento.getDate().after(daquiQuatroDias)
			&& campoDataLote3.getDate().before(campoDataDoEvento.getDate())
			&& campoDataLote2.getDate().before(campoDataLote3.getDate())
			&& campoDataLote1.getDate().before(campoDataLote2.getDate())
			&& campoDataLote1.getDate().after(hoje))
			return true;
		else return false;
	}
}
