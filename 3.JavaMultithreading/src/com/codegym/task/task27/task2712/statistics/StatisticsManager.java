package com.codegym.task.task27.task2712.statistics;

import com.codegym.task.task27.task2712.kitchen.Cook;
import com.codegym.task.task27.task2712.statistics.event.*;

import java.util.*;

public class StatisticsManager {
    private static StatisticsManager statisticsManager = new StatisticsManager();
    private StatisticsStorage statisticsStorage = new StatisticsStorage();
    private StatisticsManager(){}

    public static StatisticsManager getInstance(){
        return statisticsManager;
    }

    public void record(EventDataRow data){
        statisticsStorage.put(data);
    }

    public TreeMap<Date, Double> getDataofAdvertising(){
        List<EventDataRow> data =  statisticsStorage.getStorage(EventType.VIDEOS_SELECTED);
        TreeMap<Date, Double>result = new TreeMap<>();

        for(EventDataRow e: data) {
            VideosSelectedEventDataRow vsedr = (VideosSelectedEventDataRow) e;
            long tempMilis = vsedr.getDate().getTime() / 86400000;
            Date newDate = new Date();
            newDate.setTime(tempMilis * 86400000 + 1);

            if (result.containsKey(newDate))
                result.put(newDate, result.get(newDate) + (double) vsedr.getAmount() / 100.0);
            else
                result.put(newDate, (double) vsedr.getAmount() / 100.0);
        }
        return result;
    }

    public TreeMap<Date, TreeMap<String, Integer>> getDataofCooking(){
        List<EventDataRow> data =  statisticsStorage.getStorage(EventType.ORDER_READY);
        TreeMap<Date, TreeMap<String, Integer>> result = new TreeMap<>();
        for(EventDataRow e: data) {
            OrderReadyEventDataRow oredr = (OrderReadyEventDataRow) e;
            long tempMilis = oredr.getDate().getTime() / 86400000;
            Date newDate = new Date();
            newDate.setTime(tempMilis * 86400000 + 1);

            if (result.containsKey(newDate)){
                if(result.get(newDate).containsKey(oredr.getCookName()))
                    result.get(newDate).put(oredr.getCookName(), result.get(newDate).get(oredr.getCookName()) + oredr.getTime());
                else
                    result.get(newDate).put(oredr.getCookName(),oredr.getTime());
            }
            else {
                result.put(newDate, new TreeMap<>());
                result.get(newDate).put(oredr.getCookName(),oredr.getTime());
            }
        }
        return result;
    }

    private class StatisticsStorage{
        private Map<EventType, List<EventDataRow>> storage = new HashMap<>();

        public StatisticsStorage() {
            this.storage.put(EventType.NO_VIDEOS_AVAILABLE, new ArrayList<EventDataRow>());
            this.storage.put(EventType.VIDEOS_SELECTED, new ArrayList<EventDataRow>());
            this.storage.put(EventType.ORDER_READY, new ArrayList<EventDataRow>());
        }

        private void put(EventDataRow data){
            List<EventDataRow> list = storage.get(data.getType());
            list.add(data);
            storage.put(data.getType(),list);
        }

        public  List<EventDataRow> getStorage(EventType eventType) {
            return storage.get(eventType);
        }
    }
}
