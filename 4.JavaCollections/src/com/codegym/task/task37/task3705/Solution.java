package com.codegym.task.task37.task3705;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/* 
Ambiguous behavior for NULL

*/
public class Solution {
    public static void main(String[] args) {
        Map expectedMap = getExpectedMap();
        System.out.println("****** Check whether the key \"s\" IS NOT in the map");
        checkObject(expectedMap, "s");

        System.out.println("****** Check whether the key \"s\" IS in the map");
        expectedMap.put("s", "vvv");
        checkObject(expectedMap, "s");

        System.out.println("\n****** Ambiguous behavior for NULL");
        expectedMap.put(null, null);
        checkObject(expectedMap, null);

        /*  Expected output for NULL
****** Ambiguous behavior for NULL
map DOES contain a value for key null
map DOES NOT contain a value for key null
         */
    }

    public static Map getExpectedMap() {
        return new HashMap();
    }

    public static void checkObject(Map map, Object key) {
        String s1 = map.containsKey(key) ?
                "map DOES contain a value for key " + key : "map DOES NOT contain a value for key " + key;
        System.out.println(s1);

        // If the value is null, then the map doesn't contain the value
        Object value = map.get(key);
        String s2 = value != null ?
                "map DOES contain a value for key " + key : "map DOES NOT contain a value for key " + key;
        System.out.println(s2);
    }
}
