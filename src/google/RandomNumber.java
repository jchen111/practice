package google;

import java.util.Random;

/**
 * Created by jiaqichen on 11/11/16.
 */
public class RandomNumber {
    public static int genRandom(int lower, int upper){
        return lower + helper(upper-lower);
    }

    //O(constant)
    public static int helper(int upper){
        int mask = 1 << 31;
        int num = upper;
        int power = 0;
        for(int i = 31; i >=0; i--){ //O(32)
            if((mask&num) != 0){
                power = i;
                break;
            }
            mask = mask >>> 1;
        }

        mask = 0;
        for(int i = 0; i <=power; i++){ //O(32)
            if(new Random().nextInt(2) == 1){
                mask = mask^1;
            }
            mask = mask << 1;
        }
        if(mask > upper) return helper(upper);
        return mask;
    }

    public static void main(String[] args){
        System.out.println(genRandom(0,100));
    }

}
