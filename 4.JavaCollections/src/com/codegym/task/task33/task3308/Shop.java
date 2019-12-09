package com.codegym.task.task33.task3308;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;
@XmlType
@XmlRootElement
public class Shop {
    public Goods goods;
    public int count;
    public double profit;
    public String[] secretData;
    @XmlType
    @XmlRootElement
    static class Goods{
        public List<String> names;
    }
}
