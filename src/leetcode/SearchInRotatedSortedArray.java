package leetcode;

import java.util.Scanner;

/**
 * Created by jiaqichen on 12/11/16.
 */
public class SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        if(nums.length == 0) return -1;
        int start = 0;
        int end = nums.length - 1;
        return searchhelper(nums, target, start, end);
    }

    public static int searchhelper(int[] nums, int target, int start, int end){
        if(start == end && nums[start] == target) return start;
        if(end - start == 1){
            if(nums[start] == target) return start;
            if(nums[end] == target) return end;
            return -1;
        }
        int mid = start + (end - start)/2;
        if(nums[mid] == target) return mid;
        if(nums[start] > nums[end]){
            if(nums[mid] > nums[start]){
                if(target >= nums[start] && target < nums[mid]) return helper(nums, target, start, mid);
                return searchhelper(nums, target, mid, end);
            }else{
                if(target > nums[mid] && target <= nums[end]) return helper(nums, target, mid, end);
                return searchhelper(nums, target, start, mid);
            }

        }else{
            return helper(nums, target, start, end);
        }
    }

    public static int helper(int[] nums, int target, int start, int end) {
        if(start == end && nums[start] == target) return start;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(target > nums[mid]){
                start = mid + 1;
            }else if(target < nums[mid]){
                end = mid - 1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int target = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(search(arr,target));
    }
}
