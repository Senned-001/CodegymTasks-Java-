package com.codegym.task.task37.task3713.space.crew;

public class CabinBoy extends AbstractCrewMember {
    public CabinBoy (AbstractCrewMember.CompetencyLevel competencyLevel) {
        this.competencyLevel = competencyLevel;
    }

    protected void doJob(String request) {
        System.out.println("Even the cabin boy can handle this request: " + request);
    }
}
