package hackerrank;

import java.util.Scanner;

/**
 * Created by z001ktb on 6/6/16.
 */
public class Encryption {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        str = str.replaceAll("\\s+","");
        int floor = (int) Math.floor(Math.sqrt((double)str.length()));
        int ceiling = (int) Math.ceil(Math.sqrt((double)str.length()));
        int row = 0;
        int column = 0;
        for(int i = floor; i<=ceiling; i++) {
            for(int j = floor; j<=ceiling; j++) {
                if(i*j >= str.length()){
                    row = i;
                    column = j;
                }
            }
        }
        char encryption[][] = new char[row][column];
        int k =0;
        for(int index = 0; index < str.length(); index++) {
            encryption[index/column][k] = str.charAt(index);
            if(k == ceiling-1){
                k = 0;
            }else {
                k++;
            }
        }

        for(int j=0; j<row; j++) {
            for(int i=0; i<column; i++) {
                if(encryption[i][j] != 0) {
                    System.out.print(encryption[i][j]);
                }else {
                    System.out.print("");
                }
            }
            System.out.print(" ");
        }
    }
}
