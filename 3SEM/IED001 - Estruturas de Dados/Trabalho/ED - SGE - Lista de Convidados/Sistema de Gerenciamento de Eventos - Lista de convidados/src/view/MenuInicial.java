package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.BuffersArquivo;
import model.Evento;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.GridLayout;

public class MenuInicial extends JFrame {

	private static final long serialVersionUID = -626919165931577521L;
	
	private JPanel contentPane;
	private static final Color AZUL_ESCURO = new Color(46, 41, 78);
	private static final Color CINZA = new Color(75, 82, 103);

	public MenuInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,300);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(AZUL_ESCURO);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel painelBotoes = new JPanel();
		painelBotoes.setPreferredSize(new Dimension(300, 50));
		painelBotoes.setBackground(AZUL_ESCURO);
		contentPane.add(painelBotoes, BorderLayout.SOUTH);
		painelBotoes.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnNovaLista = new JButton("Novo Evento");
		btnNovaLista.setForeground(Color.WHITE);
		btnNovaLista.setIcon(new ImageIcon(MenuInicial.class.getResource("/assets/icone_novo.png")));
		btnNovaLista.setBackground(CINZA);
		painelBotoes.add(btnNovaLista);
		
		
		JButton btnAbrirListaExistente = new JButton("Abrir Evento");
		btnAbrirListaExistente.setForeground(Color.WHITE);
		btnAbrirListaExistente.setIcon(new ImageIcon(MenuInicial.class.getResource("/assets/icone_abrir.png")));
		btnAbrirListaExistente.setBackground(CINZA);
		painelBotoes.add(btnAbrirListaExistente);
		
		JLabel lblImagemPrincipal = new JLabel();
		lblImagemPrincipal.setIcon(new ImageIcon(MenuInicial.class.getResource("/assets/imagem-abertura.png")));
		lblImagemPrincipal.setPreferredSize(new Dimension(300, 230));
		lblImagemPrincipal.setMinimumSize(new Dimension(300, 230));
		contentPane.add(lblImagemPrincipal, BorderLayout.CENTER);
		setVisible(true);
		
		btnNovaLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new WizardNovoEvento();
			}
		});
		
		btnAbrirListaExistente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser escolhedorDeArquivos = new JFileChooser();
				FileNameExtensionFilter filtro = new FileNameExtensionFilter("Somente documentos de texto (.txt)",
						"txt");
				String caminho;

				escolhedorDeArquivos.setCurrentDirectory(
						new File(System.getProperty("user.home") + System.getProperty("file.separator") + "Desktop"));
				escolhedorDeArquivos.setDialogTitle("Abrir evento...");
				escolhedorDeArquivos.setFileSelectionMode(JFileChooser.FILES_ONLY);
				escolhedorDeArquivos.setFileFilter(filtro);
				escolhedorDeArquivos.setApproveButtonText("Abrir");
				escolhedorDeArquivos.setAcceptAllFileFilterUsed(false);

				if (escolhedorDeArquivos.showOpenDialog(escolhedorDeArquivos) == JFileChooser.APPROVE_OPTION) {

					caminho = escolhedorDeArquivos.getSelectedFile().getAbsolutePath();
					if (!caminho.substring(caminho.lastIndexOf(".") + 1).equals("txt")) caminho += ".txt";

					BuffersArquivo ba = new BuffersArquivo();
					try {
						Evento eventoCarregado = ba.abreArquivo(caminho);
						new JanelaPrincipal(eventoCarregado);
						dispose();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Nenhum arquivo foi selecionado.");
				}
			}
		}); 
	}

}
