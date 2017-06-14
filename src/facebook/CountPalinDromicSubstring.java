package facebook;

/**
 * Created by z001ktb on 6/9/17.
 */
public class CountPalinDromicSubstring {

    /*

     Clarifying Questions:
     Is the palindromic substring we are talking about here case sensitive? aA?

     Initial ideas and solutions:
     My idea is loop through indices of the string, then for each index i,
     calculate the number of odd-length palindromic substrings which centers at index i,
     and add it to total,
     calculate the number of even-length palindromic substrings which centers at i and i + 1,
     and add it to total.
     return total at last.

     Coding:

     Testing:
     "a","aba","aa","abba","aaa","aaaa","ab","","aab"

     Analysis:
     time: O(n^2)
     space: O(1)

    */

    public static int countPalindromeSubstring(String str) {

        int total = 0;
        int count = 0;

        for(int i = 0; i < str.length(); i++) {
            int left = i - 1;
            int right = i + 1;
            count = 1;
            while(left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
                count++;
                left--;
                right++;
            }
            total += count;
        }

        for(int i = 0; i < str.length(); i++) {
            int left = i;
            int right = i + 1;
            count = 0;
            while(left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
                count++;
                left--;
                right++;
            }
            total += count;
        }

        return total;
    }

    public static void main (String[] args) throws java.lang.Exception
    {

        String[] strs = {"a","aba","aa","abba","aaa","aaaa","ab","","aab"};

        for(String str : strs) {
            System.out.println(str + " " + countPalindromeSubstring(str));
        }
    }
}
