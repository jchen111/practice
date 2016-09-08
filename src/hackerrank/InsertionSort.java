package hackerrank;

import java.util.Scanner;

/**
 * Created by jacky on 9/5/16.
 */
public class InsertionSort {


    public static void insertIntoSorted(int[] ar) {
        // Fill up this function
        int index = ar.length-1;
        int val = ar[index];
        while(index > 0){
            for(int i = ar.length-2; i >=0; i--) {
                if(ar[i] >= val) {
                    ar[i+1] = ar[i];
                    printArray(ar);

                }else if(ar[i] < val && ar[i+1] > val){
                    ar[i+1] = val;
                    printArray(ar);
                }
            }
            if(ar[0] >= val){
                ar[0] = val;
                printArray(ar);
            }
            index--;
            val = ar[ar.length-1];
        }
    }

    public static void insertionSortPart2(int[] ar)
    {
        // Fill up the code for the required logic here
        // Manipulate the array as required
        // The code for Input/Output is already provided
        for(int i = 1; i < ar.length; i++){
            for(int j = 0; j < i; j++){
                if(ar[i] <= ar[j]){
                    int tmp = ar[i];
                    ar[i] = ar[j];
                    ar[j] = tmp;
                }
            }
            printArray(ar);
        }
    }

    public static int countShifts(int[] ar) {
        // Fill up the code for the required logic here
        // Manipulate the array as required
        // The code for Input/Output is already provided
        int count = 0;
        for(int i = 1; i < ar.length; i++){
            int j = i -1;
            int index = i;
            while(j >=0){
                if(ar[j] > ar[index]){
                    int tmp = ar[index];
                    ar[index] = ar[j];
                    ar[j] = tmp;
                    count++;
                    index = j;
                }
                j--;
            }
        }
//        printArray(ar);
        return count;
    }


    /* Tail starts here */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for(int i=0;i<s;i++){
            ar[i]=in.nextInt();
        }
//        insertIntoSorted(ar);
//        insertionSortPart2(ar);
        System.out.println(countShifts(ar));
    }


    private static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }
}
