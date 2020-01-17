package com.codegym.task.task26.task2613;

import java.util.HashMap;
import java.util.Map;

public class CurrencyManipulator {
    private String currencyCode;
    private Map<Integer, Integer> denominations = new HashMap<>();

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void addAmount(int denomination, int count){

        try {
            if (denominations.containsKey(denomination))
                denominations.put(denomination, count + denominations.get(denomination));
            else denominations.put(denomination, count);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getTotalAmount(){
        int total=0;
        for(Map.Entry<Integer,Integer> m:denominations.entrySet()){
            total+=m.getKey()*m.getValue();
        }
        return total;
    }

    public boolean hasMoney(){
        return denominations.size()>0;
    }
}
