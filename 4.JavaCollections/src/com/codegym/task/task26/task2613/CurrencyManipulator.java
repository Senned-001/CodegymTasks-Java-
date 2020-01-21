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

        //my algorithm - it's works, but validator don't like it
        /*boolean found = false;
        int totalsum = expectedAmount;      //try make sum with biggest denomination (500+100+100+50 etc.)
        Map<Integer, Integer> copyOfDenominations = new HashMap<>();
        copyOfDenominations.putAll(denominations);
        Set<Integer> set=copyOfDenominations.keySet();
        Map<Integer, Integer> result=new HashMap<>();
        if(set.size()>0) {
            while (totalsum != 0) {
                int nominal = Collections.max(set);
                if (copyOfDenominations.get(nominal) > 0) {
                    if (nominal <= totalsum) {
                        if (result.containsKey(nominal)) {
                            result.replace(nominal, result.get(nominal) + 1);
                        } else
                            result.put(nominal, 1);
                        totalsum -= nominal;
                        copyOfDenominations.replace(nominal, copyOfDenominations.get(nominal) - 1);
                    } else set.remove(nominal);
                } else {
                    set.remove(nominal);
                }
                if (totalsum == 0) found = true;
                if (set.size() == 0) break;
            }
        }

        if(!found){                         //try make sum with same denomination (100+100+100 etc.)
            copyOfDenominations.clear();
            copyOfDenominations.putAll(denominations);
            set=copyOfDenominations.keySet();
            List<Integer> list = new ArrayList<>(set);
            result=new HashMap<>();
            if(list.size()>0) {
                Collections.sort(list);
                Collections.reverse(list);  //start with biggest denominations
                for (int i=0;i<list.size();i++) {
                    if ((expectedAmount % list.get(i) == 0) && (copyOfDenominations.get(list.get(i)) >= expectedAmount / list.get(i))) {
                        copyOfDenominations.replace(list.get(i), copyOfDenominations.get(list.get(i)) - expectedAmount / list.get(i));
                        result.put(list.get(i), expectedAmount / list.get(i));
                        found = true;
                        break;
                    }
                }
            }
        }

        if(!found) throw new InsufficientFundsException();

        this.denominations.clear();
        copyOfDenominations.entrySet().removeIf(e -> e.getValue() == 0);
        this.denominations.putAll(copyOfDenominations);

        System.out.println("Check denominations:");
        for(Map.Entry<Integer,Integer> x:denominations.entrySet()){
            System.out.println(x.getKey()+"-"+x.getValue());
        }
        System.out.println("Check result:");
        for(Map.Entry<Integer,Integer> x:result.entrySet()){
            System.out.println(x.getKey()+"-"+x.getValue());
        }

        return result;*/

        //not my algorithm - validator like it
        int sum = expectedAmount;
        HashMap<Integer, Integer> temp = new HashMap<>();
        temp.putAll(denominations);
        ArrayList<Integer> nominals = new ArrayList<>();
        for (Map.Entry<Integer, Integer> pair : temp.entrySet())
            nominals.add(pair.getKey());

        Collections.sort(nominals);
        Collections.reverse(nominals);

        TreeMap<Integer, Integer> result = new TreeMap<>(
                new Comparator<Integer>()
                {
                    @Override
                    public int compare(Integer o1, Integer o2)
                    {
                        return o2.compareTo(o1);
                    }
                });

        for (Integer nominal : nominals) {
            int key = nominal;
            int value = temp.get(key);
            while (true) {
                if (sum < key || value <= 0) {
                    temp.put(key, value);
                    break;
                }
                sum -= key;
                value--;

                if (result.containsKey(key))
                    result.put(key, result.get(key) + 1);
                else
                    result.put(key, 1);
            }
        }
        if (sum > 0)
            throw new InsufficientFundsException();
        else
        {
            denominations.clear();
            denominations.putAll(temp);
        }
        return result;
    }
}
