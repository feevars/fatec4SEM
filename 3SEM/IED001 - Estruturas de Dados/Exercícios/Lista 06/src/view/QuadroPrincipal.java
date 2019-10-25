package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import controller.ListaDupla;
import model.Funcionario;

public class QuadroPrincipal extends JFrame {

	/**
	 * O tal do serial...
	 */
	private static final long serialVersionUID = 1L;
	
	private FormFuncionario formFuncionario;
	private ListaDupla<Funcionario> listaFuncionarios;
	
	private JTextArea areaTexto;
	
	private JButton btnImprime;
	
	public QuadroPrincipal() {
		super("Funcionários");
		
		setLayout(new BorderLayout());
		
		listaFuncionarios = new ListaDupla();
		
		formFuncionario = new FormFuncionario(listaFuncionarios);
		
		areaTexto = new JTextArea();
		
		btnImprime = new JButton("Imprimir lista");
		
		btnImprime.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				areaTexto.setText(listaFuncionarios.imprimeLista());
			}
			
		});
		
		add(formFuncionario, BorderLayout.WEST);
		add(areaTexto, BorderLayout.CENTER);
		add(btnImprime, BorderLayout.NORTH);
		
		setSize(800,600);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
