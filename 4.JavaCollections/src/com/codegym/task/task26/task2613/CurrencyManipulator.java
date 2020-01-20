package com.codegym.task.task26.task2613;

import com.codegym.task.task26.task2613.exception.InsufficientFundsException;

import java.util.*;

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

    public boolean isAmountAvailable(int expectedAmount){
        return expectedAmount<=getTotalAmount();
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount)throws InsufficientFundsException{
        boolean found = false;
        int totalsum = expectedAmount;
        Map<Integer, Integer> copyOfDenominations = new HashMap<>();
        copyOfDenominations.putAll(denominations);
        Set<Integer> set=copyOfDenominations.keySet();
        Map<Integer, Integer> result=new HashMap<>();
        while(totalsum!=0){
            int nominal = Collections.max(set);
            if(copyOfDenominations.get(nominal)>0) {
                if (nominal <= totalsum) {
                    if(result.containsKey(nominal)){
                        result.replace(nominal,result.get(nominal)+1);
                    }else
                        result.put(nominal,1);
                    totalsum -= nominal;
                    copyOfDenominations.replace(nominal,copyOfDenominations.get(nominal)-1);
                }
                else set.remove(nominal);
            }else {
                set.remove(nominal);
            }
            if(totalsum==0) found = true;
            if(set.size()==0) break;
        }

        if(!found){                         //try make sum with same denomination (100+100+100 etc.)
            copyOfDenominations.clear();
            copyOfDenominations.putAll(denominations);
            set=copyOfDenominations.keySet();
            result=new HashMap<>();
            for(Integer x:set){
                if((expectedAmount%x==0)&&(copyOfDenominations.get(x)>=expectedAmount/x)){
                    copyOfDenominations.replace(x,copyOfDenominations.get(x)-expectedAmount/x);
                    result.put(x,expectedAmount/x);
                    found = true;
                }
            }
        }

        if(!found) throw new InsufficientFundsException();

        this.denominations.clear();
        copyOfDenominations.entrySet().removeIf(e -> e.getValue() == 0);
        this.denominations.putAll(copyOfDenominations);

        /*System.out.println("Check denominations:");
        for(Map.Entry<Integer,Integer> x:denominations.entrySet()){
            System.out.println(x.getKey()+"-"+x.getValue());
        }*/

        return result;
    }
}
