package com.codegym.task.task39.task3912;

/* 
Maximum area

*/

public class Solution {
    public static void main(String[] args) {
        int[][] matrix = {{0,0,0,0,0,0},
                          {1,0,0,0,1,0},
                          {1,1,1,1,1,0},
                          {1,1,1,1,0,0},
                          {1,1,1,1,0,1},
                          {1,1,1,1,0,0}};
    }

    public static int maxSquare(int[][] matrix) {
        int counter=0;
        int maxx=0;
        int maxy=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==1){
                    counter++;
                }
                if(matrix[i][j]==0||j==matrix[0].length-1){
                    if(maxx<counter) maxx=counter;
                    counter=0;
                }
            }
        }
        counter=0;
        for(int i=0;i<matrix[0].length;i++){
            for(int j=0;j<matrix.length;j++){
                if(matrix[j][i]==1){
                    counter++;
                }
                if(matrix[j][i]==0||j==matrix.length-1){
                    if(maxy<counter) maxy=counter;
                    counter=0;
                }
            }
        }
        return maxx>maxy? maxy*maxy:maxx*maxx;
    }

}
