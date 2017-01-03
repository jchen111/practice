package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jiaqichen on 11/14/16.
 */
public class BinaryWatch {
    static List<String> result;
    public static List<String> readBinaryWatch(int num) {
        result = new ArrayList<String>();
        helper(num,0,0);
        return result;
    }

    public static void helper(int num, int hour, int minute) {
        if(num == 0){
            StringBuilder sb = new StringBuilder();
            sb.append(""+hour);
            sb.append(":");
            if(minute < 10) sb.append("0");
            sb.append(""+minute);
            result.add(sb.toString());
            return;
        }
        int mask = 1;
        int h = hour;
        for(int i = 0; i < 3; i++){
            if((mask&h) == 0){
                h = mask^h;
                helper(num-1,h,minute);
            }
            h = hour;
            mask <<= 1;
        }
        mask = 1;
        int m = minute;
        for(int i = 0; i < 5; i++){
            if((mask&m) == 0){
                m = mask^m;
                helper(num-1,hour,m);
            }
            m = minute;
            mask <<= 1;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        readBinaryWatch(num);
    }
}
