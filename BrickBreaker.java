package brickbreaker;

import javax.swing.JFrame;

public class BrickBreaker {
    static int width = 300;
    static int height = width / 16 * 9;
    static int scale = 3;

    public static void main(String[] args) {
        GamePlay game = new GamePlay();
        JFrame frame = new JFrame();
        //
        //frame.setBounds(500, 300, width * scale, height * scale);
        frame.setBounds(0, 0, 700, 700);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.add(game);
        
    }
    
}