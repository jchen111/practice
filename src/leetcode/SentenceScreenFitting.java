package leetcode;

import java.util.Scanner;

/**
 * Created by jiaqichen on 10/29/16.
 */
public class SentenceScreenFitting {
    public static int wordsTyping(String[] sentence, int rows, int cols) {
        int id = 0;
        int len = sentence.length;
        int count = 0;
        int sum = 0;
        for(int i = 0; i < len; i++){
            sum += sentence[i].length();
        }

        for(int i = 0; i < rows; i++){
            int remainCols = cols;
            while(remainCols > 0){
                if(remainCols >= sentence[id].length()){
                    remainCols -= sentence[id].length();
                    id++;
                    if(id >= len){
                        count += 1 + remainCols/(sum+len);
                        remainCols = remainCols%(sum+len);
                        id = 0;
                        remainCols--;
                    }else{
                        if(remainCols > 0){
                            remainCols--;
                        }
                    }
                }else{
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] array = new String[N];
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        for(int i = 0; i < N; i++){
            array[i] = sc.next();
        }
        wordsTyping(array,rows,cols);
    }
}
