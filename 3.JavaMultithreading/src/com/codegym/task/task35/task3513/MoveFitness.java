package com.codegym.task.task35.task3513;

public class MoveFitness implements Comparable<MoveFitness>{
    private int numberOfEmptyTiles;
    private int score;
    private Move move;

    public MoveFitness(int numberOfEmptyTiles, int score, Move move) {
        this.numberOfEmptyTiles = numberOfEmptyTiles;
        this.score = score;
        this.move = move;
    }

    public Move getMove() {
        return move;
    }

    @Override
    public int compareTo(MoveFitness a) {

        if(this.numberOfEmptyTiles>a.numberOfEmptyTiles) return 1;
        else if(this.numberOfEmptyTiles<a.numberOfEmptyTiles) return -1;
        else{
            if(this.score>a.score) return 1;
            else if(this.score<a.score) return -1;
            else return 0;
        }

    }
}
