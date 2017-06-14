package basicAlgorithm;

import java.util.Scanner;

/**
 * Created by jacky on 9/5/16.
 */
public class QuickSort {

    public static void quickSort(int[] arr) {
        doSort(arr, 0, arr.length - 1);
    }

    private static void doSort(int[] arr, int lo, int hi) {
        if(lo < hi) {
            int pi = partition(arr, lo, hi);

            doSort(arr, lo, pi - 1);
            doSort(arr, pi + 1, hi);
        }
    }

    private static int partition(int[] arr, int lo, int hi) {
        int pivot = arr[hi];
        int left = lo;
        int right = lo;
        while(right < hi) {
            if(arr[right] < pivot) {
                swap(arr, left++, right);
            }
            right++;
        }
        swap(arr, hi, left);
        return left;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        while(true) {

            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            int[] arr = new int[N];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }

            quickSort(arr);

            printArray(arr);
        }
    }
}
