package google;

import java.util.Scanner;

/**
 * Created by jiaqichen on 11/7/16.
 */
//O(2logn)
public class FindLargestAndSmallest {
    public static int[] findLargestAndSmallest(int[] array){
        int[] res = new int[2];
        res[0] = Math.min(Math.min(array[0],array[array.length-1]),findSmallest(array,0,array.length-1));
        res[1] = Math.max(Math.max(array[0],array[array.length-1]),findLargest(array,0,array.length-1));
        return res;
    }

    //assume ascending then descending
    //O(logn)
    public static int findLargest(int[] array, int left, int right){
        if(left == right) return array[left];
        if(right - left == 1) return Math.max(array[left],array[right]);
        int mid = left + (right - left)/2;
        if(array[mid] > array[mid-1] && array[mid] > array[mid+1]){
            return array[mid];
        }

        if(array[mid] < array[mid+1]){
            return findLargest(array,mid+1,right);
        }else {
            return findLargest(array,left,mid-1);
        }
    }

    //assume descending then ascending
    //O(logn)
    public static int findSmallest(int[] array, int left, int right){
        if(left == right) return array[0];
        if(right - left == 1) return Math.min(array[left],array[right]);
        int mid = left + (right - left)/2;
        if(array[mid] < array[mid-1] && array[mid] < array[mid+1]){
            return array[mid];
        }

        if(array[mid] < array[mid+1]){
            return findLargest(array,left,mid-1);
        }else {
            return findLargest(array,mid+1,right);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] array = new int[N];
        for(int i = 0; i < N; i++){
            array[i] = sc.nextInt();
        }
        int[] res = findLargestAndSmallest(array);
        System.out.println(res[0] + " " + res[1]);
    }


}
