package com.codegym.task.task14.task1408;

public class AfricanHen extends Hen {

    @Override
    public int getMonthlyEggCount(){
        return 4;
    }

    @Override
    public  String getDescription() {
        return super.getDescription() + " I come from Africa. I lay " +this.getMonthlyEggCount()+" eggs a month.";
    }
}