package com.codegym.task.task26.task2609;

import java.util.concurrent.ConcurrentHashMap;

/*
Distributing items into baskets with their own lock

*/
public class Solution {
    private static final int LOCK_COUNT = 12;
    private final Node[] buckets;
    private final Object[] locks;

    static class Node {
        public Node next;
        public Object key;
        public Object value;
    }

    public Solution(int bucketCount) {
        buckets = new Node[bucketCount];
        locks = new Object[LOCK_COUNT];
        for (int i = 0; i < LOCK_COUNT; i++) {
            locks[i] = new Object();
        }
    }
    private final int hash(Object key) {
        return Math.abs(key.hashCode() % buckets.length);
    }

    public Object get(Object key) {
        int hash = hash(key);
        synchronized (locks[hash % LOCK_COUNT]) {   //???
            for (Node m = buckets[hash]; m != null; m = m.next) {
                if (m.key.equals(key)) return m.value;
            }
        }
        return null;
    }

    public void clear() {
        for (int i = 0; i < buckets.length; i++) {
            synchronized (locks[i % LOCK_COUNT]) {  //???
                buckets[i] = null;
            }
        }
    }

    public static void main(String[] args) {
    }
}