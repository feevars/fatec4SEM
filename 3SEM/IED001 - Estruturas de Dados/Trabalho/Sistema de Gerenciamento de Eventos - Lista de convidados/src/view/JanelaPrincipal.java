package view;

import java.awt.BorderLayout;
import java.text.ParseException;
import controller.MetodosLista;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Convidado;
import model.Evento;

public class JanelaPrincipal extends JFrame {

	private static final long serialVersionUID = -8759682053898348256L;

	private JPanel contentPane;
	private FormConvidado formConvidado;
	private BarraDeFerramentas barraDeFerramentas;
	private PainelVisualizacao painelVisualizacao;

	public JanelaPrincipal(Evento evento) throws ParseException {
		formConvidado = new FormConvidado(evento);
		barraDeFerramentas = new BarraDeFerramentas(evento);
		painelVisualizacao = new PainelVisualizacao(evento);
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
		setContentPane(contentPane);

		barraDeFerramentas.setBarraDeFerramentasListener(new BarraDeFerramentasListener() {

			@Override
			public void formEventOcurred(BarraDeFerramentasEvent e) {
				switch (e.getAcao()) {
				case "ordenarIdade":
					Convidado [] vetorConvidados = MetodosLista.vetorLista(evento.getListaConvidados());
					MetodosLista.mergeSortIdade(vetorConvidados);
					painelVisualizacao.carregaListaCompleta(vetorConvidados);
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
