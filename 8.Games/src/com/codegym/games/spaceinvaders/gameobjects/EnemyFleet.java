package com.codegym.games.spaceinvaders.gameobjects;

import com.codegym.engine.cell.Game;
import com.codegym.games.spaceinvaders.Direction;
import com.codegym.games.spaceinvaders.ShapeMatrix;
import com.codegym.games.spaceinvaders.SpaceInvadersGame;

import java.util.ArrayList;
import java.util.List;

public class EnemyFleet {
    private static final int ROWS_COUNT = 3;
    private static final int COLUMNS_COUNT = 10;
    private static final int STEP = ShapeMatrix.ENEMY.length + 1;
    private List<EnemyShip> ships;
    private Direction direction = Direction.RIGHT;

    public EnemyFleet() {
        createShips();
    }

    public void draw(Game game){
        for(EnemyShip es : ships){
            es.draw(game);
        }
    }

    private void createShips(){
        ships = new ArrayList<>();
        for(int j = 0; j< ROWS_COUNT;j++){
            for(int i = 0;i < COLUMNS_COUNT;i++){
                ships.add(new EnemyShip(i * STEP, j * STEP + 12));
            }
        }
        ships.add(new Boss(STEP * COLUMNS_COUNT / 2 - ShapeMatrix.BOSS_ANIMATION_FIRST.length / 2 - 1,5));
    }

    private double getLeftBorder(){
        double min = ships.get(0).x;
        for (EnemyShip ship : ships) {
            if((ship.x)<min)
                min = ship.x;
        }
        return min;
    }

    private double getRightBorder(){
        double max = ships.get(0).x;
        for (EnemyShip ship : ships) {
            if((ship.x+ship.width)>max)
                max = ship.x+ship.width;
        }
        return max;
    }

    private double getSpeed(){
        return 2.0<(3.0/ships.size())?2.0:(3.0/ships.size());
    }

    public void move(){
        if(!ships.isEmpty()){
            if(direction.equals(Direction.LEFT)&&getLeftBorder()<0)
                direction = Direction.RIGHT;
            else if(direction.equals(Direction.RIGHT)&&getRightBorder()> SpaceInvadersGame.WIDTH)
                direction = Direction.LEFT;
            else {
                for (EnemyShip ship : ships) {
                    ship.move(direction, getSpeed());
                }
                return;
            }
            for (EnemyShip ship : ships) {
                ship.move(Direction.DOWN, getSpeed());
            }
        }
    }

    public Bullet fire(Game game){
        if(ships.isEmpty()||game.getRandomNumber(100 / SpaceInvadersGame.DIFFICULTY)>0)
            return null;
        return ships.get(game.getRandomNumber(ships.size())).fire();
    }

    public void deleteHiddenShips(){
        ships.removeIf(s->(!s.isVisible()));
    }

    public double getBottomBorder(){
        double maxsum = 0;
        for(Ship ship:ships){
            if(ship.y+ship.height>maxsum)
                maxsum = ship.y+ship.height;
        }
        return maxsum;
    }

    public int getShipCount(){
        return ships.size();
    }

    public int checkHit(List<Bullet> bullets){
        if(bullets.isEmpty())
            return 0;
        int sumOfScores = 0;
        for(EnemyShip ship : ships){
            if(ship.isAlive) {
                for (Bullet bullet : bullets) {
                    if(bullet.isAlive) {
                        if(ship.isCollision(bullet)){
                            ship.kill();
                            bullet.kill();
                            sumOfScores+=ship.score;
                            break;
                        }
                    }
                }
            }
        }
        return sumOfScores;
    }
}
