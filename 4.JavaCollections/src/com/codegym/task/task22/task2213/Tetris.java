package com.codegym.task.task22.task2213;

import java.awt.event.KeyEvent;

/**
 * The Tetris class contains the basic functionality of the game.
 */
public class Tetris {

    private Field field;                // Game field
    private GamePiece gamePiece;              // Game piece

    private boolean isGameOver;         // Indicates whether the game is over

    public Tetris(int width, int height) {
        field = new Field(width, height);
        gamePiece = null;
    }

    /**
     * Getter for the field variable.
     */
    public Field getField() {
        return field;
    }

    /**
     * Getter for the gamePiece variable.
     */
    public GamePiece getGamePiece() {
        return gamePiece;
    }

    /**
     * The program's main loop.
     * This is where all the important actions happen
     */
    public void run() throws Exception {
        // Create a KeyboardObserver object and start it.
        KeyboardObserver keyboardObserver = new KeyboardObserver();
        keyboardObserver.start();

        // Set the initial value of isGameOver to false
        isGameOver = false;
        // Create the first game piece in the middle at the top: x = half of the width, y = 0.
        gamePiece = GamePieceFactory.createRandomGamePiece(field.getWidth()/2, 0);

        // The game is not over yet
        while (!isGameOver) {
            // Does the observer have any key events?
            if (keyboardObserver.hasKeyEvents()) {
                // Get the first event from the queue
                KeyEvent event = keyboardObserver.getEventFromTop();
                // If 'q', then exit the game.
                if (event.getKeyChar() == 'q') return;
                // If "left arrow", then move the game piece to the left
                if (event.getKeyCode() == KeyEvent.VK_LEFT)
                    gamePiece.left();
                    // If "right arrow", then move the game piece to the right
                else if (event.getKeyCode() == KeyEvent.VK_RIGHT)
                    gamePiece.right();
                    // If the key code is 12 ("5 on the numeric keypad), rotate the game piece
                else if (event.getKeyCode() == 12)
                    gamePiece.rotate();
                    // If it's a space, then drop the game piece at top speed
                else if (event.getKeyCode() == KeyEvent.VK_SPACE)
                    gamePiece.downMaximum();
            }

            step();             // Take a step
            field.print();      // Display the field
            Thread.sleep(300);  // Pause 300 milliseconds (about 1/3 of a second)
        }

        // Display "Game Over"
        System.out.println("Game Over");
    }

    public void step() {
        // Drop the game piece down
        gamePiece.down();

        // If the game piece can't be placed in the current location
        if (!gamePiece.isCurrentPositionAvailable()) {
            gamePiece.up();                    // Put it back
            gamePiece.land();                // Land it

            isGameOver = gamePiece.getY () <= 1; // If the game piece lands at the very top, then the game is over

            field.removeFullLines();        // Remove the completed lines

            gamePiece = GamePieceFactory.createRandomGamePiece(field.getWidth()/2, 0); // Create a new game piece
        }
    }

    /**
     * Setter for gamePiece
     */
    public void setGamePiece(GamePiece gamePiece) {
        this.gamePiece = gamePiece;
    }

    /**
     * Setter for field
     */
    public void setField(Field field) {
        this.field = field;
    }

    public static Tetris game;

    public static void main(String[] args) throws Exception {
        game = new Tetris(10, 20);
        game.run();
    }
}