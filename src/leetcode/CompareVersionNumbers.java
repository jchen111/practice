package leetcode;

import java.util.Scanner;

/**
 * Created by jiaqichen on 10/11/16.
 */
public class CompareVersionNumbers {
    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0;
        while (i < v1.length && i < v2.length){
            if(Integer.parseInt(v1[i]) > Integer.parseInt(v2[i])){
                return 1;
            }else if(Integer.parseInt(v1[i]) < Integer.parseInt(v2[i])){
                return -1;
            }else{
                i++;
            }
        }

        while(i < v1.length){
            if(Integer.parseInt(v1[i]) != 0)
                return 1;
            i++;
        }

        while(i < v2.length){
            if(Integer.parseInt(v2[i]) != 0)
                return -1;
            i++;
        }

        return 0;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(compareVersion(s1,s2));
    }
}
