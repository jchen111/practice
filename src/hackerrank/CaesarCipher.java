package hackerrank;

import java.util.Scanner;

/**
 * Created by z001ktb on 5/23/16.
 */
public class CaesarCipher {
    public static String encryption(String s, int k, int n) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            int ascii = (int)s.charAt(i);
            k = k % 26;
            if(((ascii >= 65 && ascii <=90) || (ascii >= 97 && ascii <=122)) && k != 0) {
                int encrypt_ascii = 0;
                if(ascii >= 65 && ascii <=90){
                    if(ascii+k > 90){
                        encrypt_ascii = ascii+k-90+65-1;
                    }else {
                        encrypt_ascii = ascii+k;
                    }
                }else {
                    if(ascii+k > 122){
                        encrypt_ascii = ascii+k-122+97-1;
                    }else {
                        encrypt_ascii = ascii+k;
                    }
                }
                sb.append((char)encrypt_ascii);
            }else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        int k = in.nextInt();
        System.out.println(encryption(s,k,n));
    }
}
