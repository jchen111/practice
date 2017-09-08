package Spotify;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LetterConbinations {
    static List<String> letterCombinations(String str) {
        List<String> result = new ArrayList<String>();
        backtrack(result, str.toCharArray(), 0);
        return result;
    }

    static void backtrack(List<String> result, char[] arr, int index) {
        result.add(new String(arr));
        for(int i = index; i < arr.length; i++) {
            char old = arr[i];
            arr[i] = Character.toUpperCase(arr[i]);
            backtrack(result, arr, i + 1);
            arr[i] = old;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(letterCombinations(str));
    }
}
