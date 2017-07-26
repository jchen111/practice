package facebook;

import java.util.*;

/**
 * Created by z001ktb on 6/22/17.
 */
public class RemoveInvalidParentheses {
    /**
     * BFS find all possible subset by removing one character a time
     * time T(n) = n x C(n, n) + (n-1) x C(n, n-1) + ... + 1 x C(n, 1) = n x 2^(n-1)
     * space O(2N)
     */
    public static List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<String>();
        if(s.isEmpty()) return result;
        Set<String> visited = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.add(s);
        visited.add(s);

        boolean found = false;

        while(!queue.isEmpty()) {
            s = queue.poll();
            if(isValid(s)) {
                result.add(s);
                found = true;
            }

            if(found) continue;

            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) != ')' && s.charAt(i) != '(') continue;
                String nxt = s.substring(0,i) + s.substring(i + 1);

                if(!visited.contains(nxt)){
                    visited.add(nxt);
                    queue.add(nxt);
                }
            }
        }
        return result;
    }

    private static boolean isValid(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                count++;
            }
            else if(s.charAt(i) == ')') {
                if(count == 0) return false;
                count--;
            }
        }
        return count == 0;
    }

    public static void main(String[] args) {
        String s = "()())()";
        removeInvalidParentheses(s);
    }
}
