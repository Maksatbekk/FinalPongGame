

import java.awt.*;

public class Paddle {

    public Ball ball;

    public static int RECT_WIDTH = 10;
    public static int RECT_HEIGHT = 70;
    public static int p_x = 5;
    public static int o_x = 680;
    public static int p_y = Shapes.WIN_HEIGHT/2-50;
    public static int o_y = Shapes.WIN_HEIGHT/2-50;
    public static int xVelocity;
    public static int p_yVelocity, o_yVelocity;
    public static boolean started = false;

    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(p_x, p_y, RECT_WIDTH, RECT_HEIGHT);
        g.fillRect(o_x, o_y, RECT_WIDTH, RECT_HEIGHT);
        g.fillRect(ball.BALL_X, ball.BALL_Y, ball.BALL_WIDTH, ball.BALL_HEIGHT);

        g.setColor(Color.white);
        g.setFont(new Font("Arial", 1, 25));

        if (!started)
        {
            g.drawString("Press 'Enter' to Start", 225, 100);
        }
        g.drawString(Integer.toString(Ball.p_score), 315, 50);
        g.drawString("-", 335, 50);
        g.drawString(Integer.toString(Ball.o_score), 350, 50);
    }

    public void update() {
        p_x += xVelocity;
        p_y += p_yVelocity;
        o_y += o_yVelocity;
        if(p_y < 0) {
            p_y = 0;
        }
        if(p_y > 295) {
            p_y = 295;
        }
        if(o_y < 0) {
            o_y = 0;
        }
        if(o_y > 295) {
            o_y = 295;
        }
    }

    public static boolean start() {
        return started = true;
    }

    public static boolean end() {
        p_x = 5;
        o_x = 680;
        p_y = Shapes.WIN_HEIGHT/2-50;
        o_y = Shapes.WIN_HEIGHT/2-50;
        Ball.newVelocity();
        return started = false;
    }
}