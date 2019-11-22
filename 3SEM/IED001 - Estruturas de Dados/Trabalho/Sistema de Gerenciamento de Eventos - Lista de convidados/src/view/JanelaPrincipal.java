package view;

import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import controller.BuffersArquivo;
import controller.MetodosLista;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.Convidado;
import model.Evento;

public class JanelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private FormConvidado formConvidado;
	private BarraDeFerramentas barraDeFerramentas;
	private BarraDeOrdenacao barraDeOrdenacao;
	private PainelVisualizacao painelVisualizacao;

	public JanelaPrincipal(Evento evento) throws ParseException {
		formConvidado = new FormConvidado(evento);
		barraDeFerramentas = new BarraDeFerramentas(evento);
		painelVisualizacao = new PainelVisualizacao(evento);
		if (evento.getListaConvidados().getQtdNo() > 0) {
			painelVisualizacao.carregaListaDupla();
		}
		barraDeOrdenacao = new BarraDeOrdenacao(evento);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setMinimumSize(getSize());
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(barraDeFerramentas, BorderLayout.NORTH);
		contentPane.add(formConvidado, BorderLayout.WEST);
		contentPane.add(painelVisualizacao, BorderLayout.CENTER);
		contentPane.add(barraDeOrdenacao, BorderLayout.SOUTH);
		setContentPane(contentPane);

		barraDeFerramentas.setBarraDeFerramentasListener(new BarraDeFerramentasListener() {

			@Override
			public void formEventOcurred(BarraDeFerramentasEvent e) {
				switch (e.getAcao()) {
				case "Novo":
					new WizardNovoEvento();
					dispose();
					break;
				case "Abrir":
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
					
					break;
				default:
					break;
				}
			}
		});

		barraDeOrdenacao.setBarraDeOrdenacaoListener(new BarraDeOrdenacaoListener() {

			@Override
			public void formEventOcurred(BarraDeOrdenacaoEvent e) {
				switch (e.getAcao()) {
				case "recarregarLista":
					painelVisualizacao.carregaListaDupla();
					Convidado[] listaRecarregada = MetodosLista.vetorLista(evento.getListaConvidados());
					MetodosLista.recarregaLista(listaRecarregada);
					painelVisualizacao.carregaVetorDaLista(listaRecarregada);
					break;
				case "ordenarID":
					Convidado[] vetorID = MetodosLista.vetorLista(evento.getListaConvidados());
					MetodosLista.mergeSortID(vetorID);
					painelVisualizacao.carregaVetorDaLista(vetorID);
					break;
				case "ordenarIdade":
					Convidado[] vetorConvidados = MetodosLista.vetorLista(evento.getListaConvidados());
					MetodosLista.mergeSortIdade(vetorConvidados);
					painelVisualizacao.carregaVetorDaLista(vetorConvidados);
					break;
				case "ordenarNome":
					Convidado[] vetorNomes = MetodosLista.vetorLista(evento.getListaConvidados());
					MetodosLista.mergeSortNome(vetorNomes);
					painelVisualizacao.carregaVetorDaLista(vetorNomes);
					break;
				case "buscarNome":
					String nome = JOptionPane.showInputDialog("Digite o nome do convidado que deseja buscar: ");
					Convidado[] vetorBusca = MetodosLista.vetorLista(evento.getListaConvidados());
					painelVisualizacao.carregaVetorBusca(vetorBusca, nome);
					break;
				default:
					break;
				}
			}
		});

		formConvidado.setFormListener(new FormConvidadoListener() {

			public void formEventOcurred(FormConvidadoEvent e) {

				CelulaConvidado novaCelula = new CelulaConvidado(evento,
						evento.getListaConvidados().getPrimeiro().getConteudo());
				painelVisualizacao.adicionaCelula(novaCelula);
			}
		});

		setVisible(true);
	}
}
