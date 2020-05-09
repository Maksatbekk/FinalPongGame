
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel extends JPanel implements ActionListener {

    Paddle paddle = new Paddle();
    Ball ball = new Ball();
    Timer timer;

    public Panel() {
        this.setFocusable(true);
        timer = new Timer(10,this);

        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        g.fillRect(0,0, Shapes.WIN_WIDTH, Shapes.WIN_HEIGHT);
        paddle.paint(g);
    }

    public void update() {
        if(paddle.started) {
            ball.update();
            paddle.update();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
        update();
    }
}