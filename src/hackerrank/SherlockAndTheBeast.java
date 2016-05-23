package hackerrank;

import java.util.Scanner;

/**
 * Created by z001ktb on 5/9/16.
 */
public class SherlockAndTheBeast {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            if(largestDecentNumber(n).isEmpty()){
                System.out.println(-1);
            }else {
                System.out.println(largestDecentNumber(n));
            }
        }
    }

    static String largestDecentNumber(int n) {
        int N = n;
        StringBuilder sb = new StringBuilder();
        sb.append("");
        if(n < 3) {
            return sb.toString();
        }
        if(n%3 == 0) {
            for(int i=0; i<n; i++) {
                sb.append(5);
            }
            return sb.toString();
        }else {
            n = N -5;
            while(n>=0) {
                if(n%3 == 0) {
                    int fives = n;
                    int threes = N - n;
                    for(int i=0; i< fives; i++) {
                        sb.append(5);
                    }
                    for(int j=0; j<threes; j++) {
                        sb.append(3);
                    }
                    return sb.toString();
                }
                n = n-5;
            }
            if(n<0){
                return sb.toString();
            }
        }
        return sb.toString();
    }
}
