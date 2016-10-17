package leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jiaqichen on 10/12/16.
 */
public class SummaryRanges {
    public static List<String> summaryRanges(int[] nums) {
        List<String> list = new LinkedList<String>();
        if(nums.length == 0) return list;
        int i = 0;
        int ii = 0;
        int j = i+1;
        StringBuilder sb = new StringBuilder();
        while(j < nums.length){
            if(nums[j] - nums[i] == 1){
                i = j;
                j++;
                continue;
            }else{
                if(ii != i)
                    sb.append(nums[ii] + "->" + nums[i]);
                else
                    sb.append(nums[ii]);
                ii = j;
                list.add(sb.toString());
                sb = new StringBuilder();
                i = j;
            }
            j++;
        }
        if(ii != i)
            sb.append(nums[ii] + "->" + nums[i]);
        else
            sb.append(nums[ii]);
        list.add(sb.toString());
        return list;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for(int i = 0; i < N; i++){
            nums[i] = sc.nextInt();
        }

        System.out.println(summaryRanges(nums));
    }
}
