package com.codegym.task.task36.task3608.model;

import com.codegym.task.task36.task3608.bean.User;
import com.codegym.task.task36.task3608.model.service.UserService;
import com.codegym.task.task36.task3608.model.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class MainModel implements Model {
    private DataModel dataModel=new DataModel();
    private UserService userService = new UserServiceImpl();

    @Override
    public DataModel getDataModel() {
        return this.dataModel;
    }

    @Override
    public void loadUsers() {
        dataModel.setUsers(getAllUsers());
        dataModel.setDisplayDeletedUserList(false);
    }
    public void loadDeletedUsers() {
        List users = userService.getAllDeletedUsers();
        dataModel.setUsers(users);
        dataModel.setDisplayDeletedUserList(true);
    }
    @Override
    public void loadUserById(long userId) {
        User user = userService.getUsersById(userId);
        dataModel.setActiveUser(user);

    }

    public void deleteUserById(long id){
        userService.deleteUser(id);
        dataModel.setUsers(getAllUsers());

    }

    private List<User>  getAllUsers(){
        dataModel.setUsers(userService.getUsersBetweenLevels(1,100));
        return userService.filterOnlyActiveUsers(dataModel.getUsers());
    }

    public void changeUserData(String name, long id, int level){
        userService.createOrUpdateUser(name,id,level);
        dataModel.setUsers(getAllUsers());
    }
}
