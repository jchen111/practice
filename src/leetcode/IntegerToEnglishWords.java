package leetcode;

import java.util.Scanner;

/**
 * Created by jiaqichen on 12/6/16.
 */
public class IntegerToEnglishWords {
    public static String numberToWords(int num) {
        if(num == 0) return "Zero";
        String[] ones = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen",
                "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen","Nineteen"};
        String[] tens = {"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        String[] thousands = {"Hundred","Thousand","Million","Billion"};
        StringBuilder result = new StringBuilder();
        String snum = Integer.toString(num);

        StringBuilder number = new StringBuilder();
        int k = 0;
        int i = snum.length() - 1;
        while(i >= 0){
            char c = snum.charAt(i);
            number.insert(0,c);

            if((k+1) % 3 == 0){
                StringBuilder tmp = new StringBuilder();
                if(Character.getNumericValue(number.charAt(2)) + Character.getNumericValue(number.charAt(1))*10 <= 19){
                    if(Character.getNumericValue(number.charAt(2)) + Character.getNumericValue(number.charAt(1))*10 != 0)
                        tmp.insert(0, ones[Character.getNumericValue(number.charAt(2)) + Character.getNumericValue(number.charAt(1))*10] + " ");
                }else{
                    if(Character.getNumericValue(number.charAt(2)) + Character.getNumericValue(number.charAt(1))*10 != 0) {
                        String str = Character.getNumericValue(number.charAt(2)) != 0 ? tens[Character.getNumericValue(number.charAt(1))] + " " + ones[Character.getNumericValue(number.charAt(2))] + " " : tens[Character.getNumericValue(number.charAt(1))] + " ";
                        tmp.insert(0, str);
                    }
                }
                if(Character.getNumericValue(number.charAt(0)) != 0) tmp.insert(0,ones[Character.getNumericValue(number.charAt(0))] + " "+ thousands[0] + " ");
                if((k+1) > 3 && tmp.length() != 0) tmp.append(thousands[k/3] + " ");
                number = new StringBuilder();
                result.insert(0,tmp);
            }
            k++;
            i--;
        }

        if(number.length() != 0){
            StringBuilder tmp = new StringBuilder();
            if(number.length() == 2) {
                if (Character.getNumericValue(number.charAt(1)) + Character.getNumericValue(number.charAt(0)) * 10 <= 19) {
                    if (Character.getNumericValue(number.charAt(1)) + Character.getNumericValue(number.charAt(0)) * 10 != 0)
                        tmp.insert(0, ones[Character.getNumericValue(number.charAt(1)) + Character.getNumericValue(number.charAt(0)) * 10] + " ");
                } else {
                    if (Character.getNumericValue(number.charAt(1)) + Character.getNumericValue(number.charAt(0)) * 10 != 0) {
                        String str = Character.getNumericValue(number.charAt(1)) != 0 ? tens[Character.getNumericValue(number.charAt(0))] + " " + ones[Character.getNumericValue(number.charAt(1))] + " " : tens[Character.getNumericValue(number.charAt(0))] + " ";
                        tmp.insert(0, str);
                    }
                }
                if((k+1) > 3 && tmp.length() != 0) tmp.append(thousands[k/3] + " ");
                result.insert(0,tmp);
            }else{
                if((k+1) > 3) tmp.insert(0, ones[Character.getNumericValue(number.charAt(0))] + " " + thousands[k / 3] + " ");
                else tmp.insert(0, ones[Character.getNumericValue(number.charAt(0))] + " ");
                result.insert(0,tmp);
            }
        }

        result.setLength(result.length() - 1);
        return result.toString();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(numberToWords(num));
    }
}
