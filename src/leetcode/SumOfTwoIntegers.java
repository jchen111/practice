package leetcode;

/**
 * Created by jiaqichen on 10/7/16.
 */
public class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        int carry = a & b;
        int res = a ^ b;
        while(carry != 0){
            int shiftedcarry = carry << 1;
            carry = res & shiftedcarry;
            res = res ^ shiftedcarry;
        }
        return res;
    }
}
