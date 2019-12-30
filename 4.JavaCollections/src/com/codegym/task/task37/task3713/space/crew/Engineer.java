package com.codegym.task.task37.task3713.space.crew;

public class Engineer extends AbstractCrewMember {
    public Engineer (AbstractCrewMember.CompetencyLevel competencyLevel) {
        this.competencyLevel = competencyLevel;
    }

    protected void doJob(String request) {
        System.out.println(request + " is a common engineering task. Get to work!");
    }
}
