package com.codegym.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;

/* 
Reinforce the adapter

*/

public class Solution {
    public static Map<String,String> countries = new HashMap<>();
    static {
        countries.put("UA", "Ukraine");
        countries.put("US", "United States");
        countries.put("FR", "France");
    }
    public static void main(String[] args) {
    }

    public static class DataAdapter implements RowItem{
        private Customer customer;
        private Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.contact=contact;
            this.customer=customer;
        }

        @Override
        public String getCountryCode() {
            String cname=null;
            for(HashMap.Entry<String, String> x : countries.entrySet()){
                if(x.getValue().equals(customer.getCountryName()))
                    cname=x.getKey();
            }
            return cname;
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            return contact.getName().split(" ")[1];
        }

        @Override
        public String getContactLastName() {
            return contact.getName().split(",")[0];
        }

        @Override
        public String getDialString() {
            String numb="";
            for(int i=0;i<contact.getPhoneNumber().length();i++){
                if(contact.getPhoneNumber().toCharArray()[i]!='+'&&
                        contact.getPhoneNumber().toCharArray()[i]!='('&&
                        contact.getPhoneNumber().toCharArray()[i]!=')'&&
                        contact.getPhoneNumber().toCharArray()[i]!='-')
                    numb=numb+contact.getPhoneNumber().toCharArray()[i];
            }
            return "callto://+"+numb;
        }
    }

    public static interface RowItem {
        String getCountryCode();        // For example: US
        String getCompany();            // For example: CodeGym Ltd.
        String getContactFirstName();   // For example: John
        String getContactLastName();    // For example: Peterson
        String getDialString();         // For example: callto://+11112223333
    }

    public static interface Customer {
        String getCompanyName();        // For example: CodeGym Ltd.
        String getCountryName();        // For example: United States
    }

    public static interface Contact {
        String getName();               // For example: Peterson, John
        String getPhoneNumber();        // For example: +1(111)222-3333, +3(805)0123-4567, +380(50)123-4567, etc.
    }
}