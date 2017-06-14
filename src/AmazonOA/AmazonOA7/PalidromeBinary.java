package AmazonOA.AmazonOA7;

import java.util.Scanner;

/**
 * Created by z001ktb on 5/19/17.
 */
public class PalidromeBinary {


    public static int getleftmost(Integer x){
        int count = 0;
        while(x != 0){
            count++;
            x >>= 1;
        }
        return count > 0 ? count - 1 : 0;
    }

    public static int ispalin(Integer x){
        int p = getleftmost(x);
        int i = 1 << p;
        int j = 1;
        while(i > j){
            if( ((x & i) > 0) ^ ((x & j) > 0) ){
                return 0;
            }
            i >>= 1;
            j <<= 1;
        }
        return 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int n = sc.nextInt();
            System.out.println(ispalin(n));
        }
    }
}
