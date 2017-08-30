package MS.OTS;

import java.util.LinkedList;

public class SlidingWindowMaximumOrMinimum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(n == 0) return new int[]{};
        int[] solution = new int[n - k + 1];
        LinkedList<int[]> list = new LinkedList<int[]>(); // arr[0] -> element value, arr[1] -> element index
        int left = 0;
        int right = 0;
        int index = 0;
        while(right < n) {
            while(!list.isEmpty() && nums[right] >= list.getLast()[0]) {
                list.removeLast();
            }

            while(right < n && (list.isEmpty() || ( list.size() < k && nums[right] < list.getLast()[0]) )) {
                list.add(new int[]{nums[right], right++});
                if(right - left == k){
                    solution[index++] = list.getFirst()[0];
                    if(list.getFirst()[1] == left) list.removeFirst();
                    left++;
                }
            }
        }
        return solution;
    }

    public static int[] minSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if(n == 0) return new int[]{};
        int[] solution = new int[n - k + 1];
        LinkedList<int[]> list = new LinkedList<int[]>(); // arr[0] -> element value, arr[1] -> element index
        int left = 0;
        int right = 0;
        int index = 0;
        while(right < n) {
            while(!list.isEmpty() && nums[right] <= list.getLast()[0]) {
                list.removeLast();
            }

            while(right < n && (list.isEmpty() || ( list.size() < k && nums[right] > list.getLast()[0]) )) {
                list.add(new int[]{nums[right], right++});
                if(right - left == k){
                    solution[index++] = list.getFirst()[0];
                    if(list.getFirst()[1] == left) list.removeFirst();
                    left++;
                }
            }
        }
        return solution;
    }

    public static void main(String[] args) {
        int[] arr = {3};
        int k = 1;
//        int[] solution = maxSlidingWindow(arr,k);
//        int[] solution = minSlidingWindow(arr,k);
//        for(int i = 0; i < solution.length; i++) {
//            System.out.print(solution[i] + " ");
//        }
    }

}
