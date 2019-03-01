package brickbreaker;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

import javax.swing.JPanel;

public class Gameplay extends JPanel implements KeyListener, ActionListener{
    
    private boolean play = false;
    private int score = 0;
    
    private int totalBricks = 21;
    
    private Timer timer;
    private int delay = 8;
    
    private int playerX = 350;
    
    private int ballposX = 120;
    private int ballposY = 300;
    private int ballXdir = -1;
    private int ballYdir = -2;
    
    public Gameplay() {
        
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
        
    }
    
    @Override
    public void paint(Graphics g){
        
        //background
        g.setColor(Color.black);
        g.fillRect(0, 0, 792, 592);
        
        //borders - Não tem borda em baixo porque a bolinha sai por baixo...
        g.setColor(Color.yellow);
        g.fillRect(0, 0, 4, 592);
        g.fillRect(0, 0, 792, 4);
        g.fillRect(791, 0, 4, 592);
        
        //the paddle
        g.setColor(Color.green);
        g.fillRect(playerX, 550, 100, 8);
        
        //A bolinha
        g.setColor(Color.yellow);
        g.fillOval(ballposX, ballposY, 20, 20);
        
        g.dispose();
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        timer.start();
        if(play){
            
            if(new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX, 550, 100, 8))){
                
                ballYdir = -ballYdir;
            }
            
            ballposX += ballXdir;
            ballposY += ballYdir;
            
            if(ballposX < 0){
                
                ballXdir = -ballXdir;
            }
            if(ballposY < 0){
                
                ballYdir = -ballXdir;
            }
            if(ballposX > 770){
                
                ballXdir = -ballXdir;
            }
        }
        
        repaint();
    
    }
    
    @Override
    public void keyTyped(KeyEvent e) {}
    
    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            
            if(playerX >= 690){
                
                playerX = 690;
                
            }else {
                
                moveRight();
                
            }
            
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            
            if(playerX <= 4){
                
                playerX = 4;
                
            }else {
                
                moveLeft();
                
            }
            
        }
    
    }
    public void moveRight(){
        
        play = true;
        playerX += 20;
        
    }
    public void moveLeft(){
        
        play = true;
        playerX -= 20;
        
    }

    
}
