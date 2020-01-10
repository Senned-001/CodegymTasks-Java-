package com.codegym.task.task28.task2810;

import com.codegym.task.task28.task2810.model.Model;
import com.codegym.task.task28.task2810.model.Provider;
import com.codegym.task.task28.task2810.vo.JobPosting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Controller {
    private Model model;

    public Controller(Model model) {
        if(model==null) throw new IllegalArgumentException();
        this.model = model;
    }

    public void onCitySelected(String cityName){
        model.selectCity(cityName);
    }
}
