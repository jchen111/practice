package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by jiaqichen on 10/19/16.
 */
public class FractionToRecurringDecimal {
    public static String fractionToDecimal(int numerator, int denominator) {
        int sign = 1;
        if((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0)) {
            sign = -1;
        }
        long num = Math.abs(numerator);
        long denomim = Math.abs((long)denominator);
        String result = "";
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        result += (num / denomim);
        if(num % denomim == 0) {
            return result;
        }
        result += ".";
        num -= (num / denomim) * denomim;
        if(num < denomim) {
            num *= 10;
        }
        StringBuilder suffix = new StringBuilder();
        while(!map.containsKey(num) ) {
            suffix.append("" + (num / denomim));
            map.put(num, suffix.length() - 1);
            if(num % denomim == 0) {
                return sign == -1 ? "-" + result + suffix : result + suffix;
            }
            num -= (num / denomim) * denomim;
            if(num < denomim) {
                num *= 10;
            }
        }
        suffix.insert(map.get(num),"(");
        suffix.append(")");
        return sign == -1 ? "-" + result + suffix.toString() : result + suffix.toString();

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        System.out.println(fractionToDecimal(n1,n2));
    }
}
