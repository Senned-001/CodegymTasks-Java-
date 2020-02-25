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
        System.out.println(maxSquare(matrix));
    }

    //we start from the end with element matrix[length-2][length-2] and go to the start using fomula:if not null - matrix[j][i]=min(matrix[j+1][i],matrix[j+1][i+1],matrix[j][i+1])+1;
    public static int maxSquare(int[][] matrix) {
        int max=0;
        for(int j=matrix.length-2;j>=0;j--){
           for(int i=matrix[j].length-2;i>=0;i--){
               if(matrix[j][i]!=0){
                   matrix[j][i]=Math.min(matrix[j+1][i],Math.min(matrix[j+1][i+1],matrix[j][i+1]))+1;
                   if(max<matrix[j][i]) max = matrix[j][i];
               }
           }
       }
       return max*max;
    }
}
