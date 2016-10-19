package leetcode;

import java.util.Scanner;

/**
 * Created by z001ktb on 10/13/16.
 */
public class MultiplyString {
    public static String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        if(num1.isEmpty()|| num2.isEmpty()) return sb.toString();
        int col = num1.length() + num2.length();
        int[] grid = new int[col];
        if(num1.length() < num2.length()){
            String s = num1;
            num1 = num2;
            num2 = s;
        }
        int carry = 0;
        int k = 0;
        int colIndex = col-1-k;
        for(int i = num2.length() - 1; i >=0; i--){
            int n2 = Character.getNumericValue(num2.charAt(i));
            for(int j = num1.length() - 1; j >=0; j--){
                int n1 = Character.getNumericValue(num1.charAt(j));
                grid[colIndex] += (carry + n1*n2);
                carry = grid[colIndex]/10;
                grid[colIndex] %= 10;
                colIndex--;
            }
            if(carry != 0) {
                grid[colIndex] = carry;
                carry = 0;
            }
            k++;
            colIndex = col-1-k;
        }

        if(grid[0] != 0) sb.append(grid[0]);
        for(int i = 1; i < grid.length; i++){
            sb.append(grid[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(multiply(s1,s2));
    }
}
