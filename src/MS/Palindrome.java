package MS;

import java.util.Scanner;

/**
 * Created by z001ktb on 4/25/17.
 */
public class Palindrome {

    public static boolean isPalindrome(String word, boolean considerCase, boolean considerSpace) {
        if(word.isEmpty()) return false;
        if(!considerCase){
            word = word.toLowerCase();
        }
        int low = 0;
        int high = word.length() - 1;
        while(low < high){
            if(!considerSpace){
                while(word.charAt(low) == ' '){
                    low++;
                }
                while(word.charAt(high) == ' '){
                    high--;
                }
            }
            if(low < high && low < word.length() && high >= 0){
                if(word.charAt(low) != word.charAt(high)) return false;
                low++;
                high--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // case: a
        // case: aa
        // case: aba
        // case: abba
        // case: ___a__, __a__
        // case: ___aa__, _aa_, _Aa_, ___Aa__
        // case: _aba__, _aba_, _Aba__, _aBa__, _Aba_, _aBa_
        // case: _abba__, _abba_, _Abba__, _aBba__, _aBBa__, _Abba_, _aBba_, _aBBa_,
        String word = sc.nextLine();
        boolean caseSensitive = sc.nextBoolean();
        boolean spaceSensitive = sc.nextBoolean();
        System.out.println(isPalindrome(word, caseSensitive, spaceSensitive));

    }


}
