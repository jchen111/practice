package leetcode;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by jiaqichen on 12/4/16.
 */
public class ReverseWordsII {
//    public static void reverseWords(char[] s) {
//        if(s.length == 0) return;
//        int left = 0;
//        int right = s.length - 1;
//        reverse(s, left, right); // reverse the whole sentence
//        left = 0;
//        right = 0;
//        for(; right < s.length; right++){
//            if(s[right] == ' '){
//                reverse(s,left,right-1);
//                left = right + 1;
//            }
//        }
//        reverse(s,left,right-1);
//    }
//
//    public static void reverse(char[] s, int left, int right) {
//        while(left < right){
//            char tmp = s[left];
//            s[left] = s[right];
//            s[right] = tmp;
//            left++;
//            right--;
//        }
//    }

    public static void reverseWords(char[] s) {
        if(s.length == 0) return;
        reverse(s,0,s.length-1);
        int left = 0;
        int right = 0;
        while(right < s.length){
            while(right != ' ' && right < s.length){
                right++;
            }
            reverse(s,left,right-1);
            left = right + 1;
            right++;
        }
        reverse(s,left,right-1);
    }

    public static void reverse(char[] s, int left, int right){
        while(left < right){
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] s = str.toCharArray();


        reverseWords(s);

        System.out.println(new String(s));
    }
}
