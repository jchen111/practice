package leetcode;

import java.util.Scanner;

/**
 * Created by jacky on 9/16/16.
 */
public class DivideTwoInteger {

    public static int divide(int dividend, int divisor) {
        int sign = 1;
        if((dividend > 0 && divisor < 0 )|| (dividend < 0 && divisor > 0) ){
            sign = -1;
        }

        long longDividend = Math.abs((long)dividend);
        long longDivisor = Math.abs((long)divisor);

        long result = longDivide(longDividend,longDivisor);
        if(result > Integer.MAX_VALUE){
            if(sign == 1)
                return Integer.MAX_VALUE;
            else
                return Integer.MIN_VALUE;
        }else{
            if(sign == -1){
                result *= sign;
            }
        }

        return (int) result;
    }

    public static long longDivide(long dividend, long divisor){
        if(divisor > dividend){
            return 0;
        }

        long sum = divisor;
        long result = 1;
        while((sum+sum) < dividend){
            sum += sum;
            result += result;
        }

        return result + longDivide(dividend-sum,divisor);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int dividend = sc.nextInt();
        int divisor = sc.nextInt();

        System.out.println(divide(dividend,divisor));


        System.out.println(" 1 / 2 = "+ divide(1,2) + " should be 0");
        System.out.println(" 2 / 1 = "+ divide(2,1) + " should be 2");
        System.out.println(" 5 / 2 = "+ divide(5,2) + " should be 2");
        System.out.println(" 6 / 2 = "+ divide(6,2) + " should be 3");

        System.out.println(" -1 / -2 = "+ divide(-1,-2) + " should be 0");
        System.out.println(" -2 / -1 = "+ divide(-2,-1) + " should be 2");
        System.out.println(" -5 / -2 = "+ divide(-5,-2) + " should be 2");
        System.out.println(" -6 / -2 = "+ divide(-6,-2) + " should be 3");

        System.out.println(" -1 / 2 = "+ divide(-1,2) + " should be 0");
        System.out.println(" 1 / -2 = "+ divide(1,-2) + " should be 0");

        System.out.println(" -2 / 1 = "+ divide(-2,1) + " should be -2");
        System.out.println(" 2 / -1 = "+ divide(2,-1) + " should be -2");

        System.out.println(" 5 / -2 = "+ divide(5,-2) + " should be -2");
        System.out.println(" -5 / 2 = "+ divide(-5,2) + " should be -2");

        System.out.println(" 6 / -2 = "+ divide(6,-2) + " should be -3");
        System.out.println("-6 / 2 = "+ divide(-6,2) + " should be -3");
    }
}
