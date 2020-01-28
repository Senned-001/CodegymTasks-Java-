package com.codegym.task.task14.task1417;

import java.util.ArrayList;
import java.util.List;

/* 
Currencies

*/

public class Solution {
    public static void main(String[] args) {
        Person paul = new Person("Paul");
        for (Money money : paul.getAllMoney()) {
            System.out.println(paul.name + " has a stash of " + money.getAmount() + " " + money.getCurrencyName());
        }
    }

    static class Person {
        public String name;
        private List<Money> allMoney;

        Person(String name) {
            this.name = name;
            this.allMoney = new ArrayList<Money>();
            //write your code here
            this.allMoney.add(new USD(54.2));
            this.allMoney.add(new Ruble(50.2));
            this.allMoney.add(new Euro(24.2));
        }
        public List<Money> getAllMoney() {
            return allMoney;
        }
    }
}
