package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by jiaqichen on 10/19/16.
 */
public class FractionToRecurringDecimal {
    public static String fractionToDecimal(int numerator, int denominator) {
        HashMap<Long,Integer> map = new HashMap<Long,Integer>();
        if(numerator == denominator){
            return "1";
        }
        if(numerator == 0) return "0";
        StringBuilder sb = new StringBuilder();
        if((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
            sb.append("-");
        }
        long lnumerator = numerator;
        long ldenominator = denominator;
        if(numerator < 0) lnumerator = Long.valueOf(-1)*Long.valueOf(numerator);
        if(denominator < 0) ldenominator = Long.valueOf(-1)*Long.valueOf(denominator);

        if(lnumerator % ldenominator == 0){
            sb.append(lnumerator/ldenominator);
        }else{
            boolean flag = false;
            while(lnumerator != 0){
                if(map.containsKey(lnumerator)){
                    sb.insert(map.get(lnumerator), "(");
                    sb.append(")");
                    break;
                }else {
                    map.put(lnumerator,sb.length());
                    sb.append(lnumerator / ldenominator);
                }
                if(!flag) {
                    sb.append(".");
                    flag = true;
                }
                lnumerator = 10 * (lnumerator - ldenominator*(lnumerator/ldenominator));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        System.out.println(fractionToDecimal(n1,n2));
    }
}
