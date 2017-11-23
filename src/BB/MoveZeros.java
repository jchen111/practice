package BB;

/**
 * Created by z001ktb
 */
public class MoveZeros {
    //move odd numbers to the head of the array
    //follow up 1: odd numbers keep order
    //follow up 2: both even and odd keep order
    public static void moveZeroes(int[] nums) {
        if(nums.length == 0) return;
        boolean swaped = false;
        while(true) {
            for(int i = 0; i < nums.length - 1; i++) {
                if(nums[i] % 2 == 0 && nums[i + 1] % 2 != 0) {
                    swap(nums, i, i + 1);
                    swaped = true;
                }
            }
            if(!swaped) break;
            swaped = false;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        moveZeroes(nums);
        for(int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ",");
        }
    }
}
