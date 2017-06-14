package facebook;

import java.util.Scanner;

/**
 * Created by z001ktb on 6/11/17.
 */
public class SumOfProductsOfAllPossibleSubsets {
    static int sum = 0;
    /*
    brute force: O(2^N)
    * */
    public static int bruteSum(int[] nums) {
        boolean[] used = new boolean[nums.length];
        compute(nums, 1,0);
        return sum;
    }

    private static void compute(int[] nums, int product, int index) {
        if(index != 0) {
            sum += product;
        }

        for(int i = index; i < nums.length; i++) {
            product *= nums[i];
            compute(nums, product, i + 1);
            product /= nums[i];
        }
    }

    /* sum = a + b + c + ab + ac + bc + abc
           = a + ac + b + bc + ab + abc + 1 + c - 1
           = a(1 + c) + b(1 + c) + ab(1 + c) + 1 + c - 1
           = (1 + c)(a + b + ab + 1) - 1
           = (1 + c)(1 + a)(1 + b) - 1
    * */
    public static int smartSum(int[] nums) {
        int product = 1;
        for(Integer num : nums) {
            product *= (num + 1);
        }
        return product - 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for(int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(bruteSum(nums));
        System.out.println(smartSum(nums));
    }
}
