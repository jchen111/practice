package leetcode;
import java.util.Scanner;

/**
 * Created by jiaqichen on 9/30/16.
 */
public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int flag = 1;
        int[] toReturn = new int[digits.length + 1];
        for(int i = digits.length - 1; i >=0; i--){
           if(digits[i] + flag > 9){
                digits[i] = 0;
           }else{
               digits[i] += flag;
               return digits;
           }
           toReturn[i+1] = digits[i];
        }
        toReturn[0] = 1;
        return toReturn;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] array = new int[N];
        for(int i = 0; i < N; i++){
            array[i] = sc.nextInt();
        }

        int[] res = plusOne(array);
        for(int i = 0; i < res.length; i++) {
            System.out.print(res[i]);
        }
    }
}
