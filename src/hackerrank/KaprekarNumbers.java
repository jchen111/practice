package hackerrank;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TimeZone;

/**
 * Created by z001ktb on 6/2/16.
 */
public class KaprekarNumbers {

    public static LinkedList<Long> getKaprekar(long begin, long end) {
        LinkedList<Long> res = new LinkedList<Long>();
        for(long i = begin; i <= end; i++) {
            if(i == 1) {
                res.add(i);
                continue;
            }
            String current = String.valueOf(i * i);
            if(i * i > 10) {
                int length = current.length();
                if(length % 2 != 0) {
                    if (Integer.parseInt(current.substring(length / 2)) + Integer.parseInt(current.substring(0, length / 2)) == i) {
                        res.add(i);
                    }
                }else {
                    if (Integer.parseInt(current.substring(length / 2)) + Integer.parseInt(current.substring(0, length / 2)) == i) {
                        res.add(i);
                    }
//                    else {
//                        int index = length/2 -1;
//                        while(index-1 > 0 && current.charAt(index) == '0') {
//                            if(Integer.parseInt(current.substring(0,index)) + Integer.parseInt(current.substring(index)) == i){
//                                res.add(i);
//                            }
//                            index--;
//                        }
//                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
//        Integer begin = sc.nextInt();
//        Integer end = sc.nextInt();
//        LinkedList<Long> res = getKaprekar(begin.longValue(),end.longValue());
//        if(res.isEmpty()) {
//            System.out.println("INVALID RANGE");
//        }else {
//            for(int i = 0; i < res.size(); i++) {
//                System.out.print(res.get(i) + " ");
//            }
//        }
//        2016-06-05T00:08:36.796-0500
        String timestamp = "1464965934940";
        Date date = new Date(Long.parseLong(timestamp));
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formatted = format.format(date);
        System.out.println(formatted); //2016-06-03 09:58:54
    }
}
