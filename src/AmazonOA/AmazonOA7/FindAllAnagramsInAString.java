package AmazonOA.AmazonOA7;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by z001ktb on 5/17/17.
 */
public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<Integer>();
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        int[] counts = new int[256];
        int count = pp.length;
        for(int i = 0; i < pp.length; i++){
            counts[pp[i]]++;
        }

        int left = 0;
        int right = 0;
        while(right < ss.length){
            if(counts[ss[right]] > 0){
                count--;
            }
            counts[ss[right]]--; //if char doesn't exist in p, mark it negative
            while(count == 0){
                if(right - left + 1 == pp.length){
                    result.add(left);
                }
                counts[ss[left]]++; // recover left char count
                if(counts[ss[left]] > 0){
                    count++;
                }
                left++;
            }
            right++;
        }
        return result;
    }
}
