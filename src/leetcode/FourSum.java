package leetcode;

import java.util.*;

/**
 * Created by jacky on 9/14/16.
 */
public class FourSum {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> fourSumList = new ArrayList<List<Integer>>();
        if(nums.length < 4){
            return fourSumList;
        }
        Arrays.sort(nums);
        int max = nums[nums.length - 1];
        int min = nums[0];
        if(4 * min > target || 4 * max < target){
            return fourSumList;
        }

        for(int i = 0; i < nums.length; i++){
            int z = nums[i];
            if(i > 0 && z == nums[i-1]){ //avoid duplicate
                continue;
            }
            if(z + max * 3 < target){ // z is too small
                continue;
            }
            if(z * 4 > target){ // z is too large
                break;
            }
            if(4 * z == target){ // z is the boundary
                if(i + 3 < nums.length && nums[i+3] == z){
                    fourSumList.add(Arrays.asList(z,z,z,z));
                }
                break;
            }
            threeSumForFourSum(nums, target - z, i + 1, nums.length, fourSumList, z);
        }
        return fourSumList;
    }

    public static void threeSumForFourSum(int[] nums, int target, int low, int high, List<List<Integer>> fourSumList, int z1){
        if(high - low < 2){
            return;
        }

        int max = nums[high-1];
        int min = nums[low];
        if(3 * min > target || 3 * max < target){
            return;
        }

        for(int i = low; i < high-2; i++){
            int z = nums[i];
            if(i > low && z == nums[i-1]){ //avoid duplicate
                continue;
            }
            if(z + max * 2 < target){ // z is too small
                continue;
            }
            if(z * 3 > target){ // z is too large
                break;
            }
            if(3 * z == target){ // z is the boundary
                if(i + 2 < high && nums[i+2] == z){
                    fourSumList.add(Arrays.asList(z1,z,z,z));
                }
                break;
            }
            twoSumForFourSum(nums, target - z, i + 1, high, fourSumList, z1, z);
        }
    }

    public static void twoSumForFourSum(int[] nums, int target, int low, int high, List<List<Integer>> fourSumList, int z1, int z2){
        if(high - low < 1){
            return;
        }
        int max = nums[high-1];
        int min = nums[low];
        if(2 * min > target || 2 * max < target){
            return;
        }
        int i = low, j = high-1;
        while(i < j){
            int sum = nums[i] + nums[j];
            if(sum == target){
                fourSumList.add(Arrays.asList(z1,z2,nums[i],nums[j]));
                int x =nums[i];
                while(i < j && nums[i] == x){
                    i++;
                }
                x = nums[j];
                while(j > i && nums[j] == x){
                    j--;
                }
            }
            if(sum > target){
                j--;
            }
            if(sum < target){
                i++;
            }
        }
        return;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int target = sc.nextInt();
        int[] array = new int[N];
        for(int i = 0; i < N; i++){
            array[i] = sc.nextInt();
        }
        System.out.println(fourSum(array,target));
    }
}
