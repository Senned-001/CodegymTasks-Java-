package com.codegym.task.task25.task2506;

public class LoggingStateThread extends Thread {
    private Thread target;

    public LoggingStateThread(Thread target) {
        this.target = target;
    }

    @Override
    public void run() {

        State s=target.getState();
        System.out.println(s);
        while(true){
            if(!s.equals(target.getState())){
                s=target.getState();
                System.out.println(s);
            }
            if(s==State.TERMINATED){
            break;}
        }
    }
}
