package com.codegym.task.task27.task2707;

/* 
Determining locking order

*/
public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        synchronized (obj1) {
            synchronized (obj2) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    public static boolean isLockOrderNormal(final Solution solution, final Object o1, final Object o2) throws Exception {
        //do something here
        synchronized (o1){
            Thread T1=new Thread(){
                @Override
                public void run() {
                    //solution.someMethodWithSynchronizedBlocks(o1,o2);
                    solution.someMethodWithSynchronizedBlocks(o2,o1);
                }
            };
            T1.start();
            Thread T2=new Thread(){
                @Override
                public void run() {
                    synchronized (o2){
                        try {
                            sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            };
            T2.start();
            Thread.sleep(100);
            if(T2.getState()== Thread.State.BLOCKED) return true;
            else return false;
        }

    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isLockOrderNormal(solution, o1, o2));
    }
}
