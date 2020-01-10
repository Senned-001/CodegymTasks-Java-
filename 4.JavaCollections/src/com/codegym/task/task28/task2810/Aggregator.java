package com.codegym.task.task28.task2810;

import com.codegym.task.task28.task2810.model.LinkedinStrategy;
import com.codegym.task.task28.task2810.model.Model;
import com.codegym.task.task28.task2810.model.Provider;
import com.codegym.task.task28.task2810.view.HtmlView;
import com.codegym.task.task28.task2810.view.View;

public class Aggregator {

    public static void main(String[] args) {

        Provider provider = new Provider(new LinkedinStrategy());
        HtmlView view = new HtmlView();
        //System.out.println("./4.JavaCollections/src/"+view.getClass().getPackage().getName().replace('.', '/')+"/jobPostings.html");
        Model model=new Model(view,provider);
        Controller controller = new Controller(model);
        view.setController(controller);
        view.emulateCitySelection();
    }
}