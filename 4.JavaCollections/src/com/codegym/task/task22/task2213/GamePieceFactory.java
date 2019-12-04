package com.codegym.task.task22.task2213;

/**
 * The GamePieceFactory class is responsible for creating GamePiece objects.
 */
public class GamePieceFactory {
    /**
     * A set of six patterns for creating game pieces
     */
    public static final int[][][] BRICKS = {{
            {1, 1, 0},                          //   X X
            {0, 1, 1},                          //     X X
            {0, 0, 0}}, {                       //

            {1, 0, 0},                          //   X
            {1, 1, 0},                          //   X X
            {0, 1, 0}}, {                       //     X

            {0, 1, 0},                          //   X
            {0, 1, 0},                          //   X
            {0, 1, 0}}, {                       //   X

            {1, 1, 0},                          //   X X
            {1, 1, 0},                          //   X X
            {0, 0, 0}}, {                       //

            {1, 1, 1},                          //   X X X
            {0, 1, 0},                          //     X
            {0, 0, 0}}, {                       //

            {1, 1, 1},                          //   X X X
            {1, 1, 1},                          //   X X X
            {0, 0, 0}}                          //
    };

    /**
     * The method selects a random pattern and uses it to create a new game piece.
     */
    public static GamePiece createRandomGamePiece(int x, int y) {
        int index = (int) (Math.random() * 6);
        return new GamePiece(x, y, BRICKS[index]);
    }
}