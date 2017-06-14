package MS;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by z001ktb on 5/4/17.
 */
public class ShuffleArray {

    public static int[] shuffle(int[] nums) {
        Random random = new Random();
        int n = nums.length;
        for(int i = n-1; i > 0; i--){
            int j = random.nextInt(i);
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        return nums;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for(int i = 0; i < N; i++){
            nums[i] = sc.nextInt();
        }

        System.out.println(shuffle(nums));
    }
}
