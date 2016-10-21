package leetcode;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by jiaqichen on 10/20/16.
 */
public class SimplifyPath {
    public static String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder();
        sb.append('/');
        LinkedList<String> stack = new LinkedList<String>();
        for(String s: path.split("/")){
            if(s.equals("..") ){
                if(!stack.isEmpty())
                    stack.removeLast();
            }else if(!s.equals("") && !s.equals(".")){
                stack.add(s);
            }
        }

        for(String s: stack){
            sb.append(s+"/");
        }
        if(!stack.isEmpty()) sb.setLength(sb.length()-1);
        return sb.toString();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String path = sc.next();
        System.out.println(simplifyPath(path));
    }
}
