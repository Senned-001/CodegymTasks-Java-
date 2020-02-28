package com.codegym.task.task27.task2712;

import com.codegym.task.task27.task2712.ad.Advertisement;
import com.codegym.task.task27.task2712.ad.StatisticsAdvertisementManager;
import com.codegym.task.task27.task2712.statistics.StatisticsManager;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class ManagerTablet {
    private StatisticsManager statisticsManager = StatisticsManager.getInstance();
    private StatisticsAdvertisementManager statisticsAdvertisementManager = StatisticsAdvertisementManager.getInstance();
    public void printAdRevenue(){
        TreeMap<Date, Double> result = statisticsManager.getDataofAdvertising();
        NavigableSet<Date> nset = result.descendingKeySet();
        DateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        double total = 0.0;
        for(Date d : nset){
            ConsoleHelper.writeMessage(df.format(d)+" - "+String.format("%.2f",result.get(d)).replace(",","."));
            total+=result.get(d);
        }
        ConsoleHelper.writeMessage("Total - " + String.format("%.2f",total).replace(",","."));
    }

    public void printCookUtilization(){
        TreeMap<Date, TreeMap<String, Integer>> result = statisticsManager.getDataofCooking();
        NavigableSet<Date> nset = result.descendingKeySet();
        DateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        for(Date d : nset){
            ConsoleHelper.writeMessage(df.format(d));
            for(Map.Entry<String, Integer> tm : result.get(d).entrySet()){
                ConsoleHelper.writeMessage(tm.getKey() +" - "+ tm.getValue() +" min");
            }
            ConsoleHelper.writeMessage("");
        }
    }

    public void printActiveVideoSet(){
        List<String> list = statisticsAdvertisementManager.getActiveVideoSet();
        list.sort(String::compareToIgnoreCase);
        list.forEach(ConsoleHelper::writeMessage);
    }

    public void printArchivedVideoSet(){
        List<String> list = statisticsAdvertisementManager.getInactiveVideoSet();
        list.sort(String::compareToIgnoreCase);
        list.forEach(ConsoleHelper::writeMessage);
    }
}
