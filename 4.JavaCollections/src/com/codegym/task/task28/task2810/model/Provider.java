package com.codegym.task.task28.task2810.model;

import com.codegym.task.task28.task2810.vo.JobPosting;

import java.util.ArrayList;
import java.util.List;

public class Provider {
    private Strategy strategy;

    public Provider(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public List<JobPosting> getJavaJobPostings(String searchString){
        if(searchString==null)
            return new ArrayList<JobPosting>();
        return strategy.getJobPostings(searchString);
    }
}
