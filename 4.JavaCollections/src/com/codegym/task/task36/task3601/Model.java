package com.codegym.task.task36.task3601;

import java.util.ArrayList;
import java.util.List;

public class Model {
    Service service=new Service();
    public List<String> getStringDataList() {
        return service.getData();
    }
}
