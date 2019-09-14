package view;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.SemaforoController;

public class SimuladorSemaforo extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimuladorSemaforo frame = new SimuladorSemaforo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
	public SimuladorSemaforo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.setBounds(300, 230, 100, 40);
		contentPane.add(btnIniciar);
		SemaforoController semaforoController = new SemaforoController(btnIniciar);
		btnIniciar.addActionListener(semaforoController);
	}

}
