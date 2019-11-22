package com.codegym.task.task29.task2908;

/* 
Caching

*/
public class Solution {
    public static void main(String[] args) throws InterruptedException {
        //////////////First example///////////////////
        Square square = new Square();
        CacheComputeManager<Integer, Integer> manager = new CacheComputeManager(square);

        for (int i = 0; i < 8; i++) {
            int j = i % 4;
            Integer result = manager.compute(j);
            System.out.format("%d * %d = %d\n", j, j, result);
        }

        /* Output
            0 will be cached  0 * 0 = 0
            1 will be cached  1 * 1 = 1
            2 will be cached  2 * 2 = 4
            3 will be cached  3 * 3 = 9
            0 taken from cache  0 * 0 = 0
            1 taken from cache  1 * 1 = 1
            2 taken from cache  2 * 2 = 4
            3 taken from cache  3 * 3 = 9
         */

        //////////////Second example///////////////////
        Copyright copyright = new Copyright();
        CacheComputeManager manager2 = new CacheComputeManager(copyright);
        System.out.println(manager2.compute(new Copyright.Period(3012, 3147)));
        System.out.println(manager2.compute(new Copyright.Period(3012, 3146)));
        System.out.println(manager2.compute(new Copyright.Period(3012, 3147)));

        /* Output
        Period{firstYear=3012, secondYear=3147} will be cached  All rights reserved (C) 3012-3147
        Period{firstYear=3012, secondYear=3146} will be cached  All rights reserved (C) 3012-3146
        Period{firstYear=3012, secondYear=3147} taken from cache  All rights reserved (C) 3012-3147
         */
    }
}
