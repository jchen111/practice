package hackerrank;

import java.util.Scanner;

/**
 * Created by z001ktb on 5/14/16.
 */
public class findDigits {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int counter = 0;
            StringBuilder sb = new StringBuilder();
            sb.append(n);
            String digits = sb.toString();
            for(int i=0; i<digits.length(); i++) {
                int digit = Character.getNumericValue(digits.charAt(i));
                if(digit != 0)
                    counter = n % digit == 0? counter+1:counter;
            }
            System.out.println(counter);
        }
    }
}
