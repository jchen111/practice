package MS;

import java.util.Scanner;

/**
 * Created by z001ktb on 5/3/17.
 */
public class NumberToTimeInWords {

    // 0 - 2359
    public static String numberToTimeInWords(int num) {
        String numNames[] = {
                "zero",
                "one",
                "two",
                "three",
                "four",
                "five",
                "six",
                "seven",
                "eight",
                "nine",
                "ten",
                "eleven",
                "twelve",
                "thirteen",
                "fourteen",
                "fifteen",
                "sixteen",
                "seventeen",
                "eighteen",
                "nineteen"
        };
        String tenNames[] = {
                "",
                "ten",
                "twenty",
                "thirty",
                "forty",
                "fifty"
        };
        StringBuilder sb = new StringBuilder();
        String AMPM = num > 1200 ? "PM" : "AM";
        while(num > 0){
            if(num > 100) {
                if(num / 100 > 12) {
                    sb.append(numNames[(num / 100) % 12] + " ");
                }else{
                    sb.append(numNames[num / 100] + " ");
                }
                num = num % 100;
            }else{
                if(sb.length() == 0) sb.append("zero ");
                if(num >= 10) {
                    sb.append(tenNames[num / 10] + " ");
                    num = num % 10;
                }else{
                    sb.append(numNames[num] + " ");
                    break;
                }
            }
        }
        sb.append(AMPM);
        return sb.toString();
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(true){
            int num = sc.nextInt();
            System.out.println(numberToTimeInWords(num));
        }
    }
}
