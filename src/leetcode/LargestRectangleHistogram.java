package leetcode;

public class LargestRectangleHistogram {
    public static int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0) return 0;
        int max = heights[0];
        int minh = heights[0];
        int index = 0;
        for(int i = 1; i < heights.length; i++) {
            if(heights[i] < minh) {
                minh = heights[i];
            }
            if(heights[i] > (i - index + 1) * minh) {
                max = heights[i];
                minh = heights[i];
                index = i;
            }else {
                max = Math.max(max, (i - index + 1) * minh);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {2,1,5,6,2,3};
        largestRectangleArea(arr);
    }
}
