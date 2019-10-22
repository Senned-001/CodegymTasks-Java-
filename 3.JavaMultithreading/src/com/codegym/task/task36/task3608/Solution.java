package com.codegym.task.task36.task3608;

import com.codegym.task.task36.task3608.controller.Controller;
import com.codegym.task.task36.task3608.model.FakeModel;
import com.codegym.task.task36.task3608.model.MainModel;
import com.codegym.task.task36.task3608.model.Model;
import com.codegym.task.task36.task3608.view.EditUserView;
import com.codegym.task.task36.task3608.view.UsersView;

public class Solution {
    public static void main(String[] args) {
        Model model = new MainModel();
        UsersView usersView = new UsersView();
        EditUserView editUserView=new EditUserView();
        Controller controller = new Controller();

        usersView.setController(controller);
        editUserView.setController(controller);
        controller.setModel(model);
        controller.setUsersView(usersView);
        controller.setEditUserView(editUserView);

        usersView.fireShowAllUsersEvent();
        usersView.fireOpenUserEditFormEvent(126L);
        editUserView.fireUserDeletedEvent(124L);
        editUserView.fireUserDataChangedEvent("Pete",126L,15);
        usersView.fireShowDeletedUsersEvent();
    }
}