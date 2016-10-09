package leetcode;

import java.util.*;

/**
 * Created by jiaqichen on 10/7/16.
 */
public class LargestNumber {


    public static class LargetNumberComparator implements Comparator<String> {

        @Override
        public int compare(String s1, String s2) {
            String str1 = s1 + s2;
            String str2 = s2 + s1;
            return str2.compareTo(str1);
        }
    }


    public static String largestNumber(int[] nums) {
        PriorityQueue<String> queue = new PriorityQueue<String>(new LargetNumberComparator());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < nums.length; i++){
            queue.add(String.valueOf(nums[i]));
        }
        boolean zero_f = true;
        while(!queue.isEmpty()){
            String tmp = queue.poll();
            if(!tmp.equals("0")) zero_f = false;
            sb.append(tmp);
        }
        if(zero_f) return "0";
        return sb.toString();
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arry = new int[N];
        for(int i = 0; i < N; i++){
            arry[i] = sc.nextInt();
        }
        System.out.println(largestNumber(arry));
    }
}
