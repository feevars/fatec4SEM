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

	private static final long serialVersionUID = 1L;

	private static final Color CINZA = new Color(75, 82, 103);
	private static final Color AZUL_ESCURO = new Color(46, 41, 78);

	private BarraDeFerramentasListener barraDeFerramentasListener;

	private JButton btnNovo;
	private JButton btnAbrir;
	private JButton btnSalvar;
	private JButton btnSalvarComo;
	private JButton btnEstatisticas;

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

		btnEstatisticas = new JButton("");
		btnEstatisticas.setIcon(new ImageIcon(BarraDeFerramentas.class.getResource("/assets/icone_estatisticas.png")));
		btnEstatisticas.setToolTipText("Estatísticas");
		btnEstatisticas.setPreferredSize(new Dimension(40, 40));
		btnEstatisticas.setBackground(CINZA);
		add(btnEstatisticas);

		btnNovo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Deseja salvar o evento atual?", "Salvar?",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					
					boolean salvou = false;
					
					if (evento.getCaminhoDoArquivo() == null) {
						JFileChooser escolhedorDeArquivos = new JFileChooser();
						FileNameExtensionFilter filtro = new FileNameExtensionFilter(
								"Somente documentos de texto (.txt)", "txt");
						String caminho;

						escolhedorDeArquivos.setCurrentDirectory(new File(
								System.getProperty("user.home") + System.getProperty("file.separator") + "Desktop"));
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
							}finally {
								salvou = true;
							}
						} else {
							JOptionPane.showMessageDialog(null, "Nenhum arquivo foi selecionado para a gravação.");
						}
					}else {
						BuffersArquivo ba = new BuffersArquivo();
						try {
							ba.escreveArquivo(evento, evento.getCaminhoDoArquivo());
						} catch (IOException e1) {
							JOptionPane.showMessageDialog(null, "Erro de gravação:\n" + e1.getLocalizedMessage());
						}finally {
							salvou = true;
						}
					}
					
					if (salvou) {
						BarraDeFerramentasEvent be = new BarraDeFerramentasEvent(this, "Novo");
						barraDeFerramentasListener.formEventOcurred(be);
					}

				} else {
					BarraDeFerramentasEvent be = new BarraDeFerramentasEvent(this, "Novo");
					barraDeFerramentasListener.formEventOcurred(be);
				}

			}
		});

		btnAbrir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Deseja salvar o evento atual?", "Salvar?",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					
					boolean salvou = false;
					
					if (evento.getCaminhoDoArquivo() == null) {
						JFileChooser escolhedorDeArquivos = new JFileChooser();
						FileNameExtensionFilter filtro = new FileNameExtensionFilter(
								"Somente documentos de texto (.txt)", "txt");
						String caminho;

						escolhedorDeArquivos.setCurrentDirectory(new File(
								System.getProperty("user.home") + System.getProperty("file.separator") + "Desktop"));
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
							}finally {
								salvou = true;
							}
						} else {
							JOptionPane.showMessageDialog(null, "Nenhum arquivo foi selecionado para a gravação.");
						}
					}else {
						BuffersArquivo ba = new BuffersArquivo();
						try {
							ba.escreveArquivo(evento, evento.getCaminhoDoArquivo());
						} catch (IOException e1) {
							JOptionPane.showMessageDialog(null, "Erro de gravação:\n" + e1.getLocalizedMessage());
						}finally {
							salvou = true;
						}
					}
					
					if (salvou) {
						BarraDeFerramentasEvent be = new BarraDeFerramentasEvent(this, "Abrir");
						barraDeFerramentasListener.formEventOcurred(be);
					}

				} else {
					BarraDeFerramentasEvent be = new BarraDeFerramentasEvent(this, "Abrir");
					barraDeFerramentasListener.formEventOcurred(be);
				}

			}
		});

		btnSalvar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (evento.getCaminhoDoArquivo() == null) {
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
				}else {
					BuffersArquivo ba = new BuffersArquivo();
					try {
						ba.escreveArquivo(evento, evento.getCaminhoDoArquivo());
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "Erro de gravação:\n" + e1.getLocalizedMessage());
					}
				}
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

		btnEstatisticas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new JanelaEstatisticas(evento);

			}
		});

	}

	public void setBarraDeFerramentasListener(BarraDeFerramentasListener barraDeFerramentasListener) {
		this.barraDeFerramentasListener = barraDeFerramentasListener;
	}

}
