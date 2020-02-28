package com.codegym.task.task27.task2712.ad;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class StatisticsAdvertisementManager {
    private static StatisticsAdvertisementManager statisticsAdvertisementManager = new StatisticsAdvertisementManager();
    private AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();

    private StatisticsAdvertisementManager() {
    }

    public static StatisticsAdvertisementManager getInstance(){
        return statisticsAdvertisementManager;
    }

    public List<String> getActiveVideoSet(){
        List<String> result = new ArrayList<>();
        for(Advertisement a : advertisementStorage.list()){
            if(a.getImpressionsRemaining()>0)
                result.add(a.getName()+ " - " + a.getImpressionsRemaining());
        }
        return result;
    }

    public List<String> getInactiveVideoSet(){
        List<String> result = new ArrayList<>();
        for(Advertisement a : advertisementStorage.list()){
            if(a.getImpressionsRemaining()==0)
                result.add(a.getName());
        }
        return result;
    }
}
