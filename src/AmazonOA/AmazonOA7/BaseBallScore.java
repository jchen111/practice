package AmazonOA.AmazonOA7;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by z001ktb on 5/17/17.
 */
public class BaseBallScore {

    public static int countScore(String[] scores) {
        int sum = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(String str : scores){
            if(str.equals("Z") || str.equals("X") || str.equals("+")){
                if(str.equals("Z")){
                    if(!stack.isEmpty()) sum -= stack.pop();
                }else if(str.equals("X")){
                    int num = stack.peek();
                    sum += num * 2;
                    stack.push(num * 2);
                }else if(str.equals("+")){
                    int num1 = 0, num2 = 0;
                    if(!stack.isEmpty()) {
                        num1 = stack.pop();
                    }
                    if(!stack.isEmpty()) {
                        num2 = stack.pop();
                    }
                    stack.push(num2);
                    stack.push(num1);
                    stack.push(num1 + num2);
                    sum += num1 + num2;
                }
            }else{
                int num = Integer.valueOf(str);
                sum += num;
                stack.push(num);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] scores = new String[N];
        for(int i = 0; i < N; i++){
            scores[i] = sc.next();
        }
        System.out.println(countScore(scores));
    }
}
