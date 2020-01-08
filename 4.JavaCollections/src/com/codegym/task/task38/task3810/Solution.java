package com.codegym.task.task38.task3810;

/* 
Implement annotations

*/

@Changelog({
        @Revision(
                revision = 4089,
                date = @Date(year = 2011, month = 5, day = 30, hour = 18, minute = 35, second = 18),
                comment = "New file updated"),
        @Revision(
                revision = 6018,
                date = @Date(year = 2013, month = 1, day = 1, hour = 0, minute = 0, second = 1),
                authors = {@Author(value = "Sergey", position = Position.MIDDLE)},
                comment = "Bug fixes"),
        @Revision(
                revision = 10135,
                date = @Date(year = 2014, month = 12, day = 31, hour = 23, minute = 59, second = 59),
                authors = {@Author(value = "Diana", position = Position.OTHER),
                        @Author("Ben"),
                        @Author(value = "Victor", position = Position.SENIOR)})
})
public class Solution {
    public static void main(String[] args) {
        System.out.println(Solution.class.getAnnotation(Changelog.class).toString());
    }
}