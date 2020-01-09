package com.codegym.task.task28.task2810;

import com.codegym.task.task28.task2810.model.Provider;
import com.codegym.task.task28.task2810.vo.JobPosting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {

    private Provider[] providers;

    public Controller(Provider...providers) {
        if(providers.length==0) throw new IllegalArgumentException();
        this.providers = providers;
    }

    @Override
    public String toString() {
        return "Controller{" +
                "providers=" + Arrays.toString(providers) +
                '}';
    }

    public void scan() {
        List<JobPosting> jobPostingList=new ArrayList<>();
        if(providers.length>0) {
            try {
                for (Provider p : providers) {
                    jobPostingList.addAll(p.getJavaJobPostings("San Francisco"));
                }
            } catch (NullPointerException e) {
                
            }
        }
        System.out.println(jobPostingList.size());
    }
}
