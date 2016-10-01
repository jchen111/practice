package leetcode;

import java.util.Scanner;

/**
 * Created by jiaqichen on 9/30/16.
 */
public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        boolean findWord = false;
        int wordLen = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(i) != 32){
                wordLen++;
                findWord = true;
            }
            if(s.charAt(i) == 32){
                if(findWord){
                    return wordLen;
                }
            }
        }
        return wordLen;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int res = lengthOfLastWord(str);
        System.out.println(res);
    }
}
