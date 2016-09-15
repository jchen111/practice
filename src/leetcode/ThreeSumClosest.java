package leetcode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by jacky on 9/14/16.
 */
public class ThreeSumClosest {
    public static void quickSort(int[] arr, int left, int right) {

        int pivotIndex = left + (right - left) / 2;
        int pivotValue = arr[pivotIndex];

        int i = left, j = right;

        while (i <= j) {

            while (arr[i] < pivotValue) {
                i++;
            }

            while (arr[j] > pivotValue) {
                j--;
            }

            if (i <= j) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }

            if (left < i) {
                quickSort(arr, left, j);
            }

            if (right > i) {
                quickSort(arr, i, right);
            }

        }
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int min = nums[0] + nums[1] + nums[2];
        int max = nums[n-3] + nums[n-2] + nums[n-1];

        if(target < min){
            return min;
        }
        if(target > max){
            return max;
        }

        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) / 2;
        int closest = nums[left] + nums[mid] + nums[right] - target;

        while(right - left >= 2) {
            int l = left + 1;
            int r = right - 1;
            while(l<=r){
                int m = (l + r) / 2;

                if(Math.abs(nums[left] + nums[m] + nums[right] - target) < Math.abs(closest)){
                    closest = nums[left] + nums[m] + nums[right] - target;
                }

                if(nums[left] + nums[m] + nums[right] < target){
                    l = m+1;
                }else if(nums[left] + nums[m] + nums[right] > target){
                    r = m-1;
                }else{
                    return target;
                }

            }
            if(closest > 0){
                right--;
            }else{
                left++;
            }

        }
        return closest+target;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int target = sc.nextInt();
        int[] array = new int[N];
        for(int i = 0; i < N; i++){
            array[i] = sc.nextInt();
        }
        System.out.println(threeSumClosest(array,target));
    }
}
