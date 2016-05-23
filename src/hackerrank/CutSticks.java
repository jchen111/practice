package hackerrank;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by z001ktb on 5/15/16.
 */
public class CutSticks {

    /**
     * Time Complexity: O(n*log(n))
     * @param arr
     * @return
     */
    static int[] sort(int[] arr) {
        if(arr.length == 1) {
            return arr;
        }else {
            int length = arr.length;
            return merge(sort(Arrays.copyOfRange(arr,0,length/2)),sort(Arrays.copyOfRange(arr,length/2,length)));
        }
    }

    static int[] merge(int[] arr1, int[] arr2) {
        int length1 = arr1.length;
        int length2 = arr2.length;
        int new_arr[] = new int[length1 + length2];
        int k = 0, i=0, j=0;
        while(i < length1 && j < length2 && k < length1 + length2) {
            while (j < length2 && i < length1 && arr1[i] <= arr2[j]) {
                new_arr[k] = arr1[i];
                i++;
                k++;
            }
            while (i < length1 && j < length2 && arr1[i] > arr2[j]) {
                new_arr[k] = arr2[j];
                j++;
                k++;
            }
            while(i == length1 && j < length2) {
                new_arr[k] = arr2[j];
                j++;
                k++;
            }
            while(j == length2 && i < length1) {
                new_arr[k] = arr1[i];
                i++;
                k++;
            }
        }
        return new_arr;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        arr = sort(arr);
        while(arr.length != 0) {
            System.out.println(arr.length);
            int min  = arr[0];
            int k = 0;
            for (int i = 0; i < arr.length; i++) {
                if(arr[i] == min) {
                    k = i;
                }else {
                    arr[i] -= min;
                }
            }
            arr = Arrays.copyOfRange(arr,k+1,arr.length);
        }
    }
}
