package AirBnB.phone;

import java.util.*;

/**
 * Created by z001ktb
 */
public class PyramidTransition {

    /**
     * 给你一个字符对的转换matrix，表示这个字符对会转化成一个字符，但是有的字符对可能有多个能够转化成的字符。
     * 再给你一个rule，代表若干合法的结果
     * 多次询问，每次一个字符串如果有一个方法能够走到合法状态就算是YES，否则NO
     * http://www.1point3acres.com/bbs/thread-146537-1-1.html
     *
     *   A   B   C  D
     * A AC  CD  D  B
     * B B   C   A  CD
     * C A   C   D  B
     * D BC  D   A  C
     *
     * Assum input to be:
     * A,A,AC
     * A,B,CD
     * A,C,D
     * ...
     *
     * 多次call check
     */

    private static Set<Character> ruleSet;
    private static Map<Character, Map<Character,Set<Character>>> transitionDict;
    private static Map<String, Boolean> cache; //memorization
    public static void setupPyramid(String[] lines, String rule) {
        ruleSet = new HashSet<>();
        for(int i = 0; i < rule.length(); i++) {
            ruleSet.add(rule.charAt(i));
        }

        transitionDict = new HashMap<>();

        for(String line : lines) {
            String[] parts = line.split(",");
            char left = parts[0].charAt(0);
            char right = parts[1].charAt(0);

            if(!transitionDict.containsKey(left)) transitionDict.put(left, new HashMap<>());

            transitionDict.get(left).put(right, new HashSet<>());

            for(int i = 0; i < parts[2].length(); i++) {
                transitionDict.get(left).get(right).add(parts[2].charAt(i));
            }
        }

        cache = new HashMap<>();
    }

    public static boolean check(String input) {
        if(cache.containsKey(input)) { // if cached, return result
            return cache.get(input);
        }

        if(input.length() == 1) { // reaches the top of the pyramid
            cache.put(input, ruleSet.contains(input.charAt(0)));
            return cache.get(input);
        }

        List<String> nextChecks = new ArrayList<String>();

        generateNextChecks(nextChecks, input, 0, new StringBuilder()); // get possible next levels

        for(String nextCheck : nextChecks) {
            if(check(nextCheck)) { // recursively check next level
                cache.put(nextCheck, true);
                return true;
            } else {
                cache.put(nextCheck, false);
            }
        }
        cache.put(input, false);
        return false;
    }

    private static void generateNextChecks(List<String> nextChecks, String input, int start, StringBuilder nextCheck) {
        if(start == input.length() - 1) {
            nextChecks.add(nextCheck.toString());
            return;
        }

        char left = input.charAt(start);
        char right = input.charAt(start + 1);

        for(char c : transitionDict.get(left).get(right)) {
            nextCheck.append(c);
            generateNextChecks(nextChecks, input, start + 1, nextCheck);
            nextCheck.setLength(nextCheck.length() - 1);
        }
    }

    public static void main(String[] args) {

            String[] lines = {
                    "A,A,AC", "A,B,CD", "A,C,D", "A,D,B",
                    "B,A,B", "B,B,C", "B,C,A", "B,D,CD",
                    "C,A,A", "C,B,C", "C,C,D", "C,D,B",
                    "D,A,BC", "D,B,D", "D,C,A", "D,D,C"
            };
            setupPyramid(lines, "CD");
            System.out.println(check("ABCD"));
            System.out.println(check("AACC"));
            System.out.println(check("AAAA"));
        }

}
