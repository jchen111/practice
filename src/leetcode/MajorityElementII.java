package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by z001ktb on 10/23/16.
 */
public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        if(nums.length == 0) return list;
        int number1 = nums[0];
        int number2 = nums[0];
        int counter1 = 0;
        int counter2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == number1){
                counter1++;
            }
            else if(nums[i] == number2){
                counter2++;
            }else if(counter1 == 0){
                number1 = nums[i];
                counter1 = 1;
            }else if(counter2 == 0){
                number2 = nums[i];
                counter2 = 1;
            }else{
                counter1--;
                counter2--;
            }
        }
        counter1 = 0;
        counter2 = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == number1) counter1++;
            else if(nums[i] == number2) counter2++;
        }
        if(counter1 > nums.length/3) list.add(number1);
        if(counter2 > nums.length/3) list.add(number2);
        return list;
    }
}
