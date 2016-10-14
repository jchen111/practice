package leetcode;

import java.util.Scanner;

/**
<<<<<<< Updated upstream
 * Created by jiaqichen on 10/3/16.
=======
 * Created by z001ktb on 10/3/16.
>>>>>>> Stashed changes
 */
public class ExcelSheetColumnTitle {

    public static String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(n != 0){
            char ch = (char)((n-1)%26 + 65);
            sb.insert(0,ch);
            n = (n-1)/26;
        }
        return sb.toString();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(convertToTitle(n));
    }
}
