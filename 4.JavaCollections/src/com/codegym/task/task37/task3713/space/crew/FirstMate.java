package com.codegym.task.task37.task3713.space.crew;

public class FirstMate extends AbstractCrewMember {
    public FirstMate (AbstractCrewMember.CompetencyLevel competencyLevel) {
        this.competencyLevel = competencyLevel;
    }

    protected void doJob(String request) {
        System.out.println("The request (" + request + ") will be handled by the first mate. Let's not bother the captain with it.");
    }
}
