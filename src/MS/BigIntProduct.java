package MS;

import java.util.Scanner;

/**
 * Created by z001ktb on 4/23/17.
 */
public class BigIntProduct {

    public static String bigIntProduct(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        String tmp = num1;

        // make sure num1 is the longer string, num2 is the shorter string
        num1 = num1.length() > num2.length()? num1 : num2;
        num2 = num1.length() > num2.length()? num2 : tmp;

        int n = Math.max(num1.length()*num2.length(), num1.length() + num2.length());
        int[] sum = new int[n];

        int carry = 0;

        for(int j = num2.length() - 1; j >= 0; j--){
            int p2 = Character.getNumericValue(num2.charAt(j));
            int index = n - (num2.length() - j);
            for(int i = num1.length() - 1; i >= 0; i--){
                int p1 = Character.getNumericValue(num1.charAt(i));
                int newcarry = (sum[index] + ((p2 * p1) + carry)) / 10;
                sum[index] = (sum[index] + ((p2 * p1) + carry)) % 10;
                carry = newcarry;
                index--;
            }
            if(carry != 0) sum[index--] = carry;
            carry = 0;
        }

        for(int j = sum.length - 1; j >= 0; j--) {
            sb.insert(0, sum[j]);
        }

        while(sb.charAt(0) == '0' && sb.length() > 1) {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true) {
            String num1 = sc.next();
            String num2 = sc.next();
            System.out.println(bigIntProduct(num1, num2));
        }
    }
}
