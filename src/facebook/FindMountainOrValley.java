package facebook;

import java.util.Scanner;

/**
 * Created by z001ktb on 6/12/17.
 */
public class FindMountainOrValley {

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
