package com.codegym.task.task24.task2403;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.server.RemoteObject;
import java.util.ArrayDeque;
import java.util.EventListener;

/* 
So, let's... compare

*/
public class Solution {
    public static class A implements Serializable, Cloneable{
        protected A clone() throws CloneNotSupportedException {
            return (A) super.clone();
        }
    }

    public static class B implements Remote, Cloneable {
        protected final B clone() throws CloneNotSupportedException {
            return (B) super.clone();
        }
    }

    public static class C extends ArrayDeque implements Cloneable {
        public C clone() {
            return (C) super.clone();
        }
    }

    public static class D implements EventListener, Cloneable {
        protected D clone() throws CloneNotSupportedException {
            return (D) super.clone();
        }
    }






    public static void main(String[] args) {

    }
}
