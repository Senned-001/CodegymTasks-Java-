package com.codegym.task.task23.task2306;

/* 
Inner 2

*/
public class Solution {
    private String country;
    private String city;

    public Solution(String country, String city) {
        this.country = country;
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    /* Because of the inner class's private modifier, any calls to the getDescription method from another inner class
        must be wrapped in some public method */
    public String getUserDescription(String name) {
        return getTrickyUser(name).getDescription();
    }

    public SuperUser getTrickyUser(String name) {
        return new SuperUser(name);
    }

    private class SuperUser {
        private String name;

        // This method can only be accessed within the Solution class because of the inner class's private modifier
        public SuperUser(String name) {
            this.name = name;
        }

        // This method can only be accessed within the Solution class because of the inner class's private modifier
        public String getDescription() {
            return String.format("My name is %s. I'm from %s in %s.", this.name, Solution.this.city, Solution.this.country);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution("the United States", "Seattle");
        // Inside the Solution class (and we're currently inside it), the getDescription method can be accessed in two ways
        System.out.println(solution.getTrickyUser("George").getDescription());
        // From any other inner class, it can only be accessed like this:
        System.out.println(solution.getUserDescription("George"));
    }
}
