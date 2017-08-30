package facebook;

import java.util.Scanner;

/**
 * Created by z001ktb on 6/23/17.
 */
public class Sqrt {

    public static int mySqrt(int x) {
        if(x == 0 || x == 1) return x;
        return (int) bs(1,x/2,x);
    }

    private static long bs(long start, long end, int target) {
        start--;
        end++;
        while(end - start > 1) {
            long mid = (end - start)/2 + start;
            if(mid*mid <= target && (mid+1)*(mid+1) > target) {
                return mid;
            }else if(mid*mid > target) {
                end = mid;
            }else {
                start = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        while(true) {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            System.out.println(mySqrt(N));
        }
    }
}
