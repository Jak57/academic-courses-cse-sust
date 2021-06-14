package brickbreaker;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;

class GamePlay extends JPanel implements KeyListener, ActionListener{
    
    private boolean play = false;
    private int score = 0;
    private int totalBricks = 21;
    private Timer timer;
    private int delay = 8;
    
    private int playerX = 310;
    private int ballX = 120;
    private int ballY = 350;
    private int ballXdir = -1;
    private int ballYdir = -2;
    
    private MapGenerator map;
    
    
    public GamePlay(){
        map = new MapGenerator(3, 7);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        
        timer = new Timer(delay, this);
        timer.start();
        
    }
    
    public void paint(Graphics g){
        //background
        g.setColor(Color.BLACK);
        g.fillRect(1, 1, 692, 592);
        
        //boarder
        g.setColor(Color.YELLOW);
        g.fillRect(0, 0, 3, 592);
        g.fillRect(0, 0, 692, 3);
        g.fillRect(691, 0, 3, 592);
        
        //brick
        map.draw((Graphics2D) g);
        
        //paddle
        g.setColor(Color.GREEN);
        g.fillRect(playerX, 550, 100, 8);
        
        //ball
        g.setColor(Color.YELLOW);
        g.fillOval(ballX, ballY, 20, 20);
        
        g.dispose();
    }
  
    public void keyTyped(KeyEvent ke) {
      
    }
 
    public void keyPressed(KeyEvent e) {
         if(e.getKeyCode() == KeyEvent.VK_RIGHT){
             if(playerX >= 600){
                 playerX = 600;
             }
             else{
                 moveRight();
             }
                 
         }
         if(e.getKeyCode() == KeyEvent.VK_LEFT){
             if(playerX < 10){
                 playerX = 10;
             }
             else{
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
 
    public void keyReleased(KeyEvent ke) {
        
    }
       
    public void actionPerformed(ActionEvent ae) {
       timer.start();
       if(play){
           
           if(new Rectangle(ballX, ballY, 20, 20).intersects(new Rectangle(playerX, 550, 100, 8))){
               ballYdir = - ballYdir;
           }
           for(int i = 0; i < map.map.length; i++){
               for(int j = 0; j < map.map[0].length; j++){
                   int brickX = j * map.brickWidth + 80;
                   int brickY = i * map.brickHeight + 50;
                   int brickWidth = map.brickWidth;
                   int brickHeight = map.brickHeight;
                   
                   Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
                   Rectangle ballRect = new Rectangle(ballX, ballY, 20, 20);
                   
                   if(ballRect.intersects(rect)){
                       map.setBrickValue(0, i, j);
                       totalBricks--;
                       score += 5;
                       
                       //if(ballX + 19 <= brickRect.x)
                   }
               }
           }
                  
           ballX += ballXdir;
           ballY += ballYdir;
           
           if(ballX < 0){
               ballXdir = -ballXdir;
           }
           if(ballY < 0){
               ballYdir = -ballYdir;
           }
           if(ballX > 670){
               ballXdir = - ballXdir;
           }
       }
       repaint();
    }
    
}
