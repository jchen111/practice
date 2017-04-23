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
        int[][] sum = new int[num2.length()][n];

        int carry = 0;

        for(int j = num2.length() - 1; j >= 0; j--){
            int p2 = Character.getNumericValue(num2.charAt(j));
            int index = n - (num2.length() - j);
            for(int i = num1.length() - 1; i >= 0; i--){
                int p1 = Character.getNumericValue(num1.charAt(i));
                sum[num2.length() - 1 - j][index--] = ((p2 * p1) + carry) % 10;
                carry = ((p2 * p1) + carry) / 10;
            }
            if(carry != 0) sum[num2.length() - 1 - j][index--] = carry;
            carry = 0;
        }

        for(int j = sum[0].length - 1; j >= 0; j--) {
            int sub = 0;
            for (int i = 0; i < sum.length; i++) {
                sub += sum[i][j];
            }
            sb.insert(0, (sub + carry) % 10);
            if(sub + carry <= 9) carry = 0;
            else carry = 1;
        }

        if(carry != 0) sb.insert(0, carry);

        while(sb.charAt(0) == '0') {
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
