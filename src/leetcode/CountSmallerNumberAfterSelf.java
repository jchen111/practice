package leetcode;

import java.util.*;

/**
 * Created by z001ktb
 */
public class CountSmallerNumberAfterSelf {
    private static int binarySearch(List<Integer> list, int target) {
        int low = -1;
        int hi = list.size();
        while(hi - low > 1) {
            int mid = (hi - low) / 2 + low;
            if(mid + 1 == list.size() && list.get(mid) <= target) {
                if(list.get(mid) == target) {
                    return mid;
                } else {
                    return mid + 1;
                }
            } else if (mid == 0 && list.get(mid) >= target) {
                return 0;
            } else if(target > list.get(mid) && target <= list.get(mid + 1)) {
                return mid + 1;
            } else if(list.get(mid) >= target){
                hi = mid;
            } else {
                low = mid;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        while(true) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int target = sc.nextInt();
            Integer[] nums = new Integer[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            List<Integer> list = Arrays.asList(nums);
            Collections.sort(list);
            System.out.println(binarySearch(list, target));
        }
    }
}
