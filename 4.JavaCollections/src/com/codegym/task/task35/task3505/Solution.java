package com.codegym.task.task35.task3505;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* 
List to Map

*/
public class Solution {
    public static void main(String[] args) {
        List<ConvertibleUser> users = new ArrayList<>();
        users.add(new ConvertibleUser(234, "First User"));
        users.add(new ConvertibleUser(235, "Second User"));
        users.add(new ConvertibleUser(236, "Third User"));

        Map<Integer, ConvertibleUser> newMap = ConvertibleUtil.convert(users);
        System.out.println(newMap);
        // {236=ConvertibleUser{id=236, name='Third User'},
        // 235=ConvertibleUser{id=235, name='Second User'},
        // 234=ConvertibleUser{id=234, name='First User'}}

        //////////////////////////////////////////////////////////

        List<ConvertibleBook> books = new ArrayList<>();
        books.add(new ConvertibleBook("First Book"));
        books.add(new ConvertibleBook("Second Book"));
        books.add(new ConvertibleBook("Third Book"));

        Map<String, ConvertibleBook> bookMap = ConvertibleUtil.convert(books);
        System.out.println(bookMap);
        // {Third Book=ConvertibleBook{name='Third Book'},
        // First Book=ConvertibleBook{name='First Book'},
        // Second Book=ConvertibleBook{name='Second Book'}}
    }
}