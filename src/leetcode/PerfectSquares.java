package leetcode;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by jiaqichen on 10/21/16.
 */
public class PerfectSquares {

//    public static int numSquares(int n){
//        int[] map = new int[n+1];
//        for(int i = 0; i < map.length; i++){
//            map[i] = Integer.MAX_VALUE;
//        }
//        int maxSquare = (int) Math.sqrt(n);
//        map[0] = 0;
//        for(int i = 1; i <= maxSquare; i++){
//            map[i*i] = 1;
//        }
//        for(int i = 1; i <= maxSquare; i++){
//            int positive = i*i;
//            for(int j = positive; j <= n-positive; j++){
//                if(map[positive] + map[j] < map[positive+j]){
//                    map[positive+j] = map[positive] + map[j];
//                }
//            }
//        }
//
//        return map[n];
//    }

    public static int numSquares(int n){
        int[] map = new int[n+1];
        for(int i = 0; i < map.length; i++){
            map[i] = Integer.MAX_VALUE;
        }
        int maxSquare = (int) Math.sqrt(n);
        map[0] = 0;
        for(int i = 1; i <= maxSquare; i++){
            map[i*i] = 1;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j*j <= i; j++){
                map[i] = Math.min(map[i],map[i-j*j]+1);
            }
        }

        return map[n];
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(numSquares(n));
    }
}
