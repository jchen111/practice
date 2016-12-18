package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jiaqichen on 12/4/16.
 */
public class MissingRanges {
    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<String>();
        if(nums.length == 0) {
            if(lower != upper){
                if(lower == upper - 1){
                    result.add("" + lower);
                    result.add("" + upper);
                }else{
                    result.add(lower + "->" + upper);
                }
            }else{
                result.add("" + lower);
            }
            return result;
        }

        if(lower < nums[0]){
            if(lower == nums[0] - 1){
                result.add("" + lower);
            }else{
                result.add(lower + "->" + (nums[0]-1));
            }
        }

        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] != nums[i+1] - 1){
                if(nums[i+1] - nums[i] == 2){
                    result.add("" + (nums[i] + 1));
                }else if(nums[i+1] - nums[i] > 2) {
                    int start = nums[i] + 1;
                    result.add( start + "->" + (nums[i+1]-1));
                }
            }
        }

        if(upper > nums[nums.length-1]){
            if(upper == nums[nums.length-1] + 1){
                result.add("" + upper);
            }else{
                int start = nums[nums.length-1] + 1;
                result.add(start + "->" + upper);
            }
        }

        return result;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for(int i = 0; i < N; i++){
            nums[i] = sc.nextInt();
        }
        findMissingRanges(nums,0,99);
    }
}
