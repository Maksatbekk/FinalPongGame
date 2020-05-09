

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Shapes extends JFrame {

    public static int WIN_WIDTH = 700;
    public static int WIN_HEIGHT = 400;

    public Shapes() {
        Panel panel = new Panel();
        Paddle paddle = panel.paddle;

        setSize(WIN_WIDTH, WIN_HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panel);

        panel.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if(keyCode == KeyEvent.VK_DOWN) {
                    paddle.p_yVelocity = 4;
                }
                if(keyCode == KeyEvent.VK_UP) {
                    paddle.p_yVelocity = -4;
                }
                if(keyCode == KeyEvent.VK_S) {
                    paddle.o_yVelocity = 4;
                }
                if(keyCode == KeyEvent.VK_W) {
                    paddle.o_yVelocity = -4;
                }
                if(keyCode == KeyEvent.VK_ENTER) {
                    paddle.start();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if(keyCode == KeyEvent.VK_DOWN) {
                    paddle.p_yVelocity = 0;
                    System.out.println(paddle.p_yVelocity);
                }
                if(keyCode == KeyEvent.VK_UP) {
                    paddle.p_yVelocity = 0;
                }
                if(keyCode == KeyEvent.VK_W) {
                    paddle.o_yVelocity = 0;
                }
                if(keyCode == KeyEvent.VK_S) {
                    paddle.o_yVelocity = 0;
                }
            }
        });
        setVisible(true);
    }

    public static void main(String[] args) {
        new Shapes();
    }
}