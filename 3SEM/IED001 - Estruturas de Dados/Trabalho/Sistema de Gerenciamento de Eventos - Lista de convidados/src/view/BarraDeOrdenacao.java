package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.Evento;

public class BarraDeOrdenacao extends JPanel {

	private static final long serialVersionUID = 1L;

	private static final Color CINZA = new Color(75, 82, 103);
	private static final Color AZUL_ESCURO = new Color(46, 41, 78);
	
	private BarraDeOrdenacaoListener barraDeOrdenacaoListener;

	private JButton btnRecarregar;
	private JButton btnOrdenarID;
	private JButton btnOrdenarNome;
	private JButton btnOrdenarIdade;
	private JButton btnBuscar;

	public BarraDeOrdenacao(Evento evento) {
		setForeground(Color.WHITE);
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		setPreferredSize(new Dimension(800, 40));
		setBackground(AZUL_ESCURO);

		btnRecarregar = new JButton("");
		btnRecarregar.setIcon(new ImageIcon(BarraDeFerramentas.class.getResource("/assets/icone_recarregar_lista.png")));
		btnRecarregar.setToolTipText("Recarregar lista de convidados");
		btnRecarregar.setPreferredSize(new Dimension(40, 40));
		btnRecarregar.setBackground(CINZA);
		add(btnRecarregar);

		btnOrdenarID = new JButton("");
		btnOrdenarID.setIcon(new ImageIcon(BarraDeFerramentas.class.getResource("/assets/icone_ordenar.png")));
		btnOrdenarID.setToolTipText("Ordenar por ID");
		btnOrdenarID.setPreferredSize(new Dimension(40, 40));
		btnOrdenarID.setBackground(CINZA);
		add(btnOrdenarID);

		btnOrdenarNome = new JButton("");
		btnOrdenarNome.setIcon(new ImageIcon(BarraDeFerramentas.class.getResource("/assets/icone_ordenar.png")));
		btnOrdenarNome.setToolTipText("Ordenar por nome");
		btnOrdenarNome.setPreferredSize(new Dimension(40, 40));
		btnOrdenarNome.setBackground(CINZA);
		add(btnOrdenarNome);

		btnOrdenarIdade = new JButton("");
		btnOrdenarIdade.setIcon(new ImageIcon(BarraDeFerramentas.class.getResource("/assets/icone_ordenar.png")));
		btnOrdenarIdade.setToolTipText("Ordenar por idade");
		btnOrdenarIdade.setPreferredSize(new Dimension(40, 40));
		btnOrdenarIdade.setBackground(CINZA);
		add(btnOrdenarIdade);

		btnBuscar = new JButton("");
		btnBuscar.setIcon(new ImageIcon(BarraDeFerramentas.class.getResource("/assets/icone_buscar.png")));
		btnBuscar.setToolTipText("Buscar");
		btnBuscar.setPreferredSize(new Dimension(40, 40));
		btnBuscar.setBackground(CINZA);
		add(btnBuscar);

		btnRecarregar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BarraDeOrdenacaoEvent recarregarLista = new BarraDeOrdenacaoEvent(this, "recarregarLista");
				barraDeOrdenacaoListener.formEventOcurred(recarregarLista);

			}
		});

		btnOrdenarID.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (evento.getListaConvidados().getQtdNo() < 2) {
					JOptionPane.showMessageDialog(null, "Não há necessidade de ordenar menos de 2 convidados.");
				} else {
					BarraDeOrdenacaoEvent ordenarID = new BarraDeOrdenacaoEvent(this, "ordenarID");
					barraDeOrdenacaoListener.formEventOcurred(ordenarID);
				}
			}
		});
		
		btnOrdenarNome.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (evento.getListaConvidados().getQtdNo() < 2) {
					JOptionPane.showMessageDialog(null, "Não há necessidade de ordenar menos de 2 convidados.");
				} else {
					BarraDeOrdenacaoEvent ordenarNome = new BarraDeOrdenacaoEvent(this, "ordenarNome");
					barraDeOrdenacaoListener.formEventOcurred(ordenarNome);
				}
			}
		});
		
		btnOrdenarIdade.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (evento.getListaConvidados().getQtdNo() < 2) {
					JOptionPane.showMessageDialog(null, "Não há necessidade de ordenar menos de 2 convidados.");
				} else {
					BarraDeOrdenacaoEvent ordenarIdade = new BarraDeOrdenacaoEvent(this, "ordenarIdade");
					barraDeOrdenacaoListener.formEventOcurred(ordenarIdade);
				}
			}
		});

		btnBuscar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					BarraDeOrdenacaoEvent buscarNome = new BarraDeOrdenacaoEvent(this, "buscarNome");
					barraDeOrdenacaoListener.formEventOcurred(buscarNome);
			}
		});

	}

	public void setBarraDeOrdenacaoListener(BarraDeOrdenacaoListener barraDeOrdenacaoListener) {
		this.barraDeOrdenacaoListener = barraDeOrdenacaoListener;
	}
}
