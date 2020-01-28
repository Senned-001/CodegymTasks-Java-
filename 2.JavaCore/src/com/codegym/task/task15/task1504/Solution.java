package com.codegym.task.task15.task1504;

import java.util.LinkedList;
import java.util.List;

/* 
OOP: Books

*/

public class Solution {
    public static void main(String[] args) {
        List<Book> books = new LinkedList<Book>();
        books.add(new MarkTwainBook("Tom Sawyer"));
        books.add(new AgathaChristieBook("Hercule Poirot"));
        System.out.println(books);
    }

    abstract static class Book {
        private String author;

        public Book(String author) {
            this.author = author;
        }

        public abstract Book getBook();

        public abstract String getTitle();

        private String getOutputByBookType() {
            String agathaChristieOutput = author + ": " + getBook().getTitle() + " is a detective";
            String markTwainOutput = getBook().getTitle() + " was written by " + author;
            String output = "output";
            if(getBook() instanceof MarkTwainBook) output=markTwainOutput;
            if(getBook() instanceof AgathaChristieBook) output = agathaChristieOutput;
            return output;
        }

        @Override
        public String toString() {
            return getOutputByBookType();
        }
    }

    public static class MarkTwainBook extends Book{
        String title;

        @Override
        public MarkTwainBook getBook(){
            return this;
        }

        @Override
        public String getTitle(){
            return this.title;
        }

        public MarkTwainBook(String title){
        super("Mark Twain");
        this.title = title;
        }
    }
    public static class AgathaChristieBook extends Book{
        String title;

        @Override
        public AgathaChristieBook getBook(){
            return this;
        }

        @Override
        public String getTitle(){
            return this.title;
        }

        public AgathaChristieBook(String title){
            super("Agatha Christie");
            this.title = title;
        }
    }
}
