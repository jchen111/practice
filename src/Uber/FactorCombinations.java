package Uber;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by z001ktb
 */
public class FactorCombinations {
    public static List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backtracking(res, new ArrayList<Integer>(), n, n, 2);
        return res;
    }

    public static void backtracking(List<List<Integer>> res, List<Integer> solution, int n, int origin, int start) {
        if(n == 1 && !solution.isEmpty()) {
            res.add(new ArrayList<Integer>(solution));
        }
        for(int i = start; i <= n; i++) {
            if(n % i == 0 && i != origin) {
                solution.add(i);
                backtracking(res, solution, n / i, origin, i);
                solution.remove(solution.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        getFactors(9);
    }
}
