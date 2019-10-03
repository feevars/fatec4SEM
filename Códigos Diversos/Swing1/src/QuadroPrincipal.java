import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class QuadroPrincipal extends JFrame {
	
	private BarraDeFerramentas barraDeFerramentas;
	private PainelTexto painelTexto;
	private PainelForm painelForm;
	
	public QuadroPrincipal() {
		super("Título do Aplicativo");
		
		setLayout(new BorderLayout());
		
		barraDeFerramentas = new BarraDeFerramentas();
		painelTexto = new PainelTexto();
		painelForm = new PainelForm();

		barraDeFerramentas.setStringListener(new StringListener() {

			@Override
			public void textEmitted(String texto) {
				painelTexto.adicionaTexto(texto);
				
			}
		});
		
		painelForm.setFormListener(new FormListener() {
			public void formEventOcurred(FormEvent e) {
				String nome = e.getNome();
				String cargo = e.getCargo();
				
				painelTexto.adicionaTexto(nome + ": " + cargo + "\n");
;			}
		});
		
		add(painelForm, BorderLayout.WEST);
		add(barraDeFerramentas, BorderLayout.NORTH);
		add(painelTexto, BorderLayout.CENTER);
		
		
		setSize(800,600);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
