package com.codegym.games.racer.road;

import com.codegym.engine.cell.Game;
import com.codegym.games.racer.GameObject;
import com.codegym.games.racer.PlayerCar;
import com.codegym.games.racer.RacerGame;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RoadManager {
    public static final int LEFT_BORDER = RacerGame.ROADSIDE_WIDTH;
    public static final int RIGHT_BORDER = RacerGame.WIDTH - LEFT_BORDER;
    private static final int FIRST_LANE_POSITION = 16;
    private static final int FOURTH_LANE_POSITION = 44;
    private List<RoadObject> items = new ArrayList<>();

    private RoadObject createRoadObject(RoadObjectType type, int x, int y){
        if(type.equals(RoadObjectType.SPIKE))
            return new Spike(x, y);
        return null;
    }

    private void addRoadObject(RoadObjectType type, Game game){
        int x = game.getRandomNumber(FIRST_LANE_POSITION, FOURTH_LANE_POSITION);
        int y = -1 * RoadObject.getHeight(type);
        RoadObject newRoadObject = createRoadObject(type,x,y);
        if(newRoadObject!=null)
            items.add(newRoadObject);
    }

    public void draw(Game game){
        for(RoadObject ro : items){
            ro.draw(game);
        }
    }

    public void move(int boost){
        for(RoadObject ro : items){
            ro.move(boost+ro.speed);
        }
        deletePassedItems();
    }

    private boolean spikeExists(){
        for (RoadObject ro : items){
            if(ro.type.equals(RoadObjectType.SPIKE))
                return true;
        }
        return false;
    }

    private void generateSpike(Game game){
        if(!spikeExists())
            if(game.getRandomNumber(100)<10)
                addRoadObject(RoadObjectType.SPIKE, game);
    }

    public void generateNewRoadObjects(Game game){
        generateSpike(game);
    }

    private void deletePassedItems(){
        items.removeIf(roadObject -> roadObject.y >= RacerGame.HEIGHT);
    }

    public boolean checkCrash(PlayerCar playerCar){
        for (RoadObject ro : items){
            if(ro.isCollision(playerCar))
                return true;
        }
        return false;
    }
}
