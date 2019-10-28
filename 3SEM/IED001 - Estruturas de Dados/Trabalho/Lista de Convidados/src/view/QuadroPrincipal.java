package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

import controller.ListaDupla;
import model.Convidado;

public class QuadroPrincipal<T> extends JFrame {

	private static final long serialVersionUID = 1L;

	// Variáveis iniciadas pelo QuadroPrincipal
	private ListaDupla<Convidado> listaConvidados;
	private FormConvidado formConvidado;
	private PainelLista painelLista;
	private BarraDeFerramentas barraDeFerramentas;

	// Construtor do QuadroPrincipal
	public QuadroPrincipal() {
		super("Lista de Convidados");

		setLayout(new BorderLayout());

		listaConvidados = new ListaDupla<Convidado>();
		formConvidado = new FormConvidado(listaConvidados);
		painelLista = new PainelLista(listaConvidados.vetorConvidados());

		barraDeFerramentas = new BarraDeFerramentas();

		add(barraDeFerramentas, BorderLayout.NORTH);

		add(painelLista, BorderLayout.CENTER);

		add(formConvidado, BorderLayout.WEST);

		formConvidado.setFormListener(new ListenerFormConvidado() {

			private CelulaConvidado[] celulas;

			public void formEventOcurred(EventoFormConvidado e) {

				painelLista.removeAll();
				painelLista.setBackground(new Color(46,41,79));
				painelLista.iniciaConteudo();
				celulas = new CelulaConvidado[listaConvidados.vetorConvidados().length];

				for (int i = 0; i < listaConvidados.vetorConvidados().length; i++) {
					this.celulas[i] = new CelulaConvidado(listaConvidados.vetorConvidados()[i].getId(),
							listaConvidados.vetorConvidados()[i].getNome(),
							listaConvidados.vetorConvidados()[i].getSobreNome(),
							listaConvidados.vetorConvidados()[i].getEmail(),
							listaConvidados.vetorConvidados()[i].getTelefone(),
							listaConvidados.vetorConvidados()[i].getDocTipo(),
							listaConvidados.vetorConvidados()[i].getDocNum(),
							listaConvidados.vetorConvidados()[i].getNascimento(),
							listaConvidados.vetorConvidados()[i].isVegano(),
							listaConvidados.vetorConvidados()[i].isVegetariano(),
							listaConvidados.vetorConvidados()[i].isOnivoro(),
							listaConvidados.vetorConvidados()[i].isOutros(),
							listaConvidados.vetorConvidados()[i].getObservacoes(),
							listaConvidados.vetorConvidados()[i].isAcessibilidade(),
							listaConvidados.vetorConvidados()[i].getLote(),
							listaConvidados.vetorConvidados()[i].getAdicao());
					painelLista.setConteudo(this.celulas[i]);
				}
				painelLista.setBackground(Color.BLACK);
				painelLista.revalidate();
				painelLista.repaint();
			}
		});

		setSize(1280, 720);
		setMinimumSize(this.getSize());
		setResizable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
