import java.util.Random;

public class Ball {

    static Random ran = new Random();

    public static int BALL_HEIGHT = 10;
    public static int BALL_WIDTH = BALL_HEIGHT;
    public static int BALL_X = Shapes.WIN_WIDTH/2 - BALL_WIDTH;
    public static int BALL_Y = Shapes.WIN_HEIGHT/2 - BALL_HEIGHT;
    public static int o_score = 0, p_score = 0;
    public static int bxVelocity = ran.nextInt(8 - 1) - 4, byVelocity =
            ran.nextInt(8 - 1) - 4;

    public void update() {

        BALL_X += bxVelocity;
        BALL_Y += byVelocity;

        while(bxVelocity == 0 || byVelocity == 0) {
            bxVelocity = ran.nextInt(8 - 1) - 4;
            byVelocity = ran.nextInt(8 - 1) - 4;
        }
        if((BALL_Y >= Paddle.p_y && BALL_Y <= Paddle.p_y + Paddle.RECT_HEIGHT)
                && (BALL_X <= Paddle.p_x + Paddle.RECT_WIDTH)) {
            bxVelocity = -bxVelocity;
        }
        if((BALL_Y >= Paddle.o_y && BALL_Y <= Paddle.o_y + Paddle.RECT_HEIGHT)
                && (BALL_X >= Paddle.o_x - Paddle.RECT_WIDTH)) {
            bxVelocity = -bxVelocity;
        }
        if(BALL_Y >= 355) {
            byVelocity = -byVelocity;
        }
        if(BALL_Y <= 0) {
            byVelocity = -byVelocity;
        }
        if(BALL_X <= 0) {
            BALL_X = Shapes.WIN_WIDTH/2 - BALL_WIDTH;
            BALL_Y = Shapes.WIN_HEIGHT/2 - BALL_HEIGHT;
            o_score++;
            Paddle.end();
        }
        if(BALL_X >= 700) {
            BALL_X = Shapes.WIN_WIDTH/2 - BALL_WIDTH;
            BALL_Y = Shapes.WIN_HEIGHT/2 - BALL_HEIGHT;
            p_score++;
            Paddle.end();
        }
    }


    public static void newVelocity() {
        bxVelocity = ran.nextInt(8 - 1) - 4;
        byVelocity = ran.nextInt(8 - 1) - 4;

        while(bxVelocity == 0 || byVelocity == 0) {
            bxVelocity = ran.nextInt(8 - 1) - 4;
            byVelocity = ran.nextInt(8 - 1) - 4;
        }
        System.out.println(bxVelocity);
    }
}