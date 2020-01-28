package com.codegym.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Reinforce the singleton pattern

*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(thePlanet);
    }

    public static Planet thePlanet;

    // Add static block here
    static {
        readKeyFromConsoleAndInitPlanet();
    }
    public static void readKeyFromConsoleAndInitPlanet() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = null;
        try {
            name1 = reader.readLine();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(name1.equals(Planet.EARTH)) thePlanet=Earth.getInstance();
        else if(name1.equals(Planet.MOON)) thePlanet=Moon.getInstance();
        else if(name1.equals(Planet.SUN)) thePlanet=Sun.getInstance();
        else thePlanet=null;
    }
}
