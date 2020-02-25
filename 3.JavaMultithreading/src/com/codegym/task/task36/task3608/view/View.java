package com.codegym.task.task36.task3608.view;
import com.codegym.task.task36.task3608.controller.Controller;
import com.codegym.task.task36.task3608.model.DataModel;

public interface View {

    void refresh(DataModel dataModel);

    void setController(Controller controller);
}
