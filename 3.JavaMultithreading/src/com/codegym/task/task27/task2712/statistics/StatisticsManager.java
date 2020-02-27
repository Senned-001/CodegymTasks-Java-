package com.codegym.task.task27.task2712.statistics;

import com.codegym.task.task27.task2712.kitchen.Cook;
import com.codegym.task.task27.task2712.statistics.event.*;

import java.util.*;

public class StatisticsManager {
    private static StatisticsManager statisticsManager = new StatisticsManager();
    private StatisticsStorage statisticsStorage = new StatisticsStorage();
    private Set cooks = new HashSet();
    private StatisticsManager(){}

    public static StatisticsManager getInstance(){
        return statisticsManager;
    }

    public void record(EventDataRow data){
        statisticsStorage.put(data);
    }

    public void register(Cook cook){
        this.cooks.add(cook);
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
    }
}
