package com.codegym.task.task17.task1714;

/* 
Comparable

*/

public class Beach implements Comparable<Beach>{
    private String name;
    private float distance;
    private int quality;

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    @Override
    public synchronized int compareTo(Beach o) {
        if(this == o) return 0;
        else  {
            int i = Integer.compare(this.quality, o.quality);
            int f = Float.compare(this.distance, o.distance);
            int r = i + -f;
            return r;
        }
    }



    public static void main(String[] args) {

    }
}
