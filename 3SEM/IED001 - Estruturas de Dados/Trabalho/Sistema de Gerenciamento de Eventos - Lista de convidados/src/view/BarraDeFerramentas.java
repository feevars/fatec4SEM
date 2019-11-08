package view;

import javax.swing.JPanel;

import controller.BuffersArquivo;
import model.Evento;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class BarraDeFerramentas extends JPanel {

	private static final long serialVersionUID = 8481528081497930411L;
	
	private static final Color CINZA = new Color(75,82,103);
	private static final Color AZUL_ESCURO = new Color(46,41,78);

	public BarraDeFerramentas(Evento evento) {
		setForeground(Color.WHITE);
		FlowLayout flowLayout = (FlowLayout) getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		flowLayout.setVgap(0);
		flowLayout.setHgap(0);
		setPreferredSize(new Dimension(800, 40));
		setBackground(AZUL_ESCURO);
		
		JButton btnNovo = new JButton("");
		btnNovo.setPreferredSize(new Dimension(40, 40));
		btnNovo.setIcon(new ImageIcon(BarraDeFerramentas.class.getResource("/assets/icone_novo.png")));
		btnNovo.setBackground(CINZA);
		btnNovo.setToolTipText("Novo Evento");
		add(btnNovo);
		
		JButton btnAbrir = new JButton("");
		btnAbrir.setPreferredSize(new Dimension(40, 40));
		btnAbrir.setIcon(new ImageIcon(BarraDeFerramentas.class.getResource("/assets/icone_abrir.png")));
		btnAbrir.setBackground(CINZA);
		btnAbrir.setToolTipText("Abrir Evento");
		add(btnAbrir);
		
		JButton btnSalvar = new JButton("");
		btnSalvar.setIcon(new ImageIcon(BarraDeFerramentas.class.getResource("/assets/icone_salvar.png")));
		btnSalvar.setPreferredSize(new Dimension(40, 40));
		btnSalvar.setBackground(CINZA);
		btnSalvar.setToolTipText("Salvar Evento");
		add(btnSalvar);
		
		JButton btnSalvarComo = new JButton("");
		btnSalvarComo.setIcon(new ImageIcon(BarraDeFerramentas.class.getResource("/assets/icone_salvar_como.png")));
		btnSalvarComo.setToolTipText("Salvar Evento como...");
		btnSalvarComo.setPreferredSize(new Dimension(40, 40));
		btnSalvarComo.setBackground(CINZA);
		add(btnSalvarComo);
		
		JButton btnEstatisticas = new JButton("");
		btnEstatisticas.setIcon(new ImageIcon(BarraDeFerramentas.class.getResource("/assets/icone_estatisticas.png")));
		btnEstatisticas.setToolTipText("Estatísticas");
		btnEstatisticas.setPreferredSize(new Dimension(40, 40));
		btnEstatisticas.setBackground(CINZA);
		add(btnEstatisticas);
		
		JButton btnOrdenar = new JButton("");
		btnOrdenar.setIcon(new ImageIcon(BarraDeFerramentas.class.getResource("/assets/icone_ordenar.png")));
		btnOrdenar.setToolTipText("Ordenar Lista");
		btnOrdenar.setPreferredSize(new Dimension(40, 40));
		btnOrdenar.setBackground(CINZA);
		add(btnOrdenar);
		
		JButton btnBuscar = new JButton("");
		btnBuscar.setIcon(new ImageIcon(BarraDeFerramentas.class.getResource("/assets/icone_buscar.png")));
		btnBuscar.setToolTipText("Buscar");
		btnBuscar.setPreferredSize(new Dimension(40, 40));
		btnBuscar.setBackground(CINZA);
		add(btnBuscar);
		
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BuffersArquivo ba = new BuffersArquivo();
				try {
					ba.escreveArquivo(evento);
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
}
