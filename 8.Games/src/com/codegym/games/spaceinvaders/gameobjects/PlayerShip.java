package com.codegym.games.spaceinvaders.gameobjects;

import com.codegym.games.spaceinvaders.Direction;
import com.codegym.games.spaceinvaders.ShapeMatrix;
import com.codegym.games.spaceinvaders.SpaceInvadersGame;

import java.util.List;

public class PlayerShip extends Ship {
    public boolean isAlive = true;
    private Direction direction = Direction.UP;

    public PlayerShip() {
        super(SpaceInvadersGame.WIDTH / 2.0, SpaceInvadersGame.HEIGHT - ShapeMatrix.PLAYER.length - 1);
        super.setStaticView(ShapeMatrix.PLAYER );
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction newDirection) {
        if(!newDirection.equals(Direction.DOWN))
            this.direction = newDirection;
    }

    public void checkHit(List<Bullet> bullets){
        if(!bullets.isEmpty()&&this.isAlive) {
            for (Bullet bullet : bullets) {
                if(bullet.isAlive) {
                    if (this.isCollision(bullet)) {
                        kill();
                        bullet.kill();
                    }
                }
            }
        }
    }

    @Override
    public void kill() {
        if(isAlive){
            isAlive = false;
            setAnimatedView( false, ShapeMatrix.KILL_PLAYER_ANIMATION_FIRST,
                    ShapeMatrix.KILL_PLAYER_ANIMATION_SECOND,
                    ShapeMatrix.KILL_PLAYER_ANIMATION_THIRD,
                    ShapeMatrix.DEAD_PLAYER);
        }
    }

    public void move(){
        if(isAlive){
            if(direction.equals(Direction.LEFT))
                this.x--;
            if(direction.equals(Direction.RIGHT))
                this.x++;
            if(this.x<0)
                x=0;
            if(this.x+this.width>SpaceInvadersGame.WIDTH)
                x=SpaceInvadersGame.WIDTH-width;
        }
    }

    @Override
    public Bullet fire() {
        if(!isAlive)
            return null;
        return new Bullet(x + 2, y - ShapeMatrix.BULLET.length, Direction.UP);
    }

    public void win(){
        setStaticView(ShapeMatrix.WIN_PLAYER);
    }
}
