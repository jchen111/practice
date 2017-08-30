package facebook;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by z001ktb on 6/14/17.
 */
public class SwapOnceMakeMaximum {

//    public static void swapMakeMaximum(int[] nums, int k) {
//        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if(o2[0] > o1[0]){
//                    return 1;
//                }else if(o2[0] < o1[0]){
//                    return -1;
//                }else{
//                    return o2[1] - o1[1];
//                }
//            }
//        });
//
//        for(int j = 0; j < nums.length; j++) {
//            queue.add(new int[]{nums[j],j});
//        }
//
//        int i = 0;
//        while(k > 0 && i < nums.length) {
//            while(i < nums.length && !queue.isEmpty() && nums[i] == queue.peek()[0]) {
//                if(i == queue.peek()[1]) queue.poll();
//                i++;
//            }
//            if(i < nums.length && !queue.isEmpty()) {
//                int[] a = queue.poll();
//                if(a[0] > nums[i]) {
//                    swap(i, a[1], nums);
//                    k--;
//                    i++;
//                }
//            }
//        }
//    }

    public static void swapMakeMaximum(int[] nums, int[] maxi, int k) {
        if(k == 0) {
            if(compare(nums,maxi)){
                copy(nums,maxi);
            }
            return;
        }
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] < nums[j]) {
                    swap(i, j, nums);
                    swapMakeMaximum(nums, maxi, k - 1);
                    swap(i, j, nums);
                }
            }
        }
    }

    private static void copy(int[] nums, int[] maxi) {
        for(int i = 0; i < nums.length; i++) {
            maxi[i] = nums[i];
        }
    }


    private static boolean compare(int[] nums, int[] maxi) {
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < maxi[i]) return false;
            else if(nums[i] > maxi[i]) return true;
        }
        return true;
    }

    private static void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            int N = sc.nextInt();
            int k = sc.nextInt();
            int[] nums = new int[N];
            for(int i = 0; i < N; i++) {
                nums[i] = sc.nextInt();
            }
//            int[] maxi = new int[N];
//            Arrays.fill(maxi,0);
//            swapMakeMaximum(nums, maxi, k);
//            swapMakeMaximum(nums, k);

            for(int i = 0; i < N; i++) {
                System.out.print(nums[i] + " ");
            }
        }
    }
}
