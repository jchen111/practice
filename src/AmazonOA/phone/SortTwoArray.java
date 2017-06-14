package AmazonOA.phone;

import java.util.Arrays;

/**
 * Created by z001ktb on 5/24/17.
 */
public class SortTwoArray {
    public static void main (String[] args) throws java.lang.Exception
    {
        int[] A = {1, 4, 5, 9};
        int[] B = {2, 6, 8};
        sort(A,B);

        for(int i = 0; i < A.length; i++){
            System.out.print(A[i] + " ");
        }
        System.out.println();
        for(int i = 0; i < B.length; i++){
            System.out.print(B[i] + " ");
        }
    }

    public static void sort(int[] A, int[] B) {
        if(A.length == 0) {
            A = new int[B.length];
            for(int i = 0; i < B.length; i++){
                A[i] = B[i];
            }
            B = new int[]{};
            return;
        }
        if(B.length == 0) return;

        int aindex = 0;
        int bindex = 0;
        while(aindex + bindex < A.length) {
            if(A[aindex] < B[bindex]) aindex++;
            else bindex++;
        }
        bindex--;
        while(bindex >= 0) {
            swap(A, B, aindex++, bindex--);
        }

        Arrays.sort(A);
        Arrays.sort(B);
    }

    public static void swap(int[] A, int[] B, int aindex, int bindex) {
        int tmp = A[aindex];
        A[aindex] = B[bindex];
        B[bindex] = tmp;
    }
}
