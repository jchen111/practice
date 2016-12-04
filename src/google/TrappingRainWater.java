package google;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by jiaqichen on 11/25/16.
 */
public class TrappingRainWater {
    public static int trap(int[] height) {
        int water = 0;
        Stack<Integer> stack = new Stack<Integer>(); // int[0] index, int[1] height
        if(height.length < 3) return water;
        int i = 0;
        while(height[i] == 0){ //skipping leading zero heights
            i++;
        }

        for(; i < height.length; i++){
            if(height[i] > height[stack.peek()]){
                int bottom = height[stack.peek()];
                stack.pop();
                while (!stack.isEmpty() && height[i] >= height[stack.peek()]){
                    water += (height[stack.peek()] - bottom)*(i - stack.peek()-1);
                    bottom = height[stack.peek()];
                    stack.pop();
                }
                if(!stack.isEmpty()) water += (height[i] - bottom)*(i - stack.peek()-1);
            }
            stack.push(i);
        }
        return water;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] height = new int[N];
        for(int i = 0; i < N; i++){
            height[i] = sc.nextInt();
        }
        System.out.println(trap(height));
    }
}
