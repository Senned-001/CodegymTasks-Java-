package com.codegym.task.task20.task2026;

/* 
Rectangle algorithms

*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Must be 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Must be 4");
    }

    public static int getRectangleCount(byte[][] a) {
        int kol = 0;
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){                 //finding first element with 1
                if(a[i][j]==1) {                            //if finded - replace by 0 and scan next element from this element on right and on down
                    for(int k=i;k<a.length;k++){            //if finded -repeat, if not break and count++
                        if(a[k][j]==1) {                    //finding other element with 1
                            for (int n = j; n < a[0].length; n++) {
                                if (a[k][n] == 1)
                                    a[k][n] = 0;
                                else
                                    break;
                            }
                        }
                        else
                            break;
                    }
                    kol++;
                }
            }
        }
        return kol;
    }
}
