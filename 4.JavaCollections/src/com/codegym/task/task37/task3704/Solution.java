package com.codegym.task.task37.task3704;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* 
Bug fix

*/
public class Solution {
    public static void main(String[] args) {
        Map expectedMap = getExpectedMap();

        System.out.println("********* Add obj with key NULL *********");
        expectedMap.put(null, "text 1");
        System.out.println(expectedMap.size());
        System.out.println(expectedMap.get(null));

        System.out.println("*********  Add obj with key 0 *********");
        expectedMap.put(0, "text 2");
        System.out.println(expectedMap.size());
        System.out.println(expectedMap.get(null));
        System.out.println(expectedMap.get(0));

        System.out.println("********* Keys *********");
        for (Object o : expectedMap.keySet()) {
            System.out.println(o);
        }
        System.out.println("********* Values *********");
        for (Object o : expectedMap.values()) {
            System.out.println(o);
        }

        /* Expected output
********* Add obj with key NULL *********
1
text 1
*********  Add obj with key 0 *********
2
text 1
text 2
********* Keys *********
0
null
********* Values *********
text 2
text 1
         */
    }

    public static Map getExpectedMap() {
        return new HashMap();
    }
}
