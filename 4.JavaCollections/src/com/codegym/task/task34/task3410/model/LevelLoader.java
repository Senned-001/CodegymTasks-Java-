package com.codegym.task.task34.task3410.model;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class LevelLoader {


    public LevelLoader(Path levels) {
    }

    public GameObjects getLevel(int level){
        Set<Wall>walls = new HashSet<>();
        walls.add(new Wall(10,80));
        walls.add(new Wall(160,360));
        walls.add(new Wall(420,180));

        Set<Box>boxes = new HashSet<>();
        boxes.add(new Box(50,50));

        Set<StorageLocation>storageLocations = new HashSet<>();
        storageLocations.add(new StorageLocation(400,350));

        return new GameObjects(walls, boxes, storageLocations, new Player(200,50));
    }
}
