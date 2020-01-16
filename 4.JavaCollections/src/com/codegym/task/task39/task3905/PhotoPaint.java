package com.codegym.task.task39.task3905;

public class PhotoPaint {
    public boolean paintFill(Color[][] image, int x, int y, Color desiredColor) {
        if(x>=image[0].length||y>=image.length||image[y][x]==desiredColor){
            return false;
        }
        image[y][x]=desiredColor;
        return true;
    }
}
