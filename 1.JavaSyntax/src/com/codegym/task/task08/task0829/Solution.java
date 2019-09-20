package com.codegym.task.task08.task0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* 
Software update

*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        /*// List of addresses
        List<String> addresses = new ArrayList<>();
        while (true) {
            String family = reader.readLine();
            if (family.isEmpty()) break;

            addresses.add(family);
        }

        // Read the house number
        int houseNumber = Integer.parseInt(reader.readLine());

        if (0 <= houseNumber && houseNumber < addresses.size()) {
            String familyName = addresses.get(houseNumber);
            System.out.println(familyName);
        }*/
        ArrayList<String> fam = new ArrayList<>();
        ArrayList<String> city = new ArrayList<>();

        HashMap<String,String> map = new HashMap<>();

        while (true) {

            String cit=reader.readLine();

            if (cit.isEmpty()) break;
            city.add(cit);
            String family = reader.readLine();
            fam.add(family);
        }


       /* while (true) {
            String cit=reader.readLine();
            if (cit.isEmpty()) break;
            city.add(cit);}*/

        for(int i = 0;i<fam.size();i++){
            map.put(city.get(i),fam.get(i));
        }

        String cityName = reader.readLine();

        for(HashMap.Entry<String, String> x : map.entrySet()){
            if (x.getKey().equals(cityName)) System.out.println(x.getValue());}



      /*  Iterator itr = map.entrySet().iterator();
        while(itr.hasNext()){

            HashMap.Entry pair = (HashMap.Entry)itr.next();
            if (pair.getValue().equals(cityName)) System.out.println(pair.getKey());}*/


    }


}
