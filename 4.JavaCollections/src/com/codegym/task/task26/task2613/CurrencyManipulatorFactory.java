package com.codegym.task.task26.task2613;

import java.util.*;

public class CurrencyManipulatorFactory {
    private static Map<String, CurrencyManipulator> map = new HashMap<>();

    private CurrencyManipulatorFactory() {
    }

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode){
        if(!map.containsKey(currencyCode.toUpperCase()))
            map.put(currencyCode.toUpperCase(),new CurrencyManipulator(currencyCode.toUpperCase()));
        return map.get(currencyCode.toUpperCase());
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators(){
        Set<CurrencyManipulator> allManipulators = new HashSet<>();
        for(Map.Entry<String, CurrencyManipulator> m:map.entrySet()){
            allManipulators.add(m.getValue());
        }
        return allManipulators;
    }
}
