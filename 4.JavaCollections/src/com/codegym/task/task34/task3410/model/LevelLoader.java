package com.codegym.task.task34.task3410.model;

import java.io.*;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

public class LevelLoader {
    private Path path;

    public LevelLoader(Path levels) {
            this.path = levels;
    }

    public GameObjects getLevel(int level){

        int currentlevel = level;
        while(currentlevel>60){         //for level 61=1 etc.
            currentlevel-=60;
        }

        Set<Wall>walls = new HashSet<>();
        Set<Box>boxes = new HashSet<>();
        Set<StorageLocation>storageLocations = new HashSet<>();
        Player player = null;
        int cell = Model.BOARD_CELL_SIZE;

        String strFromFile=null;
        try {
            BufferedReader bf = new BufferedReader(new FileReader(path.toString()));
            while(true){
                strFromFile=bf.readLine();
                if(strFromFile.equals("Maze: "+currentlevel)){                  //finding necessary level
                    bf.readLine();
                    String newline = bf.readLine();
                    int sizeX = Integer.parseInt(newline.split(" ")[2]);
                    newline = bf.readLine();
                    int sizeY = Integer.parseInt(newline.split(" ")[2]);
                    bf.readLine();
                    bf.readLine();
                    bf.readLine();
                    for(int i = 0;i<sizeY;i++){                                 //read objects each by each
                        newline = bf.readLine();
                        for(int j = 0; j < sizeX; j++){
                            switch(newline.charAt(j)){
                                case 'X' : {
                                    walls.add(new Wall(cell/2+j*cell,cell/2+i*cell));
                                    break;
                                }
                                case '*' : {
                                    boxes.add(new Box(cell/2+j*cell,cell/2+i*cell));
                                    break;
                                }
                                case '.' : {
                                    storageLocations.add(new StorageLocation(cell/2+j*cell,cell/2+i*cell));
                                    break;
                                }
                                case '@' : {
                                    player = new Player(cell/2+j*cell,cell/2+i*cell);
                                    break;
                                }
                                case '&' : {
                                    boxes.add(new Box(cell/2+j*cell,cell/2+i*cell));
                                    storageLocations.add(new StorageLocation(cell/2+j*cell,cell/2+i*cell));
                                    break;
                                }
                            }
                        }
                    }
                    break;
                }
            }
            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new GameObjects(walls, boxes, storageLocations, player);
    }
}
