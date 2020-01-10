package com.codegym.task.task28.task2810.model;

import com.codegym.task.task28.task2810.view.HtmlView;
import com.codegym.task.task28.task2810.view.View;
import com.codegym.task.task28.task2810.vo.JobPosting;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private View view;
    private Provider[] providers;

    public Model(View view, Provider...providers) {
        if(providers==null||view==null||providers.length==0) throw new IllegalArgumentException();
        this.view = view;
        this.providers = providers;
    }

    public void selectCity(String city){
        List<JobPosting> jobPostingList=new ArrayList<>();
        if(providers.length>0) {
            try {
                for (Provider p : providers) {
                    jobPostingList.addAll(p.getJavaJobPostings(city));
                }
            } catch (NullPointerException e) {

            }
        }
        view.update(jobPostingList);
    }
}
