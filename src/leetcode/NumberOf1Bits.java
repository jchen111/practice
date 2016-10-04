package leetcode;

/**
 * Created by jiaqichen on 10/3/16.
 */
public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int mask = 1;
        int bits = 0;
        for(int i = 0; i < 32; i++){
            if((n & mask) != 0){
                bits++;
            }
            mask = mask << 1;
        }
        return bits;
    }
}
