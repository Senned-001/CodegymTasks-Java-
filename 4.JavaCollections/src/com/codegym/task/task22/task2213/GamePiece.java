package com.codegym.task.task22.task2213;


/**
 * The GamePiece class describes a Tetris game piece
 */
public class GamePiece {
    // The matrix that determines the shape of the game piece: 1 - a non-empty cell, 0 - an empty cell
    private int[][] matrix;
    // Coordinates
    private int x;
    private int y;

    public GamePiece(int x, int y, int[][] matrix) {
        this.x = x;
        this.y = y;
        this.matrix = matrix;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    /**
     * Rotate the game piece.
     * For simplicity, simply rotate about the main diagonal.
     */
    public void rotate() {
        int[][] matrix2 = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix2[i][j] = matrix[j][i];
            }
        }

        matrix = matrix2;
    }

    /**
     * Move the game piece to the left.
     * Check whether it has moved beyond the edge of the game field and/or hit occupied cells.
     */
    public void left() {
        x--;
        if (!isCurrentPositionAvailable())
            x++;
    }

    /**
     * Move the game piece to the right.
     * Check whether it has moved beyond the edge of the game field and/or hit occupied cells.
     */
    public void right() {
        x++;
        if (!isCurrentPositionAvailable())
            x--;
    }

    /**
     * Move the game piece up.
     * This is used when the game piece has hit occupied cells.
     */
    public void up() {
        y--;
    }

    /**
     * Move the game piece down.
     */
    public void down() {
        y++;
    }

    /**
     * Move the game piece down until we hit something.
     */
    public void downMaximum() {
        while (isCurrentPositionAvailable()) {
            y++;
        }

        y--;
    }

    /**
     * Check whether the game piece can occupy the current position:
     * a) Has it moved beyond the edge of the game field?
     * b) Has it hit occupied cells?
     */
    public boolean isCurrentPositionAvailable() {
        Field field = Tetris.game.getField();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix[i][j] == 1) {
                    if (y + i >= field.getHeight())
                        return false;

                    Integer value = field.getValue(x + j, y + i);
                    if (value == null || value == 1)
                        return false;
                }
            }
        }

        return true;
    }

    /**
     * Land the game piece. Add all of its non-empty cells to the game field.
     */
    public void land() {
        Field field = Tetris.game.getField();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix[i][j] == 1)
                    field.setValue(x + j, y + i, 1);
            }
        }
    }
}