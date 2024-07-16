

import javax.swing.*;
import java.awt.*;

public class BouncingBall extends JPanel {

    private int x = 0;
    private int y = 0;
    private int dx = 2;
    private int dy = 2;
    private int ballSize = 20;

    public BouncingBall() {
        setBackground(Color.BLACK);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillOval(x, y, ballSize, ballSize);
    }

    public void update() {
        x += dx;
        y += dy;

        if (x < 0 || x > getWidth() - ballSize) {
            dx = -dx;
        }
        if (y < 0 || y > getHeight() - ballSize) {
            dy = -dy;
        }

        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bouncing Ball");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new BouncingBall());
        frame.setSize(400, 400);
        frame.setVisible(true);

        BouncingBall ball = (BouncingBall) frame.getContentPane().getComponent(0);
        while (true) {
            ball.update();
            try {
                Thread.sleep(16); // 60 FPS
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}