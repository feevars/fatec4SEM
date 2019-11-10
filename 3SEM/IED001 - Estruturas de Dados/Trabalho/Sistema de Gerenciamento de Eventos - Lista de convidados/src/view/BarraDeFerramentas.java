package view;

import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.BuffersArquivo;
import model.Evento;
import view.estatisticas.JanelaEstatisticas;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class BarraDeFerramentas extends JPanel {

	private static final long serialVersionUID = 8481528081497930411L;

	private static final Color CINZA = new Color(75, 82, 103);
	private static final Color AZUL_ESCURO = new Color(46, 41, 78);

	private BarraDeFerramentasListener barraDeFerramentasListener;

	private JButton btnNovo;
	private JButton btnAbrir;
	private JButton btnSalvar;
	private JButton btnSalvarComo;
	private JButton btnRecarregar;
	private JButton btnEstatisticas;
	private JButton btnOrdenar;
	private JButton btnBuscar;

	public BarraDeFerramentas(Evento evento) {
		setForeground(Color.WHITE);
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		setPreferredSize(new Dimension(800, 40));
		setBackground(AZUL_ESCURO);

		btnNovo = new JButton("");
		btnNovo.setPreferredSize(new Dimension(40, 40));
		btnNovo.setIcon(new ImageIcon(BarraDeFerramentas.class.getResource("/assets/icone_novo.png")));
		btnNovo.setBackground(CINZA);
		btnNovo.setToolTipText("Novo Evento");
		add(btnNovo);

		btnAbrir = new JButton("");
		btnAbrir.setPreferredSize(new Dimension(40, 40));
		btnAbrir.setIcon(new ImageIcon(BarraDeFerramentas.class.getResource("/assets/icone_abrir.png")));
		btnAbrir.setBackground(CINZA);
		btnAbrir.setToolTipText("Abrir Evento");
		add(btnAbrir);

		btnSalvar = new JButton("");
		btnSalvar.setIcon(new ImageIcon(BarraDeFerramentas.class.getResource("/assets/icone_salvar.png")));
		btnSalvar.setPreferredSize(new Dimension(40, 40));
		btnSalvar.setBackground(CINZA);
		btnSalvar.setToolTipText("Salvar Evento");
		add(btnSalvar);

		btnSalvarComo = new JButton("");
		btnSalvarComo.setIcon(new ImageIcon(BarraDeFerramentas.class.getResource("/assets/icone_salvar_como.png")));
		btnSalvarComo.setToolTipText("Salvar Evento como...");
		btnSalvarComo.setPreferredSize(new Dimension(40, 40));
		btnSalvarComo.setBackground(CINZA);
		add(btnSalvarComo);

		btnRecarregar = new JButton("");
		btnRecarregar
				.setIcon(new ImageIcon(BarraDeFerramentas.class.getResource("/assets/icone_recarregar_lista.png")));
		btnRecarregar.setToolTipText("Recarregar lista de convidados");
		btnRecarregar.setPreferredSize(new Dimension(40, 40));
		btnRecarregar.setBackground(CINZA);
		add(btnRecarregar);

		btnEstatisticas = new JButton("");
		btnEstatisticas.setIcon(new ImageIcon(BarraDeFerramentas.class.getResource("/assets/icone_estatisticas.png")));
		btnEstatisticas.setToolTipText("Estatísticas");
		btnEstatisticas.setPreferredSize(new Dimension(40, 40));
		btnEstatisticas.setBackground(CINZA);
		add(btnEstatisticas);

		btnOrdenar = new JButton("");
		btnOrdenar.setIcon(new ImageIcon(BarraDeFerramentas.class.getResource("/assets/icone_ordenar.png")));
		btnOrdenar.setToolTipText("Ordenar Lista");
		btnOrdenar.setPreferredSize(new Dimension(40, 40));
		btnOrdenar.setBackground(CINZA);
		add(btnOrdenar);

		btnBuscar = new JButton("");
		btnBuscar.setIcon(new ImageIcon(BarraDeFerramentas.class.getResource("/assets/icone_buscar.png")));
		btnBuscar.setToolTipText("Buscar");
		btnBuscar.setPreferredSize(new Dimension(40, 40));
		btnBuscar.setBackground(CINZA);
		add(btnBuscar);

		btnNovo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		btnAbrir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		btnSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		btnSalvarComo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JFileChooser escolhedorDeArquivos = new JFileChooser();
				FileNameExtensionFilter filtro = new FileNameExtensionFilter("Somente documentos de texto (.txt)",
						"txt");
				String caminho;

				escolhedorDeArquivos.setCurrentDirectory(
						new File(System.getProperty("user.home") + System.getProperty("file.separator") + "Desktop"));
				escolhedorDeArquivos.setDialogTitle("Salvar evento...");
				escolhedorDeArquivos.setFileSelectionMode(JFileChooser.FILES_ONLY);
				escolhedorDeArquivos.setFileFilter(filtro);
				escolhedorDeArquivos.setApproveButtonText("Salvar");
				escolhedorDeArquivos.setAcceptAllFileFilterUsed(false);

				if (escolhedorDeArquivos.showOpenDialog(escolhedorDeArquivos) == JFileChooser.APPROVE_OPTION) {

					caminho = escolhedorDeArquivos.getSelectedFile().getAbsolutePath();
					if (!caminho.substring(caminho.lastIndexOf(".") + 1).equals("txt"))
						caminho += ".txt";

					BuffersArquivo ba = new BuffersArquivo();
					try {
						ba.escreveArquivo(evento, caminho);
						evento.setCaminhoDoArquivo(caminho);
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "Erro de gravação:\n" + e1.getLocalizedMessage());
					}
				} else {
					JOptionPane.showMessageDialog(null, "Nenhum arquivo foi selecionado para a gravação.");
				}
			}
		});

		btnRecarregar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		btnEstatisticas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new JanelaEstatisticas(evento);

			}
		});

		btnOrdenar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (evento.getListaConvidados().getQtdNo() < 2) {
					JOptionPane.showMessageDialog(null, "Não há necessidade de ordenar menos de 2 convidados.");
				} else {
					BarraDeFerramentasEvent ordenarIdade = new BarraDeFerramentasEvent(this, "ordenarIdade");
					barraDeFerramentasListener.formEventOcurred(ordenarIdade);
				}
			}
		});

		btnBuscar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

	}

	public void setBarraDeFerramentasListener(BarraDeFerramentasListener barraDeFerramentasListener) {
		this.barraDeFerramentasListener = barraDeFerramentasListener;
	}

}
