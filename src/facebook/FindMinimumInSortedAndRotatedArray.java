package facebook;

import java.util.Scanner;

/**
 * Created by z001ktb on 6/20/17.
 */
public class FindMinimumInSortedAndRotatedArray {
    /**
     * 5,6,1,2,3,4 -> 2
     * 1,2,3,4 -> 0
     * 2,1 -> 1
     * 1,3,2 invalid case
     * 2 3 4 1 -> 3
     * */
    public static int find(int[] nums) {
        int lo = -1;
        int hi = nums.length;
        while(hi - lo > 1) {
            int mid = (hi - lo)/2 + lo;
            if(mid - 1 >= 0 && nums[mid] < nums[mid-1]) {
                return mid;
            }else if(nums[mid] > nums[hi-1]){
                lo = mid;
            }else {
                hi = mid;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            System.out.println(find(nums));
        }
    }
}
