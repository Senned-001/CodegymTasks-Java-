package com.codegym.task.task29.task2909.car;

import java.util.Date;

public abstract class Car {

    double fuel;

    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;

    static public final int MAX_TRUCK_SPEED=80;
    static public final int MAX_SEDAN_SPEED=120;
    static public final int MAX_CABRIOLET_SPEED=90;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    public static Car create(int type, int numberOfPassengers){
        if(type==0) return new Truck(numberOfPassengers);
        if(type==1) return new Sedan(numberOfPassengers);
        if(type==2) return new Cabriolet(numberOfPassengers);
        return null;
    }

    protected Car(int type, int numberOfPassengers) {
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }

    public void fill(double numberOfGallons) throws Exception {
        if (numberOfGallons < 0)
            throw new Exception("Error");
        else fuel += numberOfGallons;
    }

    public double getTripConsumption(Date date, int length, Date summerStart, Date summerEnd) {

        if (!isSummer(date,summerStart,summerEnd)) return getWinterConsumption(length);
        else return getSummerConsumption(length);
    }

    public boolean isSummer(Date date , Date summerStart, Date summerEnd){
        if (date.before(summerEnd) && date.after(summerStart)) return true;
        return false;
    }

    public double getWinterConsumption(int length){
        return length * winterFuelConsumption + winterWarmingUp;
    }

    public double getSummerConsumption(int length){
        return length * summerFuelConsumption;
    }

    public int getNumberOfPassengersThatCanBeCarried() {
        if (canPassengersBeCarried())return numberOfPassengers;
        else return 0;
    }


    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    public void startMoving() {
        fastenDriverBelt();
        if (numberOfPassengers > 0) fastenPassengerBelts();

    }

    public void fastenPassengerBelts() {
    }

    public void fastenDriverBelt() {
    }

    abstract public int getMaxSpeed();

    private boolean canPassengersBeCarried(){
        return isDriverAvailable()&&(fuel>0);
    }
}