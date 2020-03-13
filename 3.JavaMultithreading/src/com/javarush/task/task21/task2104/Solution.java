package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/* 
Equals and HashCodeTT
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Solution)) return false;
        if (obj == this) {
        return true;
    }
        Solution n = (Solution) obj;
        if (obj.getClass() != this.getClass()) return false;
        if (n.first == null || n.last == null) return false;
     
        return (first.equals(n.first)) && (last.equals(n.last));
    }

    public int hashCode() {
       int result = 17;
       result = 37 * result + (first == null ? 0 : first.hashCode());
       result = 37 * result + (last == null ? 0 : last.hashCode());
        assert first != null;
        assert last != null;
        return 31 * first.hashCode() + last.hashCode();
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}
