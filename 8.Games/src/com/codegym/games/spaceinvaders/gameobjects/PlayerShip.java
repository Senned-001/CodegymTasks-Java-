package com.codegym.games.spaceinvaders.gameobjects;

import com.codegym.games.spaceinvaders.ShapeMatrix;
import com.codegym.games.spaceinvaders.SpaceInvadersGame;

import java.util.List;

public class PlayerShip extends Ship {
    public boolean isAlive = true;

    public PlayerShip() {
        super(SpaceInvadersGame.WIDTH / 2.0, SpaceInvadersGame.HEIGHT - ShapeMatrix.PLAYER.length - 1);
        super.setStaticView(ShapeMatrix.PLAYER );
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
            setAnimatedView(ShapeMatrix.KILL_PLAYER_ANIMATION_FIRST,
                    ShapeMatrix.KILL_PLAYER_ANIMATION_SECOND,
                    ShapeMatrix.KILL_PLAYER_ANIMATION_THIRD,
                    ShapeMatrix.DEAD_PLAYER);
        }
    }
}
