package com.codegym.games.moonlander;

public class Rocket extends GameObject {
    private double speedY = 0;
    private double boost = 0.05;
    private double speedX = 0;


        public Rocket(double x, double y) {
        super(x, y, ShapeMatrix.ROCKET);
    }

    public void move(boolean isUpPressed, boolean isLeftPressed, boolean isRightPressed){
        if(isUpPressed) {
            speedY-=boost;
        } else {
            speedY += boost;
        }
        this.y += speedY;

        if(isLeftPressed){
            speedX-=boost;
            this.x += speedX;
        }
        if(isRightPressed){
            speedX += boost;
            this.x += speedX;
        }
        checkBorders();
    }

    private void checkBorders(){
        if(this.x<0) {
            this.x = 0;
            speedX = 0;
        }
        if(this.x+this.width>MoonLanderGame.WIDTH) {
            this.x = MoonLanderGame.WIDTH - this.width;
            speedX = 0;
        }
        if(this.y<0) {
            this.y = 0;
            speedY = 0;
        }
    }
}
