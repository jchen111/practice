package leetcode;

import java.util.Scanner;

/**
 * Created by jiaqichen on 10/27/16.
 */
public class ValidateUTF8 {
    public static boolean validUtf8(int[] data) {
        int len = data.length;
        if(len == 0) return false;
        int i = 0;
        int count = 0;
        while(i < len){
            while(count > 0){
                if(i >= len) return false;
                int check = data[i] >> 6;
                if(check != 2) return false;
                count--;
                i++;
            }
            if(i < len && (data[i]&128) == 0){
                i++;
            }else if(i < len && (data[i]&128) == 128){
                data[i] = data[i] << 1;
                if((data[i]&128) != 128) return false;
                while((data[i]&128) == 128){
                    count++;
                    data[i] = data[i] << 1;
                }
                if(count > 3) return false;
                i++;
            }
        }
        if(count != 0) return false;
        return true;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(validUtf8(arr));
    }
}
