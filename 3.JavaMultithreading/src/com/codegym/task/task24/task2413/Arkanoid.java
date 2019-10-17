package com.codegym.task.task24.task2413;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * The game's main class
 */
public class Arkanoid {
    private int width;
    private int height;

    private ArrayList<Brick> bricks = new ArrayList<Brick>();
    private Ball ball;
    private Paddle paddle;

    private boolean isGameOver = false;

    public Arkanoid(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public ArrayList<Brick> getBricks() {
        return bricks;
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public Paddle getPaddle() {
        return paddle;
    }

    public void setPaddle(Paddle paddle) {
        this.paddle = paddle;
    }

    /**
     * Draw the borders and all objects on the canvas.
     */
    void draw(Canvas canvas) {
        drawBorders(canvas);

        // Draw bricks
        for (Brick brick : bricks) {
            brick.draw(canvas);
        }

        // Draw the ball
        ball.draw(canvas);

        // Draw the paddle
        paddle.draw(canvas);

    }

    /**
     * Draw the borders on the canvas
     */
    private void drawBorders(Canvas canvas) {
        // Draw the game
        for (int i = 0; i < width + 2; i++) {
            for (int j = 0; j < height + 2; j++) {
                canvas.setPoint(i, j, '.');
            }
        }

        for (int i = 0; i < width + 2; i++) {
            canvas.setPoint(i, 0, '-');
            canvas.setPoint(i, height + 1, '-');
        }

        for (int i = 0; i < height + 2; i++) {
            canvas.setPoint(0, i, '|');
            canvas.setPoint(width + 1, i, '|');
        }
    }

    /**
     * The program's main loop.
     * This is where all the important actions happen
     */
    void run() throws Exception {
        // Create a drawing canvas
        Canvas canvas = new Canvas(width, height);

        // Create a KeyboardObserver object and start it
        KeyboardObserver keyboardObserver = new KeyboardObserver();
        keyboardObserver.start();

        // Execute the loop until the game is over
        while (!isGameOver) {
            // Does the observer have any key events?
            if (keyboardObserver.hasKeyEvents()) {
                KeyEvent event = keyboardObserver.getEventFromTop();

                // If "left arrow", then move the figure to the left
                if (event.getKeyCode() == KeyEvent.VK_LEFT)
                    paddle.moveLeft();
                    // If "right arrow", then move the figure to the right
                else if (event.getKeyCode() == KeyEvent.VK_RIGHT)
                    paddle.moveRight();
                    // If "space", then launch a ball
                else if (event.getKeyCode() == KeyEvent.VK_SPACE)
                    ball.start();
            }

            // Move all objects
            move();

            // Detect collisions
            checkBrickCollision();
            checkPaddleCollision();

            // Check whether the ball flew out the bottom.
            checkGameOver();

            // Draw all the objects
            canvas.clear();
            draw(canvas);
            canvas.print();

            // Pause
            Thread.sleep(300);
        }

        // Display "Game Over"
        System.out.println("Game Over!");
    }

    /**
     * Move the ball and the paddle.
     */
    public void move() {
        ball.move();
        paddle.move();
    }

    /**
     * Check for collision with bricks.
     * If there was a collision, the ball flies off in a random direction (0..360 degrees)
     */
    void checkBrickCollision() {
        for (Brick brick : new ArrayList<Brick>(bricks)) {
            if (ball.intersects(brick)) {
                double angle = Math.random() * 360;
                ball.setDirection(angle);

                bricks.remove(brick);
            }
        }
    }

    /**
     * Check for collision with the paddle.
     * If there was a collision, the ball flies up in a random direction (80..100 degrees).
     */
    void checkPaddleCollision() {
        if (ball.intersects(paddle)) {
            double angle = 90 + 20 * (Math.random() - 0.5);
            ball.setDirection(angle);
        }
    }

    /**
     * Check whether the ball flew out the bottom.
     * If it did, then the game is over (isGameOver = true)
     */
    void checkGameOver() {
        if (ball.getY() > height && ball.getDy() > 0)
            isGameOver = true;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public static Arkanoid game;

    public static void main(String[] args) throws Exception {
        game = new Arkanoid(20, 30);

        Ball ball = new Ball(10, 29, 2, 95);
        game.setBall(ball);

        Paddle paddle = new Paddle(10, 30);
        game.setPaddle(paddle);

        game.getBricks().add(new Brick(3, 3));
        game.getBricks().add(new Brick(7, 5));
        game.getBricks().add(new Brick(12, 5));
        game.getBricks().add(new Brick(16, 3));

        game.run();
    }
}



















