package leetcode;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by jiaqichen on 10/21/16.
 */
public class RemoveDuplicatesFromSortedArrayII {
    //O(N)
    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int index = 0, i = 0, counter = 0;
        int check = nums[0];
        while(i < nums.length){
            while(i < nums.length && nums[i] == check){
                counter++;
                if(counter <= 2){
                    nums[index] = nums[i];
                    index++;
                }
                i++;
            }
            if(i == nums.length) break;
            check = nums[i];
            counter = 0;
        }
        return index;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] a = new int[N];
        for(int i = 0; i < N; i++){
            a[i] = sc.nextInt();
        }

        System.out.println(removeDuplicates(a));
        for(int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
}
