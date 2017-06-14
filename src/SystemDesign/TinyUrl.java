package SystemDesign;

import java.util.Scanner;

/**
 * Created by z001ktb on 4/14/17.
 */
public class TinyUrl {
    public static String idToShortenUrl(int id) {
        String codes = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder shortenUrl = new StringBuilder();
        int remain = id;
        int index = 0;
        while(remain != 0 && index <= 5){
            int divisor = (int)Math.pow(62,5-index);
            int n = remain / divisor;
            if(n != 0) shortenUrl.append(codes.charAt(n));
            remain %= divisor;
            index++;
        }
        return shortenUrl.toString();
    }

    public static int shortenUrlToId(String url) {
        if(url.length() == 0) return -1;
        int id = 0;
        int index = 0;
        for(int i = url.length() - 1; i >= 0; i--){
            if(url.charAt(i) >= '0' && url.charAt(i) <= '9'){
                id += Character.getNumericValue(url.charAt(i)) * Math.pow(62,index++);
            }else if(url.charAt(i) >= 'a' && url.charAt(i) <= 'z'){
                id += (10 + url.charAt(i) - 'a') * Math.pow(62,index++);
            }else{
                id += (36 + url.charAt(i) - 'A') * Math.pow(62,index++);
            }
        }
        return id;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int id = 1;
//        while(true){
//            String url = sc.next();
            System.out.println(idToShortenUrl(2147434768));
            System.out.println(shortenUrlToId("2lkpSE"));
//            id++;
//        }
    }
}
