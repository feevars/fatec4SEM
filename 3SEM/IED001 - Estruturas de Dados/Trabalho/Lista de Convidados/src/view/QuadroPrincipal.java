package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

import controller.ListaDupla;
import model.Convidado;

public class QuadroPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;

	private ListaDupla<Convidado> listaConvidados;
	private FormConvidado formConvidado;
	private PainelLista painelLista;
	private BarraDeFerramentas barraDeFerramentas;

	public QuadroPrincipal() {
		super("Lista de Convidados");

		this.listaConvidados = new ListaDupla<Convidado>();
		this.formConvidado = new FormConvidado(listaConvidados);
		this.painelLista = new PainelLista(listaConvidados.vetorConvidados());
		this.barraDeFerramentas = new BarraDeFerramentas();

		this.formConvidado.setFormListener(new ListenerFormConvidado() {
			
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
		
		this.setLayout(new BorderLayout());
		this.add(barraDeFerramentas, BorderLayout.NORTH);
		this.add(painelLista, BorderLayout.CENTER);
		this.add(formConvidado, BorderLayout.WEST);
		this.setSize(1280, 720);
		this.setMinimumSize(this.getSize());
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
