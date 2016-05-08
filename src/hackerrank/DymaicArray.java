package hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class DymaicArray {

    public static void dynamicArray(long N, int Q, long[][] arr){
        long lastans = 0;
        String[] sequences = new String[(int)N];
        Arrays.fill(sequences,"");
        for(int i=0; i<Q; i++){
            long x = arr[i][1], y = arr[i][2];
            if(arr[i][0] == 1){
                sequences[(int)((x^lastans)%N)] += " " + arr[i][2];
            }else if(arr[i][0] == 2){
                String[] arr_tmp = sequences[(int)((x^lastans)%N)].split(" ");
                long index = y%(arr_tmp.length);
                System.out.println(arr_tmp[(int)(index)]);
                lastans = Long.parseLong(arr_tmp[(int)(index+1)]);
            }else;
        }
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named DymaicArray. */
        Scanner in = new Scanner(System.in);
        long N = in.nextInt();
        int Q = in.nextInt();
        long[][] arr = new long[Q][3];
        for(int i=0; i<Q; i++){
            for(int j=0; j<3; j++){
                arr[i][j] = in.nextInt();
            }
        }
        dynamicArray(N,Q,arr);
    }
}