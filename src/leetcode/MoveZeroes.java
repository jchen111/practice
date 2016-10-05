package leetcode;

import java.util.Scanner;

/**
 * Created by jiaqichen on 10/4/16.
 */
public class MoveZeroes {

    public static void moveZeroes2(int[] nums) {
        int len = nums.length;
        if(len == 0)
            return;
        int i = 0;
        int j = 0;
        while(i < len && nums[i] == 0){
            i++;
        }
        while(j < len && nums[j] != 0){
            j++;
        }
        while(i < len && j < len){
            if(i > j) { // zero element appears before non zero element
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
                j++;
                while(i < len && nums[i] == 0){
                    i++;
                }
                while(j < len && nums[j] != 0){
                    j++;
                }
            }else{ // zero element appears after non zero element
                i++;
                while(i < len && nums[i] == 0){
                    i++;
                }
            }
        }
        return;
    }

    /**
     * good one
     * @param nums
     */
    public static void moveZeroes(int[] nums){
        int index=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]!=0) nums[index++]=nums[i];
        }
        while(index<nums.length){
            nums[index++]=0;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] array = new int[N];
        for(int i = 0; i < N; i++){
            array[i] = sc.nextInt();
        }
        moveZeroes(array);
        for(int i = 0; i < N; i++){
            System.out.print(array[i] + " ");
        }
    }
}
