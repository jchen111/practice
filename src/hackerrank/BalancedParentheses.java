package hackerrank;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by z001ktb on 2/11/16.
 */
public class BalancedParentheses {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=0; i<T; i++){
            String s = sc.next();
            if(isBalanced(s)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }

    public static boolean isBalanced(String s){
        if(s.length()==0){
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            switch(c){
                case '{':
                    stack.push(c);
                    break;
                case '[':
                    stack.push(c);
                    break;
                case '(':
                    stack.push(c);
                    break;
                case '}':
                    if(stack.empty() || stack.pop() != '{'){
                        return false;
                    }
                    break;
                case ']':
                    if(stack.empty() || stack.pop() != '['){
                        return false;
                    }
                    break;
                case ')' :
                    if(stack.empty() || stack.pop() != '('){
                        return false;
                    }
                    break;
                default:
                    break;
            }
        }
        if(!stack.empty()){
            return false;
        }
        return true;
    }
}
