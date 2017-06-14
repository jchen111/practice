package facebook;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Scanner;

/**
 * Created by z001ktb on 6/12/17.
 */
public class ReplaceString {
    public static String replace(String str, String tar, String rep) {
        if(tar.isEmpty()) return str;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < str.length()) {
            if(str.charAt(i) == tar.charAt(0)){
                if(i + tar.length() <= str.length() && str.substring(i, i + tar.length()).equals(tar)){
                    sb.append(rep);
                    i =  i + tar.length();
                }else {
                    sb.append(str.charAt(i));
                    i++;
                }
            }else {
                sb.append(str.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            String str = sc.nextLine();
            String tar = sc.nextLine();
            String rep = sc.nextLine();
            System.out.println(replace(str, tar, rep));
        }

    }
}
