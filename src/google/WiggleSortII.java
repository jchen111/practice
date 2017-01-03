package google;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jiaqichen on 11/20/16.
 */
public class WiggleSortII {
    public static void wiggleSort(int[] nums) {
        if(nums.length == 0 || nums.length == 1) return;
        int len = nums.length;
        Arrays.sort(nums);
        int[] result = new int[len];
        int k = 1;
        int i = len - 1;
        int m = 0;
        if(len % 2 == 0) m = len/2;
        else m = len/2+1;
        for(; i >= m; i--){
            result[k] = nums[i];
            k+=2;
        }
        k = 0;
        for(; i >= 0; i--){
            result[k] = nums[i];
            k+=2;
        }

        for(i = 0; i < len; i++){
            nums[i] = result[i];
        }
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        wiggleSort(arr);
    }
}
