//Author : Ashray Naik
//Roll No: 09
//Title :OUTDOOR GAME

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AirHockeyGame extends JPanel implements ActionListener {
    private int puckX = 250, puckY = 250, puckDiameter = 20;
    private int paddle1X = 50, paddle1Y = 200, paddleDiameter = 50;
    private int paddle2X = 450, paddle2Y = 200;
    private int paddleSpeed = 5;
    private int puckSpeedX = 2, puckSpeedY = 2;
    private Timer timer;

    private int score1 = 0, score2 = 0; // Score variables for both players

    private boolean wPressed = false; // For Player 1 up
    private boolean sPressed = false; // For Player 1 down
    private boolean aPressed = false; // For Player 1 left
    private boolean dPressed = false; // For Player 1 right
    private boolean upPressed = false; // For Player 2 up
    private boolean downPressed = false; // For Player 2 down
    private boolean leftPressed = false; // For Player 2 left
    private boolean rightPressed = false; // For Player 2 right

    public AirHockeyGame() {
        timer = new Timer(20, this);
        timer.start();

        setPreferredSize(new Dimension(500, 500));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_W: wPressed = true; break;
                    case KeyEvent.VK_S: sPressed = true; break;
                    case KeyEvent.VK_A: aPressed = true; break;
                    case KeyEvent.VK_D: dPressed = true; break;
                    case KeyEvent.VK_UP: upPressed = true; break;
                    case KeyEvent.VK_DOWN: downPressed = true; break;
                    case KeyEvent.VK_LEFT: leftPressed = true; break;
                    case KeyEvent.VK_RIGHT: rightPressed = true; break;
                }
            }

            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_W: wPressed = false; break;
                    case KeyEvent.VK_S: sPressed = false; break;
                    case KeyEvent.VK_A: aPressed = false; break;
                    case KeyEvent.VK_D: dPressed = false; break;
                    case KeyEvent.VK_UP: upPressed = false; break;
                    case KeyEvent.VK_DOWN: downPressed = false; break;
                    case KeyEvent.VK_LEFT: leftPressed = false; break;
                    case KeyEvent.VK_RIGHT: rightPressed = false; break;
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillOval(puckX, puckY, puckDiameter, puckDiameter);
        g.fillOval(paddle1X, paddle1Y, paddleDiameter, paddleDiameter);
        g.fillOval(paddle2X, paddle2Y, paddleDiameter, paddleDiameter);

        g.setColor(Color.RED);
        g.fillRect(0, 200, 20, 100); // Left goal
        g.fillRect(480, 200, 20, 100); // Right goal

        g.setColor(Color.WHITE);
        g.drawString("Score: " + score1 + " - " + score2, 200, 30); // Display scores
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Update paddle positions based on key states
        if (wPressed && paddle1Y > 0) paddle1Y -= paddleSpeed; // Move paddle1 up
        if (sPressed && paddle1Y < 450) paddle1Y += paddleSpeed; // Move paddle1 down
        if (aPressed && paddle1X > 0) paddle1X -= paddleSpeed; // Move paddle1 left
        if (dPressed && paddle1X < 250 - paddleDiameter) paddle1X += paddleSpeed; // Move paddle1 right within half

        if (upPressed && paddle2Y > 0) paddle2Y -= paddleSpeed; // Move paddle2 up
        if (downPressed && paddle2Y < 450) paddle2Y += paddleSpeed; // Move paddle2 down
        if (leftPressed && paddle2X > 250) paddle2X -= paddleSpeed; // Move paddle2 left within half
        if (rightPressed && paddle2X < 500 - paddleDiameter) paddle2X += paddleSpeed; // Move paddle2 right

        puckX += puckSpeedX;
        puckY += puckSpeedY;

        // Check for scoring
        if (puckX < 20 && puckY + puckDiameter > 200 && puckY < 300) {
            score2++;
            resetPuck(true);
        } else if (puckX > 460 && puckY + puckDiameter > 200 && puckY < 300) {
            score1++;
            resetPuck(false);
        }

        // Boundary checks for puck
        if (puckY < 0 || puckY > 480) {
            puckSpeedY = -puckSpeedY;
            puckY = Math.max(0, Math.min(puckY, 480));
        }
        if (puckX < 0) {
            puckX = 0;
            puckSpeedX = -puckSpeedX;
        } else if (puckX > 480) {
            puckX = 480;
            puckSpeedX = -puckSpeedX;
        }

        // Paddle collision
        Rectangle puckRect = new Rectangle(puckX, puckY, puckDiameter, puckDiameter);
        Rectangle paddle1Rect = new Rectangle(paddle1X, paddle1Y, paddleDiameter, paddleDiameter);
        Rectangle paddle2Rect = new Rectangle(paddle2X, paddle2Y, paddleDiameter, paddleDiameter);

        if (paddle1Rect.intersects(puckRect)) {
            puckSpeedX = Math.abs(puckSpeedX);
            puckX += 5;
        }
        if (paddle2Rect.intersects(puckRect)) {
            puckSpeedX = -Math.abs(puckSpeedX);
            puckX -= 5;
        }

        repaint();
    }

    private void resetPuck(boolean isLeftGoal) {
        puckY = 250;
        if (isLeftGoal) {
            puckX = 460;
            puckSpeedX = -2;
        } else {
            puckX = 20;
            puckSpeedX = 2;
        }
        puckSpeedY = (Math.random() > 0.5 ? 2 : -2);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Air Hockey Game");
        AirHockeyGame gamePanel = new AirHockeyGame();
        frame.add(gamePanel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
