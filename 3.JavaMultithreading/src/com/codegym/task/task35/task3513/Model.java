package com.codegym.task.task35.task3513;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][]gameTiles=new Tile[FIELD_WIDTH][FIELD_WIDTH];
    private Stack<Tile[][]> previousStates=new Stack<>();
    public int score;
    public Stack<Integer> previousScores=new Stack<>();
    public int maxTile;
    public boolean isSaveNeeded=true;

    public Model() {
        resetGameTiles();
        score=0;
        maxTile=0;
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    public boolean canMove(){
        boolean isPossible=false;
           for (int i = 0; i < gameTiles.length; i++) {
               for (int j = 0; j < gameTiles[0].length - 1; j++) {
                   if(gameTiles[i][j].value ==0) isPossible=true;
                   if (gameTiles[i][j].value == gameTiles[i][j + 1].value)isPossible=true;
                   if (i != gameTiles.length - 1) {
                       if (gameTiles[i][j].value == gameTiles[i + 1][j].value) isPossible=true;
                   }
               }
           }

        return isPossible;
    }

    public void resetGameTiles(){
        for(int i=0;i<gameTiles.length;i++){
            for(int j=0;j<gameTiles[i].length;j++){
                gameTiles[i][j]=new Tile();               //initialization board with empty tiles
            }
        }

        addTile();
        addTile();
    }

    private List<Tile> getEmptyTiles(){
        List<Tile>listOfEmptyTiles=new ArrayList<>();
        for(int i=0;i<gameTiles.length;i++) {
            for (int j = 0; j < gameTiles[i].length; j++) {
                if (gameTiles[i][j].value == 0) listOfEmptyTiles.add(gameTiles[i][j]);
            }
        }
        return listOfEmptyTiles;
    }

    public void addTile(){
        List<Tile>listOfEmptyTiles=getEmptyTiles();
        if(listOfEmptyTiles.size()>0){
            int randomIndex=(int)(listOfEmptyTiles.size()*Math.random());
            listOfEmptyTiles.get(randomIndex).value=(Math.random() < 0.9 ? 2 : 4);
        }
    }

    private boolean consolidateTiles(Tile[] tiles){
        boolean isChanged=false;
        for (int i=0;i<tiles.length-1;i++){
            for(int j=0;j<tiles.length-1;j++){
                if((tiles[j].value==0)&&(tiles[j+1].value!=0)){              //if finding 0 change them to next notnull element->
                    int a=tiles[j].value;
                    tiles[j].value=tiles[j+1].value;
                    tiles[j+1].value=a;
                    isChanged=true;
                }
            }
        }
        return isChanged;
    }

    private boolean mergeTiles(Tile[] tiles){
        boolean isChanged=false;
        for (int i=0;i<tiles.length-1;i++){
            if((tiles[i].value==tiles[i+1].value)&&(tiles[i].value!=0)){
                tiles[i].value=tiles[i].value*2;
                tiles[i+1].value=0;
                consolidateTiles(tiles);
                this.score+=tiles[i].value;
                if(this.maxTile<tiles[i].value) this.maxTile=tiles[i].value;
                isChanged=true;
            }
        }
        return isChanged;
    }

    public void left(){
        if(this.isSaveNeeded) saveState(gameTiles);
        int n=0;
        for(int i=0;i<gameTiles.length;i++){
            if(consolidateTiles(gameTiles[i])) n++;
            if(mergeTiles(gameTiles[i])) n++;
        }
        if(n>0) addTile();
        this.isSaveNeeded=true;
    }

    public void up(){
        saveState(gameTiles);
        rotate(gameTiles);
        rotate(gameTiles);
        rotate(gameTiles);
        left();
        rotate(gameTiles);
    }
    public void right(){
        saveState(gameTiles);
        rotate(gameTiles);
        rotate(gameTiles);
        left();
        rotate(gameTiles);
        rotate(gameTiles);
    }
    public void down(){
        saveState(gameTiles);
        rotate(gameTiles);
        left();
        rotate(gameTiles);
        rotate(gameTiles);
        rotate(gameTiles);
    }

    private Tile[][] rotate(Tile[][] tiles){                        //rotate titles on 90 d
        Tile[][]temp=new Tile[tiles.length][tiles[0].length];       //create temp array with copy titles
        for(int i=0;i<tiles.length;i++){
            for(int j=0;j<tiles[i].length;j++) {
                temp[i][j]=tiles[i][j];
            }
        }

        for(int i=0;i<temp.length;i++){
            for(int j=0;j<temp[0].length;j++){
               tiles[i][temp[0].length-j-1]=temp[j][i];             //change titles from copy
            }
        }
        return tiles;
    }

    private void saveState(Tile[][] tiles){
        Tile[][]temp=new Tile[tiles.length][tiles[0].length];       //create temp array with copy titles
        for(int i=0;i<tiles.length;i++){
            for(int j=0;j<tiles[0].length;j++) {
                temp[i][j]=new Tile(tiles[i][j].value);
            }
        }

        this.previousScores.push(this.score);
        this.previousStates.push(temp);
        this.isSaveNeeded=false;
    }

    public void rollback(){
        if(!previousStates.empty()&&!previousScores.empty()){
            this.score=previousScores.pop();
            this.gameTiles = previousStates.pop();
        }

    }
}
