package com.codegym.task.task36.task3601;


public class View {

    public void fireShowDataEvent() {
        Controller controller=new Controller();
        System.out.println(controller.onShowDataList());
    }
}
