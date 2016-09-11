package hackerrank;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by jacky on 9/7/16.
 */
public class QuickSort {

    static ArrayList<Integer> left = new ArrayList<Integer>();
    static ArrayList<Integer> right = new ArrayList<Integer>();
    static int equal;
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        partition(arr);
    }

    public static void sorting(int[] ar) {

    }


    public static void partition(int[] arr) {
        equal = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] <= equal) {
                left.add(arr[i]);
            }else{
                right.add(arr[i]);
            }
        }
        printArray(left);
        System.out.print(equal+" ");
        printArray(right);
    }

    private static void printArray(ArrayList<Integer> ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
    }
}
