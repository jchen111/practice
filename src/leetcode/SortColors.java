package leetcode;

/**
 * Created by jiaqichen on 9/30/16.
 */
public class SortColors {

//    public void sortColors(int[] nums) {
//        LinkedList<Integer> reds = new LinkedList<Integer>();
//        LinkedList<Integer> whites = new LinkedList<Integer>();
//        LinkedList<Integer> blues = new LinkedList<Integer>();
//
//        int i =0, j = nums.length - 1;
//        while(i <= j){
//            if(i == j){
//                switch (nums[i]) {
//                    case 0:
//                        reds.add(nums[i]);
//                        i++;
//                        break;
//                    case 1:
//                        whites.add(nums[i]);
//                        i++;
//                        break;
//                    case 2:
//                        blues.add(nums[i]);
//                        i++;
//                        break;
//                    default:
//                        break;
//                }
//            }else {
//                switch (nums[i]) {
//                    case 0:
//                        reds.add(nums[i]);
//                        i++;
//                        break;
//                    case 1:
//                        whites.add(nums[i]);
//                        i++;
//                        break;
//                    case 2:
//                        blues.add(nums[i]);
//                        i++;
//                        break;
//                    default:
//                        break;
//                }
//                switch (nums[j]) {
//                    case 0:
//                        reds.add(nums[j]);
//                        j--;
//                        break;
//                    case 1:
//                        whites.add(nums[j]);
//                        j--;
//                        break;
//                    case 2:
//                        blues.add(nums[j]);
//                        j--;
//                        break;
//                    default:
//                        break;
//                }
//            }
//        }
//
//        i = 0;
//        while(i < nums.length){
//            while(!reds.isEmpty()){
//                nums[i] = reds.poll();
//                i++;
//            }
//            while(!whites.isEmpty()){
//                nums[i] = whites.poll();
//                i++;
//            }
//            while(!blues.isEmpty()){
//                nums[i] = blues.poll();
//                i++;
//            }
//        }
//        return;
//    }

    public static void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) return;
        int low = 0;
        int hi = nums.length - 1;
        int i = 0;
        while(i <= hi) {
            if(nums[i] == 0) {
                swap(nums, i, low++);
            } else if (nums[i] == 2) {
                swap(nums, i, hi--);
                i--;
            }
            i++;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,2,0,1,2,0,1};
        sortColors(nums);
    }

    /*
    http://2hwp.com/LeetCode/75%20Sort%20Colors/
     */
//    public void sortColors(int[] A) {
//        if (A == null || A.length < 2) return;
//        int low = 0;
//        int high = A.length - 1;
//        for (int i = low; i <= high; ) {
//            if (A[i] == 0) {
//                // swap A[i] and A[low] and i,low both ++
//                int temp = A[i];
//                A[i] = A[low];
//                A[low] = temp;
//                i++;
//                low++;
//            } else if (A[i] == 2) {
//                //swap A[i] and A[high] and high--;
//                int temp = A[i];
//                A[i] = A[high];
//                A[high] = temp;
//                high--;
//            } else {
//                i++;
//            }
//        }
//    }
}
