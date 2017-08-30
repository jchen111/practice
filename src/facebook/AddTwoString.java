package facebook;

import java.util.Scanner;

/**
 * Created by z001ktb on 6/17/17.
 */
public class AddTwoString {
    public static String minus(String num1, String num2) {
        String res = "";
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int borrow = 0;
        while(i >= 0 || j >= 0) {
            while(i >= 0 && j >= 0) {
                int n1 = (num1.charAt(i) - '0') - borrow >= 0 ? (num1.charAt(i) - '0') - borrow : (num1.charAt(i) - '0') - borrow + 10;
                int n2 = num2.charAt(j) - '0';
                res = ((n1 - n2) >= 0? (n1 - n2) : (n1-n2)+10) + res;
                if(n1 < n2 || (num1.charAt(i) - '0') - borrow < 0) borrow = 1;
                else borrow = 0;
                i--;
                j--;
            }
            if(i >= 0) {
                int n1 = (num1.charAt(i) - '0') - borrow >= 0 ? (num1.charAt(i) - '0') - borrow : (num1.charAt(i) - '0') - borrow + 10;
                if(n1 != 0) res = n1 + res;
                if((num1.charAt(i) - '0') - borrow < 0) borrow = 1;
                else borrow = 0;
                i--;
            }
        }
        int k = 0;
        while(k < res.length() - 1 && res.charAt(k) == '0') {
            k++;
        }
        res = res.substring(k);
        return res;
    }
    public static String add(String num1, String num2) {
        String sum = "";
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        while(i >= 0 || j >= 0) {
            while(i >= 0 && j >= 0) {
                sum = ((num1.charAt(i) - '0') + (num2.charAt(j) - '0') + carry) % 10  + sum;
                carry = ((num1.charAt(i) - '0') + (num2.charAt(j) - '0') + carry) / 10;
                i--;
                j--;
            }
            if(i >= 0) {
                sum = ((num1.charAt(i) - '0') + carry) % 10  + sum;
                carry = ((num1.charAt(i) - '0') + carry) / 10;
                i--;
            }
            if(j >= 0) {
                sum = ((num2.charAt(j) - '0') + carry) % 10  + sum;
                carry = ((num2.charAt(j) - '0') + carry) / 10;
                j--;
            }
        }
        if(carry != 0) sum = '1' + sum;
        return sum;
    }

    private static int compare(String num1, String num2) {
        if(num1.length() != num2.length()){
            if(num1.length() > num2.length()) return 1;
            return -1;
        }
        int i = 0;
        while(i < num1.length()) {
            char c1 = num1.charAt(i);
            char c2 = num2.charAt(i);
            if(c1 > c2) return 1;
            else if(c1 < c2) return -1;
            else i++;
        }
        return 0;
    }

    public static String addTwoString(String num1, String num2) {
        if(num1.isEmpty() || num2.isEmpty()){
            if(num1.isEmpty()) return num2;
            else return num1;
        }

        String res = "";

        int sign1 = num1.charAt(0) == '-' ? 0 : 1;
        int sign2 = num2.charAt(0) == '-' ? 0 : 1;
        if(sign1 == 0) num1 = num1.substring(1);
        if(sign2 == 0) num2 = num2.substring(1);
        if(sign1 != sign2) {
            if (compare(num1,num2) < 0) { // num2 > num1
                res = minus(num2,num1);
                if(sign2 == 0 && !res.equals("0")) res = '-' + res;
            } else { // num1 >= num2
                res = minus(num1,num2);
                if(sign1 == 0 && !res.equals("0")) res = '-' + res;
            }
        }else {
            res = add(num1, num2);
            if(sign1 == 0) res = '-' + res;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            String num1 = sc.next();
            String num2 = sc.next();
//            System.out.println(add(num1,num2));
//            System.out.println(minus(num1,num2));
            System.out.println(addTwoString(num1,num2));
        }
    }
}
