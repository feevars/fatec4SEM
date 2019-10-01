import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BarraDeFerramentas extends JPanel implements ActionListener{
	
	private JButton btnOla;
	private JButton btnTchau;
	
	private StringListener textoListener;
	
	private PainelTexto painelTexto;
	
	
	public BarraDeFerramentas() {
		
		setBorder(BorderFactory.createEtchedBorder());
		
		btnOla = new JButton("Ola");
		btnTchau = new JButton("Tchau");
		
		btnOla.addActionListener(this);
		btnTchau.addActionListener(this);
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add(btnOla);
		add(btnTchau);
	}
	
	public void setStringListener(StringListener listener) {
		this.textoListener = listener;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clicado = (JButton) e.getSource();
		
		if(clicado == btnOla) {
			if (textoListener != null) {
				textoListener.textEmitted("Oi\n");
			}
		}else {
			textoListener.textEmitted("Tchau\n");
		}
		
	}
}
