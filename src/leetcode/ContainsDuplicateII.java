package leetcode;

import java.util.HashMap;

/**
 * Created by jiaqichen on 10/11/16.
 */
public class ContainsDuplicateII {
    //O(nk)
    public boolean containsNearbyDuplicateII(int[] nums, int k) {
        if(nums.length == 0 || k == 0) return false;
        int i = 0;
        int j = i + 1;
        while(i < nums.length){
            while(j < nums.length && j <= i + k){
                if(nums[i] == nums[j]) return true;
                j++;
            }
            i++;
            j = i + 1;
        }
        return false;
    }

    //O(n)
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length == 0 || k == 0) return false;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],i);
            }else{
                if(i - map.get(nums[i]) <= k) return true;
                map.put(nums[i],i);
            }
        }
        return false;
    }
}
