package hackerrank;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by z001ktb on 5/31/16.
 */
public class ExtraLongFactorial {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        BigInteger factorial = BigInteger.valueOf(n);
        while(n > 1) {
            --n;
            factorial = factorial.multiply(BigInteger.valueOf(n));
        }
        System.out.println(factorial.abs().toString());
    }
}
