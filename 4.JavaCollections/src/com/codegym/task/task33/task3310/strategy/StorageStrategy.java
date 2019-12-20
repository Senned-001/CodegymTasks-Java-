package com.codegym.task.task33.task3310.strategy;

public interface StorageStrategy {

    boolean containsKey(Long key);          // Returns true if the repository contains the passed key.
    boolean containsValue(String value);    // Returns true if the repository contains the passed value.
    void put(Long key, String value);       // Adds a new key-value pair to the repository.
    Long getKey(String value);              // Returns the key for the passed value.
    String getValue(Long key);              // Return the value for the passed key.
}
