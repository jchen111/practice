package facebook;

import java.util.Scanner;

/**
 * Created by z001ktb on 6/12/17.
 */
public class FindMountainOrValley {
    /**
     * time O(1)
     * space O(1)
     * if nums[i+1] and nums[i] can differ at most by 1, and there is only one peek or valley in the array,
     * than we can have the following equation
     * say x is the index of the peek, i is the index of the head of the array,
     * j is the index of the tail of the array,
     * if isUp = true
     *  A[x] - A[j] = j - x
     *  A[x] - A[i] = x - i
     *  then we will have x = (A[j] - A[i] + j + i)/2
     * else
     *  A[i] - A[x] = x - i;
     *  A[j] - A[x] = j - x;
     *  then we will have x = (A[i] - A[j] + i + j)/2
     * */
    public static int findMountainOrValley2(int[] nums) {
        if(nums.length < 3) return -1;
        boolean isUp = nums[0] > nums[1]? false : true;
        if(isUp){
            return (nums[nums.length - 1] - nums[0] + nums.length - 1)/2;
        }else {
            return (nums[0] - nums[nums.length - 1] + nums.length - 1)/2;
        }
    }

    /**
    time O(logN)
    space O(1)
    */
    public static int findMountainOrValley(int[] nums) {
        if(nums.length < 3) return -1;
        boolean isUp = nums[0] > nums[1]? false : true;
        if(isUp){
            return findMountain(nums);
        }else {
            return findValley(nums);
        }
    }

    private static int findMountain(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while(hi - lo > 1) {
            int mid = (hi - lo)/2 + lo;
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
                return mid;
            }else if(nums[mid] > nums[mid-1]) {
                lo = mid;
            }else {
                hi = mid;
            }
        }
        return -1;
    }

    private static int findValley(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        while(hi - lo > 1) {
            int mid = (hi - lo)/2 + lo;
            if(nums[mid] < nums[mid-1] && nums[mid] < nums[mid+1]){
                return mid;
            }else if(nums[mid] < nums[mid-1]) {
                lo = mid;
            }else {
                hi = mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            int N = sc.nextInt();
            int[] nums = new int[N];

            for (int i = 0; i < nums.length; i++) {
                nums[i] = sc.nextInt();
            }

            System.out.println(findMountainOrValley(nums));
        }
    }
}
