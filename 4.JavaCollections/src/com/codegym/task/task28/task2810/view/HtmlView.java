package com.codegym.task.task28.task2810.view;

import com.codegym.task.task28.task2810.Controller;
import com.codegym.task.task28.task2810.vo.JobPosting;

import java.util.List;

public class HtmlView implements View{
    private Controller controller;
    private final String filePath="./4.JavaCollections/src/"+this.getClass().getPackage().getName().replace('.', '/')+"/jobPostings.html";

    public void emulateCitySelection(){
        controller.onCitySelected("Odessa");
    }

    @Override
    public void update(List<JobPosting> jobPostings) {
         updateFile(getUpdatedFileContents(jobPostings));
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    private String getUpdatedFileContents(List<JobPosting> jobPostings){
        return null;
    }

    private void updateFile(String name){

    }
}
