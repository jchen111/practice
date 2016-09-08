package hackerrank;

import java.util.Scanner;

/**
 * Created by jacky on 9/5/16.
 */
public class Search {

    public static int search(int[] arr, int value, int left, int right) {
        int mid = (left + right)/2;
        if(arr[mid] == value) {
            return mid;
        }

        if(value < arr[mid]){
            return search(arr,value,0,mid-1);
        }else {
            return search(arr, value, mid+1, right);
        }
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(search(arr, V, 0, n));
    }
}
