import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Gameplay extends JPanel implements KeyListener, ActionListener {

	private int[] comprimentoX = new int[750];
	private int[] comprimentoY = new int[750];

	private boolean esquerda = false;
	private boolean direita = false;
	private boolean cima = false;
	private boolean baixo = false;

	private ImageIcon cabecaEsquerda;
	private ImageIcon cabecaDireita;
	private ImageIcon cabecaCima;
	private ImageIcon cabecaBaixo;
	private ImageIcon corpo;
	private ImageIcon buceta;

	private int comprimentoDoPau = 3;

	private Timer temporizador;
	private int atraso = 100;
	
	private int [] bucetaX = {25,50,75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575,600,625,650,675,700,725,750,775,800,825,850};
	private int [] bucetaY = {75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575,600,625};

	private Random random = new Random();
	
	private int xPos = random.nextInt(34);
	private int yPos = random.nextInt(23);
	
	private int placar = 0;
	
	private int movimentos = 0;

	private ImageIcon imagemTitulo;

	public Gameplay() {

		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		temporizador = new Timer(atraso, this);
		temporizador.start();
	}

	public void paint(Graphics g) {

		if (movimentos == 0) {
			comprimentoX[2] = 50;
			comprimentoX[1] = 75;
			comprimentoX[0] = 100;

			comprimentoY[2] = 100;
			comprimentoY[1] = 100;
			comprimentoY[0] = 100;
		}

		//Desenha a borda da imagem de título
		g.setColor(Color.white);
		g.drawRect(24, 10, 851, 55);

		//Desenha a imagem de título
		imagemTitulo = new ImageIcon("assets/titulo.jpg");
		imagemTitulo.paintIcon(this, g, 25, 11);

		//Desenha a borda do jogo
		g.setColor(Color.white);
		g.drawRect(24, 74, 851, 577);

		//Desenha o fundo do jogo
		g.setColor(new Color(0,180,255));
		g.fillRect(25, 75, 850, 576);
		
		//desenha o pau
		cabecaDireita = new ImageIcon("assets/cabeca_direita.png");
		cabecaDireita.paintIcon(this, g, comprimentoX[0], comprimentoY[0]);

		for (int i = 0; i < comprimentoDoPau; i++) {

			if (i == 0 && direita) {
				cabecaDireita = new ImageIcon("assets/cabeca_direita.png");
				cabecaDireita.paintIcon(this, g, comprimentoX[i], comprimentoY[i]);
			}
			if (i == 0 && esquerda) {
				cabecaEsquerda = new ImageIcon("assets/cabeca_esquerda.png");
				cabecaEsquerda.paintIcon(this, g, comprimentoX[i], comprimentoY[i]);
			}
			if (i == 0 && cima) {
				cabecaCima = new ImageIcon("assets/cabeca_cima.png");
				cabecaCima.paintIcon(this, g, comprimentoX[i], comprimentoY[i]);
			}
			if (i == 0 && baixo) {
				cabecaBaixo = new ImageIcon("assets/cabeca_baixo.png");
				cabecaBaixo.paintIcon(this, g, comprimentoX[i], comprimentoY[i]);
			}

			if (i != 0) {
				corpo = new ImageIcon("assets/corpo.png");
				corpo.paintIcon(this, g, comprimentoX[i], comprimentoY[i]);
			}
		}
		
		//desenha o placar
		g.setColor(Color.white);
		g.setFont(new Font("arial", Font.PLAIN, 14));
		g.drawString("Bucetas: " + placar, 680, 32);

		//desenha o placar
		g.setColor(Color.white);
		g.setFont(new Font("arial", Font.PLAIN, 14));
		g.drawString("Comprimento do Pau: " + comprimentoDoPau + " cm", 680, 52);
		
		 		
		//desenha bucetas
		buceta = new ImageIcon("assets/buceta.png");
		
		if ((bucetaX[xPos] == comprimentoX[0] && bucetaY[yPos] == comprimentoY[0])) {
			placar++;
			comprimentoDoPau++;
			xPos = random.nextInt(34);
			yPos = random.nextInt(23);
		}
		
		buceta.paintIcon(this, g, bucetaX[xPos], bucetaY[yPos]);
		
		for (int i = 1; i < comprimentoDoPau; i++) {
			if(comprimentoX[i] == comprimentoX[0] && comprimentoY[i] == comprimentoY[0] ){
				direita = false;
				esquerda = false;
				cima = false;
				baixo = false;
				
				g.setColor(Color.white);
				g.setFont(new Font("arial", Font.BOLD, 50));
				g.drawString("Você perdeu, otário!", 300, 300);
				
				g.setFont(new Font("arial", Font.BOLD, 20));
				g.drawString("Aperta a porra da barra de espaço pra recomeçar.", 350, 340);
			}
		}
		
		
		g.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		temporizador.start();
		if (direita) {
			for (int i = comprimentoDoPau-1; i>=0; i--) {
				comprimentoY[i+1] = comprimentoY[i];
			}
			for (int i = comprimentoDoPau; i>=0; i--) {
				if (i == 0) {
					comprimentoX[i] = comprimentoX[i] + 25;
				}else {
					comprimentoX[i] = comprimentoX[i - 1];
				}
				if (comprimentoX[i] > 850) {
					comprimentoX[i] = 25;
				}
			}
			repaint();
		}
		if (esquerda) {
			for (int i = comprimentoDoPau-1; i>=0; i--) {
				comprimentoY[i+1] = comprimentoY[i];
			}
			for (int i = comprimentoDoPau; i>=0; i--) {
				if (i == 0) {
					comprimentoX[i] = comprimentoX[i] - 25;
				}else {
					comprimentoX[i] = comprimentoX[i - 1];
				}
				if (comprimentoX[i] < 25) {
					comprimentoX[i] = 850;
				}
			}
			repaint();
		}
		if (cima) {
			for (int i = comprimentoDoPau-1; i>=0; i--) {
				comprimentoX[i+1] = comprimentoX[i];
			}
			for (int i = comprimentoDoPau; i>=0; i--) {
				if (i == 0) {
					comprimentoY[i] = comprimentoY[i] - 25;
				}else {
					comprimentoY[i] = comprimentoY[i - 1];
				}
				if (comprimentoY[i] < 75) {
					comprimentoY[i] = 625;
				}
			}
			repaint();
		}
		if (baixo) {
			for (int i = comprimentoDoPau-1; i>=0; i--) {
				comprimentoX[i+1] = comprimentoX[i];
			}
			for (int i = comprimentoDoPau; i>=0; i--) {
				if (i == 0) {
					comprimentoY[i] = comprimentoY[i] + 25;
				}else {
					comprimentoY[i] = comprimentoY[i - 1];
				}
				if (comprimentoY[i] > 625) {
					comprimentoY[i] = 75;
				}
			}
			repaint();
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			movimentos = 0;
			placar = 0;
			comprimentoDoPau = 3;
			repaint();
		}
		if(e.getKeyCode() == KeyEvent.VK_D) {
			movimentos++;
			direita = true;
			if (!esquerda) {
				direita = true;
			}else {
				direita = false;
				esquerda = true;
			}

			cima = false;
			baixo = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_A) {
			movimentos++;
			esquerda = true;
			if (!direita) {
				esquerda = true;
			}else {
				esquerda = false;
				direita = true;
			}

			cima = false;
			baixo = false;
		}		
		if(e.getKeyCode() == KeyEvent.VK_W) {
			movimentos++;
			cima = true;
			if (!baixo) {
				cima = true;
			}else {
				cima = false;
				baixo = true;
			}

			esquerda = false;
			direita = false;
		}
		if(e.getKeyCode() == KeyEvent.VK_S) {
			movimentos++;
			baixo = true;
			if (!cima) {
				baixo = true;
			}else {
				baixo = false;
				cima = true;
			}

			esquerda = false;
			direita = false;
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {


	}

}
