package com.codegym.task.task29.task2910;

import java.math.BigDecimal;
import java.util.concurrent.ThreadLocalRandom;

import static com.codegym.task.task29.task2910.Constants.*;

public class Athlete {

    private BigDecimal chanceToHit;
    private BigDecimal averageSpeed;
    private BigDecimal resultTime = new BigDecimal("0.");
    private int number;
    private int missCount = 0;

    public Athlete(int number) {
        this.number = number;
        chanceToHit = BigDecimal.valueOf(ThreadLocalRandom.current().nextDouble(MIN_CHANCE_TO_HIT_TARGET.doubleValue(), MAX_CHANCE_TO_HIT_TARGET.doubleValue()));
    }

    public void calculateTotalTime() {
        resultTime = resultTime.add(BigDecimal.valueOf(missCount * TIME_PENALTY_PER_MISS));
        resultTime = resultTime.add(calculateRaceTime());
    }

    private BigDecimal calculateRaceTime() {
        return new BigDecimal(RACE_LENGTH / averageSpeed.doubleValue() * 3600).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public void calculateNumberOfMisses() {
        for (int i = 0; i < NUMBER_OF_SHOOTING_LANES * 5; i++) {
            double temp = Math.random();
            if (temp < (1 - chanceToHit.doubleValue())) {
                missCount++;
            }
        }
    }

    public void setAverageSpeed(BigDecimal averageSpeed) {
        this.averageSpeed = averageSpeed.setScale(4, BigDecimal.ROUND_HALF_UP);
    }

    public BigDecimal getResultTime() {
        return resultTime;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getMissCount() {
        return missCount;
    }

    public void setMissCount(int missCount) {
        this.missCount = missCount;
    }

    public void setChanceToHit(BigDecimal chanceToHit) {
        this.chanceToHit = chanceToHit;
    }

    public void setResultTime(BigDecimal resultTime) {
        this.resultTime = resultTime;
    }

    public void printResultInfo() {
        System.out.printf("Athlete No. %02d: Time: %6.2f s. Average speed: %2.4f mph. Number of misses: %d\n", number, resultTime.doubleValue(), averageSpeed, missCount);
    }
}