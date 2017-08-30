package leetcode;

import java.util.ArrayList;
import java.util.List;

public class FourSumII {
    private static int count;
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        count = 0;
        List<int[]> lists = new ArrayList<int[]>();
        lists.add(A);
        lists.add(B);
        lists.add(C);
        lists.add(D);
        backtrack(lists, new ArrayList<Integer>(), 0, 0, A.length);
        return count;
    }

    private static void backtrack(List<int[]> lists, List<Integer> combination, int index, int checkSum, int n) {
        if(index >= 4) {
            return;
        }
        if(combination.size() == n && checkSum == 0) {
            count++;
            return;
        }

        int[] cur = lists.get(index);
        for(int i = 0; i < cur.length; i++) {
            combination.add(cur[i]);
            backtrack(lists, combination, index + 1, checkSum + cur[i], n);
            combination.remove(combination.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] A = {};
        int[] B = {};
        int[] C = {};
        int[] D = {};
        System.out.println(fourSumCount(A,B,C,D));
    }
}
