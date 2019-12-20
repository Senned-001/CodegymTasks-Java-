package com.codegym.task.task33.task3310;

import com.codegym.task.task33.task3310.strategy.StorageStrategy;

public class Shortener {
    private Long lastId=0L;
    private StorageStrategy storageStrategy;

    public Shortener(StorageStrategy storageStrategy) {
        this.storageStrategy = storageStrategy;
    }

    public synchronized String getString(Long id){
        return storageStrategy.getValue(id);
    }

    public synchronized Long getId(String value){
        if(storageStrategy.containsValue(value)) return storageStrategy.getKey(value);
        else {
            this.lastId++;
            storageStrategy.put(lastId,value);
            return this.lastId;
        }
    }
}
