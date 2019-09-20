package com.codegym.task.task14.task1408;

class  NorthAmericanHen extends Hen {

    @Override
    public int getMonthlyEggCount(){
    return 1;
    }

    @Override
    public  String getDescription() {
        return super.getDescription() + " I come from North America. I lay " +this.getMonthlyEggCount()+" eggs a month.";
    }
}