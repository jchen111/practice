package MS.OTS;

import java.util.Stack;

public class VerticalPrintDigits {
    public static void printVertical(int i) {
        i = Math.abs(i);
        Stack<Integer> stack = new Stack<>();
        while(i > 0) {
            stack.push(i % 10);
            i /= 10;
        }

        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }


}
