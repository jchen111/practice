package leetcode;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by jiaqichen on 10/6/16.
 */
public class EvaluateReversePolishNotation {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(Integer.parseInt(tokens[0]));
        for(int i = 1; i < tokens.length; i++){
            if(checkOperand(tokens[i])){
                int num = stack.pop();
                switch(tokens[i]){
                    case "+":
                        if(!stack.isEmpty()) {
                            stack.push(stack.pop()+num);
                        }
                        break;
                    case "-":
                        if(!stack.isEmpty()){
                            stack.push(stack.pop()-num);
                        }
                        break;
                    case "*":
                        if (!stack.isEmpty()) {
                            stack.push(stack.pop()*num);
                        }
                        break;
                    case "/":
                        if(!stack.isEmpty()){
                            stack.push(stack.pop()/num);
                        }
                        break;
                }
            }else{
                stack.push(Integer.parseInt(tokens[i]));
            }

        }
        return stack.pop();
    }

    public static boolean checkOperand(String s){
        if(s.equals("+") || s.equals("-") ||
                s.equals("*") || s.equals("/")) {
            return true;
        }
        return false;
    }

    /**
     * case: 2,1,+,3,* ->9
     * case: 4,13,5,/,+ ->6
     * case: 16,4,2,/,/ ->8
     * case: 16,4,2,+,+ ->24
     * case: 16,4,2,-,- ->14
     * case: 16 ->16
     * case: 19,19,19,+ ->38
     * case: 3,11,5,+,- ->-13
     * case: -78 -33 196 + -19 - 115 + - ->-375
     * case: ["4","-2","/","2","-3","-","-"] -> -7
     * @param args
     */

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] array = new String[N];
        for(int i = 0; i < N; i++){
            array[i] = sc.next();
        }
        System.out.println(evalRPN(array));
    }
}
