package leetcode;

import java.util.Scanner;

/**
 * Created by jiaqichen on 11/6/16.
 */
public class GuessNumber {

    public static int guess(int num){
        if(num > 6){
            return 1;
        }else if (num < 6){
            return -1;
        }else
            return 0;
    }

    public static int guessNumber(int n) {
        if(n == 1) return 1;
        int left = 1;
        int right = n;
        int mid = left + (right-left)/2;
        while(left <= right){
            mid = left + (right-left)/2;
            if(guess(mid) == -1){
                left = mid + 1;
            }else if(guess(mid) == 1){
                right = mid - 1;
            }else{
                break;
            }
        }
        return mid;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(guessNumber(n));
    }
}
