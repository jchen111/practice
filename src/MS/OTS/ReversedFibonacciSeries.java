package MS.OTS;

import java.util.ArrayList;
import java.util.List;

public class ReversedFibonacciSeries {
    public static List<Integer> reverseFib(int num1, int num2) {
        List<Integer> solution = new ArrayList<>();
        solution.add(num1);
        solution.add(num2);
        int num3 = num1 - num2;
        while(num3 > 0) {
            solution.add(num3);
            num1 = num2;
            num2 = num3;
            num3 = num1 - num2;
        }
        solution.add(num3);
        return solution;
    }

    public static void main(String[] args) {
        List<Integer> res = reverseFib(80,50);
        System.out.println(res);
    }
}
