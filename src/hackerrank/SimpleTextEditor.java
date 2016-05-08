package hackerrank;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by z001ktb on 4/26/16.
 */
public class SimpleTextEditor {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int Q = sc.nextInt();
        String S = "";
        Stack statusStack = new Stack();
        statusStack.push(S);
        for(int i=0; i<Q; i++){
            int operation = sc.nextInt();
            switch(operation){
                case 1:
                    String str = sc.next();
                    S += str;
                    statusStack.push(S);
                    break;
                case 2:
                    int k = sc.nextInt();
                    if(k <= S.length()){
                        S = S.substring(0,S.length()-k);
                        statusStack.push(S);
                    }
                    break;
                case 3:
                    k = sc.nextInt();
                    if(k > 0){
                        System.out.println(S.charAt(k-1));
                    }
                    break;
                case 4:
                    statusStack.pop();
                    if(!statusStack.empty()){
                        S = statusStack.peek().toString();
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
