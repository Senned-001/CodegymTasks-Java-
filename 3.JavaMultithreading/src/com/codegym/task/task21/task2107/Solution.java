package com.codegym.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* 
Deep cloning of a map

*/
public class Solution implements Cloneable{
    @Override
    
    protected Solution clone() throws CloneNotSupportedException {
        //Solution n = (Solution) super.clone();
        Solution n = new Solution();
        for(Map.Entry<String, User> x : this.users.entrySet()){
            n.users.put(x.getKey(),x.getValue().clone());
        }

        return n;
        
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone =  solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

            System.out.println(solution.equals(clone));
            for(Map.Entry<String, User> x : solution.users.entrySet()){
                System.out.println(x.getKey()+" : "+x.getValue());
            }
            for(Map.Entry<String, User> x : clone.users.entrySet()){
                System.out.println(x.getKey()+" : "+x.getValue());
            }

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    protected Map<String, User> users = new LinkedHashMap();

    public static class User implements Cloneable{
        int age;
        String name;

        @Override
        protected User clone() throws CloneNotSupportedException {
            return (User) super.clone();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof User)) return false;
            User user = (User) o;
            return age == user.age &&
                    Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(age, name);
        }

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }
}
