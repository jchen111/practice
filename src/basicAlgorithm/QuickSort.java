package basicAlgorithm;

import java.util.Scanner;

/**
 * Created by jacky on 9/5/16.
 */
public class QuickSort {

    public static void quickSort(int[] arr, int left, int right) {

        int pivotIndex = left + (right - left) / 2;
        int pivotValue = arr[pivotIndex];

        int i = left, j = right;

        while(i <= j) {

            while(arr[i] < pivotValue) {
                i++;
            }

            while(arr[j] > pivotValue) {
                j--;
            }

            if(i <= j) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }

            if(left < i) {
                quickSort(arr, left, j);
            }

            if(right > i) {
                quickSort(arr, i, right);
            }

        }

    }

    public static void main(String[] args) {
        while(true) {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }
            quickSort(arr, 0, N - 1);
            for (int i = 0; i < N; i++) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
