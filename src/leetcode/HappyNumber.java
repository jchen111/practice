package leetcode;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by jiaqichen on 10/6/16.
 */
public class HappyNumber {
    public static boolean isHappy(int n) {
        int num = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        while(Math.pow(n,2) > 9){
            if(!set.contains(n))
                set.add(n);
            else
                return false;
            while(n != 0){
                num += Math.pow(n%10,2);
                n /= 10;
            }
            n = num;
            num = 0;
        }
        if(n == 1){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        /**
         * test case: 19 yes
         * test case: 20 no
         * test case: 1~9 no
         * case: 101 no
         * case: 911 no
         * case:
         */
        System.out.println(isHappy(n));
    }
}

