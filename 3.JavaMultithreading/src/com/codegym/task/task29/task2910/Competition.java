package com.codegym.task.task29.task2910;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static com.codegym.task.task29.task2910.Constants.*;

public class Competition {
    private List<Athlete> athletes;
    Athlete controlAthlete;

    public Competition() {
        initializeControlAthlete();
        athletes = new ArrayList<>();
        for (int i = 0; i < ATHLETE_COUNT; i++) {
            athletes.add(new Athlete(i + 1));
        }
    }

    private void initializeControlAthlete() {
        controlAthlete = new Athlete(0);
        controlAthlete.setAverageSpeed(new BigDecimal(20.));
        controlAthlete.setChanceToHit(MAX_CHANCE_TO_HIT_TARGET);
        controlAthlete.setMissCount(2);
        controlAthlete.setResultTime(new BigDecimal("3640.00"));    //3640.0 and 3640.00 not same things
        System.out.println("CONTROL ATHLETE'S RESULT:");
        controlAthlete.printResultInfo();
    }

    public void start() {
        for (Athlete athlete : athletes) {
            athlete.calculateNumberOfMisses();
            BigDecimal raceTime = controlAthlete.getResultTime().subtract(BigDecimal.valueOf(athlete.getMissCount() * TIME_PENALTY_PER_MISS));
            athlete.setAverageSpeed(new BigDecimal(RACE_LENGTH / (raceTime.doubleValue() / 3600)).setScale(4, BigDecimal.ROUND_HALF_UP));
            athlete.calculateTotalTime();
        }
    }

    public void printAllResults() {
        for (Athlete athlete : athletes) {
            athlete.printResultInfo();
        }
    }

    public void printAthletesWithSameTime() {
        for (Athlete athlete : getAthletesWithSameTime()) {
            athlete.printResultInfo();
        }
    }

    private List<Athlete> getAthletesWithSameTime() {
        List<Athlete> result = new ArrayList<>();
        for (Athlete athlete : athletes) {
            if (athlete.getResultTime().equals(controlAthlete.getResultTime())) {
                result.add(athlete);
            }
        }
        return result;
    }
}