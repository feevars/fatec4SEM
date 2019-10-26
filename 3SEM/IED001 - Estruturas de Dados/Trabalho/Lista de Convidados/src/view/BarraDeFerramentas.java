package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BarraDeFerramentas extends JPanel {
	
	private JButton btnNovaLista;
	private JButton btnAbrirLista;
	private JButton btnSalvarLista;
	private JButton btnOrdenarPor;
	private JButton btnEstatisticas;
	private JTextField campoBuscar;
	private JButton btnBuscar;
	
	public BarraDeFerramentas() {
		btnNovaLista = new JButton("Nova...");
		btnAbrirLista = new JButton("Abrir...");
		btnSalvarLista = new JButton("Salvar...");
		btnOrdenarPor = new JButton("Ordenar por...");
		btnEstatisticas = new JButton("Estatisticas");
		campoBuscar = new JTextField();
		btnBuscar = new JButton("Buscar");
		
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setBackground(new Color(134,98,193));
		
		estiloBotao(btnNovaLista);
		estiloBotao(btnAbrirLista);
		estiloBotao(btnSalvarLista);
		estiloBotao(btnOrdenarPor);
		estiloBotao(btnEstatisticas);
		estiloBotao(btnBuscar);
		
		add(btnNovaLista);
		add(btnAbrirLista);
		add(btnSalvarLista);
		add(btnOrdenarPor);
		add(btnEstatisticas);
		
		add(campoBuscar);
		add(btnBuscar);
	}
	
	public JButton estiloBotao(JButton b) {
		
		b.setBackground(new Color(46,41,79));
		b.setFont(new Font("Trebuchet MS", Font.BOLD, 16));
		b.setForeground(Color.WHITE);
		b.setMinimumSize(new Dimension(100,40));
		b.setPreferredSize(new Dimension(140,50));
		b.setMaximumSize(new Dimension(200,50));
		
		return b;
	}

}
