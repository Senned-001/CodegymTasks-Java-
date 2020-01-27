package com.codegym.task.task34.task3410.model;

import java.io.*;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class LevelLoader {
    private BufferedReader bf;

    public LevelLoader(Path levels) {
        try {
            this.bf = new BufferedReader(new FileReader(levels.toString()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public GameObjects getLevel(int level){
        int currentlevel = level;
        while(currentlevel>60){
            currentlevel-=60;
        }

        Set<Wall>walls = new HashSet<>();
        Set<Box>boxes = new HashSet<>();
        Set<StorageLocation>storageLocations = new HashSet<>();
        Player player;

        String strFromFile=null;
        while(true){
            strFromFile=bf.readLine();
            if(strFromFile.equals("Maze: "+currentlevel)){
                bf.readLine();
                String newline = bf.readLine();
                int sizeX = Integer.parseInt(newline.split(" ")[2]);
                newline = bf.readLine();
                int sizeY = Integer.parseInt(newline.split(" ")[2]);
                bf.readLine();
                bf.readLine();
                bf.readLine();
                for(int i = 0;i<sizeY;i++){
                    newline = bf.readLine();
                    for(int j = 0; j < sizeX; j++){
                        switch(newline.charAt(j)){
                            case 'X' : {

                                break;
                            }
                            case '*' : {

                                break;
                            }
                            case '.' : {

                                break;
                            }
                            case '@' : {

                                break;
                            }
                        }
                    }
                }
            }
        }



        Set<Wall>walls = new HashSet<>();
        walls.add(new Wall(20,80));
        walls.add(new Wall(160,360));
        walls.add(new Wall(420,180));

        Set<Box>boxes = new HashSet<>();
        boxes.add(new Box(60,60));

        Set<StorageLocation>storageLocations = new HashSet<>();
        storageLocations.add(new StorageLocation(400,400));

        return new GameObjects(walls, boxes, storageLocations, new Player(200,60));
    }
}
