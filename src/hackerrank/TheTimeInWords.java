package hackerrank;

import java.util.HashMap;
import java.util.Scanner;
import java.util.StringJoiner;

/**
 * Created by z001ktb on 5/31/16.
 */
public class TheTimeInWords {
    static final String numNames[] = {
            "",
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

    static final String tenNames[] = {
            "",
            "ten",
            "twenty",
            "thirty",
            "forty",
            "fifty"
    };

    public static String convertWords(int hour, int minute) {
        StringBuilder sb = new StringBuilder();
        if( minute <= 30 ) {
            if( minute == 0 ) {
                sb.append(numNames[hour]);
                sb.append(" o' clock");
                return sb.toString();
            }else {
                if( minute == 1) {
                    sb.append("one minute ");
                    sb.append("past " + numNames[hour]);
                    return sb.toString();
                }else if( minute % 30 == 0){
                    sb.append("half past " + numNames[hour]);
                    return sb.toString();
                }else if( minute % 15 == 0) {
                    if(minute/15 > 1)
                        sb.append(numNames[minute/15] + " quarters " + "past " + numNames[hour]);
                    else
                        sb.append("quarter " + "past " + numNames[hour]);
                    return sb.toString();
                } else if(minute % 10 == 0) {
                    sb.append(tenNames[minute/10] + " minutes past " + numNames[hour]);
                    return sb.toString();
                }else if(minute < 20){
                    sb.append(numNames[minute] + " minutes past " + numNames[hour]);
                    return sb.toString();
                }else {
                    sb.append(tenNames[Character.getNumericValue(Integer.toString(minute).charAt(0))] + " " + numNames[Character.getNumericValue(Integer.toString(minute).charAt(1))] + " minutes ");
                    sb.append("past " + numNames[hour]);
                    return sb.toString();
                }
            }
        }else {
            if( 60 - minute == 1 ) {
                sb.append("one minute to " + numNames[hour + 1]);
                return sb.toString();
            }else if((60 - minute) % 15 == 0) {
                if((60 - minute)/15 == 1)
                    sb.append("quarter to " + numNames[hour + 1]);
                else
                    sb.append(numNames[(60 - minute)/15] + " quarters to " + numNames[hour + 1]);
                return sb.toString();
            }else if((60 - minute) < 20) {
                sb.append(numNames[60 - minute] + " minutes to " + numNames[hour + 1]);
                return sb.toString();
            } else if((60 - minute)%10 == 0){
                sb.append(tenNames[(60 - minute)/10] + " minutes to " + numNames[hour + 1]);
                return sb.toString();
            }else{
                sb.append(tenNames[Character.getNumericValue(Integer.toString(60 - minute).charAt(0))] + " " +numNames[Character.getNumericValue(Integer.toString(60 - minute).charAt(1))] + " minutes ");
                sb.append("to " + numNames[hour + 1]);
                return sb.toString();
            }
        }
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        while(true) {
            int H = sc.nextInt();
            int M = sc.nextInt();
            System.out.println(convertWords(H, M));
        }
    }
}
