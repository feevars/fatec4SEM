import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PainelTexto extends JPanel {
	
	private JTextArea areaTexto;
	
	public PainelTexto() {
		
		areaTexto = new JTextArea();
		
		setLayout(new BorderLayout());
		
		add(new JScrollPane(areaTexto), BorderLayout.CENTER);
		
	}
	
	public void adicionaTexto (String texto) {
		areaTexto.append(texto);
	}
	
	
}
