package com.codegym.task.task18.task1815;

import java.util.List;

/* 
Table

*/

public class Solution {
    public class TableInterfaceWrapper implements TableInterface {
        private TableInterface obj;
        public TableInterfaceWrapper(TableInterface a){
            obj=a;
        }

        @Override
        public void setModel(List rows) {
            System.out.println(rows.size());
            obj.setModel(rows);
        }

        @Override
        public String getHeaderText() {
            return obj.getHeaderText().toUpperCase();
        }

        @Override
        public void setHeaderText(String newHeaderText) {
            obj.setHeaderText(newHeaderText);
        }
    }

    public interface TableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }

    public static void main(String[] args) {
    }
}