package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BarraDeFerramentas extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnNovaLista;
	private JButton btnAbrirLista;
	private JButton btnSalvarLista;
	private JButton btnOrdenarPor;
	private JButton btnEstatisticas;
	private JTextField campoBuscar;
	private JButton btnBuscar;
	
	private Icon iconeNova = new ImageIcon("src/assets/icone_nova.png");
	private Icon iconeAbrir = new ImageIcon("src/assets/icone_abrir.png");
	private Icon iconeSalvar = new ImageIcon("src/assets/icone_salvar.png");
	private Icon iconeOrdenar = new ImageIcon("src/assets/icone_ordenar.png");
	private Icon iconeEstatisticas = new ImageIcon("src/assets/icone_estatisticas.png");
	private Icon iconeBuscar = new ImageIcon("src/assets/icone_buscar.png");
	
	public BarraDeFerramentas() {
		btnNovaLista = new JButton("Nova");
		btnAbrirLista = new JButton("Abrir");
		btnSalvarLista = new JButton("Salvar");
		btnOrdenarPor = new JButton("Ordenar por");
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
		btnNovaLista.setIcon(iconeNova);
		add(btnAbrirLista);
		btnAbrirLista.setIcon(iconeAbrir);
		add(btnSalvarLista);
		btnSalvarLista.setIcon(iconeSalvar);
		add(btnOrdenarPor);
		btnOrdenarPor.setIcon(iconeOrdenar);
		add(btnEstatisticas);
		btnEstatisticas.setIcon(iconeEstatisticas);
		
		add(campoBuscar);
		add(btnBuscar);
		btnBuscar.setIcon(iconeBuscar);
	}
	
	public JButton estiloBotao(JButton b) {
		
		b.setBackground(new Color(46,41,79));
		b.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		b.setForeground(Color.WHITE);
		b.setMinimumSize(new Dimension(100,60));
		b.setMaximumSize(new Dimension(200,60));
		return b;
	}

}
