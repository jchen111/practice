package BB;

/**
 * Created by z001ktb
 */
public class FindKthInTwoSortedArray {
    public static int findKthNumber(int[] nums1, int[] nums2, int k) {
        return helper(nums1, 0, nums2, 0, k);
    }

    public static int helper(int[] nums1, int nums1Start, int[] nums2, int nums2Start, int k) {
        if(nums1Start >= nums1.length) {
            return nums2[nums2Start + k - 1];
        }
        if(nums2Start >= nums2.length) {
            return nums1[nums1Start + k - 1];
        }
        if(k == 1) {
            return Math.min(nums1[nums1Start], nums2[nums2Start]);
        }

        int A = nums1Start + k/2 - 1 > nums1.length ? Integer.MAX_VALUE : nums1[nums1Start + k/2 - 1];
        int B = nums2Start + k/2 - 1 > nums2.length ? Integer.MAX_VALUE : nums2[nums2Start + k/2 - 1];

        if(A > B) {
            return helper(nums1, nums1Start, nums2, nums2Start + k/2, k - k/2);
        } else {
            return helper(nums1, nums1Start + k/2, nums2, nums2Start, k - k /2);
        }
    }
}
