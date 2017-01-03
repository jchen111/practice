package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Random;

/**
 * Created by jiaqichen on 12/15/16.
 */
public class RandomGet {
    static class RandomizedSet {

        ArrayList<Long> array;
        HashMap<Long, Integer> map;
        Random rand;
        /** Initialize your data structure here. */
        public RandomizedSet() {
            rand = new Random();
            array = new ArrayList<Long>();
            map = new HashMap<Long, Integer>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if(map.containsKey((long)val)){
                return false;
            }else{
                array.add((long)val);
                map.put((long)val,array.size()-1);
                return true;
            }
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if(map.containsKey((long)val)){
                array.set(map.get((long)val), Long.MIN_VALUE);
                map.remove((long)val);
                return true;
            }else{
                return false;
            }
        }

        /** Get a random element from the set. */
        public int getRandom() {
            int max = array.size();
            int randNum = rand.nextInt(max);
            while(array.get(randNum) == Long.MIN_VALUE){
                randNum = rand.nextInt(max);
            }
            return array.get(randNum).intValue();
        }
    }

    public static void main(String[] args) {
        RandomizedSet set = new RandomizedSet();
        System.out.println(set.insert(1));
        System.out.println(set.insert(2));
        System.out.println(set.insert(3));
        System.out.println(set.insert(4));
        while(set.getRandom() != 1) {
            System.out.println(set.getRandom());
        }
    }
}
