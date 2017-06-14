package facebook;

import java.util.Scanner;

/**
 * Created by z001ktb on 6/12/17.
 */
public class LongestIncreasingSubsequenceByOne {

    public static int longestIncreasingSubsequence(int[] nums) {
        if(nums.length == 0) return 0;
        int i = 0;
        int max = 1;
        while(i < nums.length) {
            int j = i;
            while(j + 1 < nums.length && nums[j + 1] - nums[j] == 1) {
                j++;
                max = Math.max(max, j - i + 1);
            }
            if(i == j) i++;
            else i = j;
        }
        return max;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            int N = sc.nextInt();
            int[] nums = new int[N];
            for (int i = 0; i < N; i++) {
                nums[i] = sc.nextInt();
            }

            System.out.println(longestIncreasingSubsequence(nums));
        }
    }
}
