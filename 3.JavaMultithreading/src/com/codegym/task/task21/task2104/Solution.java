package com.codegym.task.task21.task2104;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* 
Equals and HashCode

*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }
/*      //validator not eat, idkw
    @Override
    public boolean equals(Object n) {
        //System.out.println("Equals is called: ");
        if(this==n) return true;
        if(n==null) return false;
        if(!(n instanceof Solution)) return false;
        if(n.getClass()!=this.getClass()) return false;
        Solution s = (Solution) n;
        if((s.first.equals(this.first)||(s.first==null&&this.first==null))&&(s.last.equals(this.last)||(s.last==null&&this.last==null))) return true;
        else return false;

    }

    @Override
    public int hashCode() {
        //System.out.println("HashCode called: "+31 * first.hashCode() + last.hashCode());
        return 31 * first.hashCode() + last.hashCode();
    }
*/
//alt+inset +!(n instanceof Solution)
@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()||!(o instanceof Solution)) return false;

    Solution solution = (Solution) o;
    return Objects.equals(first, solution.first) &&
            Objects.equals(last, solution.last);
}

    @Override
    public int hashCode() {
        return Objects.hash(first, last);
    }
    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));


    }
}
