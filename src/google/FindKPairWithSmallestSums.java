package google;

import java.util.*;

/**
 * Created by jiaqichen on 11/17/16.
 */
public class FindKPairWithSmallestSums {
    public static List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new ArrayList<int[]>();
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(k,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]+o1[1] > o2[0] + o2[1]){
                    return 1;
                }else if(o1[0]+o1[1] < o2[0] + o2[1]){
                    return -1;
                }else{
                    return 0;
                }
            }
        });

        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                queue.add(new int[]{nums1[i],nums2[j]});
            }
        }

        while(k > 0){
            result.add(queue.poll());
            k--;
        }
        return result;
    }

    public static void main(String[] args){
        int[] nums1 = {1,7,11};
        int[] nums2 = {2,4,6};
        kSmallestPairs(nums1,nums2,3);
    }
}
