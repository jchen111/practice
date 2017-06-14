package facebook;

import java.util.Scanner;

/**
 * Created by z001ktb on 6/6/17.
 */
public class FindTheSecondFrequentElementInName {

    public static Character find(String str) {
        int[] count = new int[256];
        int max = 0, second = 0;
        for(int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;
        }

        char res = '#';

        for(int i = 0; i < count.length; i++) {
                if(count[i] > max){
                    second = max;
                    max = count[i];
                }else if(count[i] > second && count[i] != max){
                    second = count[i];
                    res = (char) i;
                }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println(find(sc.next()));
        }
    }
}
