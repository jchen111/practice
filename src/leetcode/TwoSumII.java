package leetcode;

import java.util.Scanner;

/**
 * Created by z001ktb on 10/12/16.
 */
public class TwoSumII {
    public static int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int i = 0;
        int j = numbers.length-1;
        while(i < numbers.length - 1 && j > 0){
            int l = search(numbers,i+1,numbers.length-1,target-numbers[i]);
            int r = search(numbers,0,j-1,target-numbers[j]);
            if(l != -1){
                res[0] = i+1;
                res[1] = l;
                return res;
            }else{
                i++;
            }

            if(r != -1){
                res[0] = r;
                res[1] = j+1;
                return res;
            }else{
                j--;
            }
        }
        return res;
    }

    public static int search(int[] numbers, int start, int end, int target){
        if(start > end) return -1;
        if(start == end){
            if(numbers[start] == target) return start+1;
            return -1;
        }
        int mid = (start + end) / 2;
        if(numbers[mid] > target){
            return search(numbers,start,mid-1,target);
        }else if(numbers[mid] < target){
            return search(numbers,mid+1,end,target);
        }else{
            return mid+1;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr  = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }
        System.out.print(twoSum(arr,200));
    }
}
