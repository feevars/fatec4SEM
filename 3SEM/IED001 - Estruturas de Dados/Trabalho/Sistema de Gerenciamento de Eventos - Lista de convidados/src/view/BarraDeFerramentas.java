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
		setPreferredSize(new Dimension(1280, 40));
		setBackground(AZUL_ESCURO);
		
		JButton btnNovoEvento = new JButton("");
		btnNovoEvento.setPreferredSize(new Dimension(40, 40));
		btnNovoEvento.setIcon(new ImageIcon(BarraDeFerramentas.class.getResource("/assets/icone_nova.png")));
		btnNovoEvento.setBackground(CINZA);
		btnNovoEvento.setToolTipText("Novo Evento");
		add(btnNovoEvento);
		
		JButton btnAbrirEvento = new JButton("");
		btnAbrirEvento.setPreferredSize(new Dimension(40, 40));
		btnAbrirEvento.setIcon(new ImageIcon(BarraDeFerramentas.class.getResource("/assets/icone_abrir.png")));
		btnAbrirEvento.setBackground(CINZA);
		btnAbrirEvento.setToolTipText("Abrir Evento");
		add(btnAbrirEvento);
		
		JButton btnSalvarEvento = new JButton("");
		btnSalvarEvento.setIcon(new ImageIcon(BarraDeFerramentas.class.getResource("/assets/icone_salvar.png")));
		btnSalvarEvento.setPreferredSize(new Dimension(40, 40));
		btnSalvarEvento.setBackground(CINZA);
		btnSalvarEvento.setToolTipText("Salvar Evento");
		add(btnSalvarEvento);
		
		btnSalvarEvento.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				BuffersArquivo ba = new BuffersArquivo();
				try {
					ba.escreveArquivo(evento);
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally {
					JOptionPane.showMessageDialog(null, "Arquivo gravado com sucesso!");
				}
			}
		});
	}
}
