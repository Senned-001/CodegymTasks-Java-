package com.codegym.task.task24.task2410;

import java.util.LinkedList;
import java.util.List;

/* 
Refactoring, anonymous classes

*/
public class Solution {
    public static List<Iterator> iterators = new LinkedList<>();

    private int itemCount;

    public Iterator getIterator(final String name) {
        itemCount++;
        System.out.println(name + " item " + itemCount);
        /*
        class LocalIterator implements Iterator {
            public LocalIterator() {
                itemCount++;
                System.out.println(name + " item " + itemCount);
            }

            public Iterator next() {
                return new LocalIterator();
            }
        }*/
        return new Iterator(){

            @Override
            public Iterator next() {
                return getIterator(name);
            }
        };
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        Iterator iterator = solution.getIterator("iterator");
        for (int i = 1; i < 5; i++) {
            iterators.add(iterator.next());
        }
    }
}
