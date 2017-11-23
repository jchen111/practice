package AirBnB.phone;

import java.util.Arrays;

/**
 * Created by z001ktb
 */
public class WaterPour {

    /**
     * 往一个int array 代表海拔的格子里倒水，打印出倒水后的图， 输入：int[] 海拔， int 水数量， int 倒得位置
     *
     * For example:
     * heights = [5,4,2,1,2,3,2,1,0,1,2,4]
     *
     * +
     * ++         +
     * ++   +     +
     * +++ +++   ++
     * ++++++++ +++
     *
     * Pour 8 units of water at index 5, then output
     *
     *      |
     *      v
     * 0123456789
     * +
     * ++         +
     * ++www+     +
     * +++w+++www++
     * ++++++++w+++
     *
     * 可以和面试官讨论assumptions
     * - 水滴优先往左流，没地流再往右流，也没地了就在当前位置涨
     * - 两边有无限高的墙挡着
     * - 水滴是一滴一滴的，不能分为小数，所以一滴水会一直往左走到尽头（其实是不符合物理规则的但理他呢。。）
     */

    /**
     * let's assume water flow to the left first. out side of array is great wall
     * */
    public static void pourWaterGreatWall(int[] heights, int water, int pourPoint) {
        int[] waters = new int[heights.length];
        while(water > 0) {
            int i = pourPoint - 1;
            while (i > 0 && heights[i] + waters[i] >= heights[i-1] + waters[i - 1]) {
                i--;
            }
            int left = i;
            if(heights[left] + waters[left] < heights[pourPoint] + waters[pourPoint]) {
                waters[left]++;
                water--;
                continue;
            }


            i = pourPoint + 1;
            while(i < heights.length - 1 && heights[i] + waters[i] >= heights[i + 1] + waters[i + 1]) {
                i++;
            }
            int right = i;
            if(heights[right] + waters[right] < heights[pourPoint] + waters[pourPoint]) {
                waters[right]++;
                water--;
                continue;
            }

            waters[pourPoint]++;
            water--;
        }

        print(heights, waters);
    }

    private static void print(int[] heights, int[] waters) {
        int n = heights.length;
        int maxHeight = 0;
        for (int i = 0; i < n; i++) {
            maxHeight = Math.max(maxHeight, heights[i] + waters[i]);
        }

        String[][] print = new String[maxHeight][n];

        for(int j = 0; j < n; j++) {
            int i = maxHeight - 1;
            int count = 0;
            while(i >= 0 && count < heights[j]) {
                print[i][j] = "+";
                i--;
                count++;
            }
            count = 0;
            while(i >= 0 && count < waters[j]) {
                print[i][j] = "w";
                i--;
                count++;
            }
            while(i >= 0) {
                print[i][j] = " ";
                i--;
            }
        }

        for(int i = 0; i < print.length; i++) {
            for(int j = 0; j < print[0].length; j++) {
                System.out.print(print[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * out side of array is valley
     * **/
    public static void pourWaterGreatValley(int[] heights, int water, int pourPoint) {
        int[] waters = new int[heights.length];
        while(water > 0) {
            int i = pourPoint - 1;
            while (i > 0 && heights[i] + waters[i] >= heights[i-1] + waters[i - 1]) {
                i--;
            }
            int left = i;
            if(left != 0 && heights[left] + waters[left] < heights[pourPoint] + waters[pourPoint]) {
                waters[left]++;
                water--;
                continue;
            }


            i = pourPoint + 1;
            while(i < heights.length - 1 && heights[i] + waters[i] >= heights[i + 1] + waters[i + 1]) {
                i++;
            }
            int right = i;
            if(right != heights.length - 1 && heights[right] + waters[right] < heights[pourPoint] + waters[pourPoint]) {
                waters[right]++;
                water--;
                continue;
            }

            if(left != 0 && right != heights.length - 1) waters[pourPoint]++;
            water--;
        }

        print(heights, waters);
    }


    public static void main(String[] args) {
        int[] lands = {5,4,2,1,2,3,2,1,0,1,2,4};
        pourWaterGreatWall(lands, 24, 5);
//        pourWaterGreatValley(lands, 22, 5);
    }
}
