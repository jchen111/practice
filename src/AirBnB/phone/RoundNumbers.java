package AirBnB.phone;

import java.util.Arrays;

/**
 * Created by z001ktb
 */
public class RoundNumbers {

    static class Number {
        double val;
        double frac;
        int index;

        Number(double val, int index) {
            this.val = val;
            this.frac = val - Math.floor(val);
            this.index = index;
        }
    }

    /** Solution:
            * - compute roundOfSum(we want this) and sumOfRounds
            * - check the difference between them
    *    1. roundOfSum > sumOfRounds
    *      - means sumOfRounds should be bigger，we should get the ceil of some number instead of getting the floor of them,
     *      how do we decide which number should get ceil instead of floor?
     *      we sort all numbers in decreasing order by their fraction, for the numbers whose frac < 0.5
     *      we get ceil from top X of them, here X = roundOfSum - sumOfRounds
     *      the rest of the array we dont change it.
     *
     *      应该把有些原本取floor(小数部分<0.5)的取ceil，差X就要改X个
    *      - 按照小数部分从大到小排序，取小于0.5的X个用ceil，其他正常round
     *
     *
    *    2. roundOfSum < sumOfRounds
     *    means sumOfRounds should be less, we should get the floor of some number instead of getting the ceiling of them,
     *    how do we decide which number should get floor instead of ceiling?
     *    we sort all numbers in increasing order by their fraction, for the numbers whose fac >= 0.5
     *    we get floor from smaller X of them, here X = sumOfRounds - roundOfSum
     *    the rest of the array we dont change
     *
     *
    *      - 说明我们sumOfRounds大了，应该把有些原本取ceil(小数部分>=0.5)的取floor，差X就要改X个
    *      - 按照小数部分从小到大排序，取大于等于0.5的X个用floor，其他正常round
     *
     *
    *    3. roundOfSum = sumOfRounds
     *      - dont need to do anything
     *
     **/

    public static int[] round(double[] prices) {
        if (prices == null || prices.length == 0) {
            return new int[0];
        }

        int[] res = new int[prices.length];

        double sum = 0;
        int sumOfRounds = 0;
        Number[] numbers = new Number[prices.length];
        for (int i = 0; i < prices.length; i++) {
            numbers[i] = new Number(prices[i], i);
            sum += prices[i];
            sumOfRounds += (int)Math.round(prices[i]);
            res[i] = (int)Math.round(prices[i]);
        }
        int roundOfSum = (int)Math.round(sum); // round of sum is what we want to match

        if (roundOfSum == sumOfRounds) {
            return res;
        } else if (roundOfSum > sumOfRounds) {
            Arrays.sort(numbers, (a, b) -> (Double.compare(b.frac, a.frac)));
            int count = roundOfSum - sumOfRounds;
            for (int i = 0; i < prices.length; i++) {
                Number num = numbers[i];
                if (num.frac < 0.5 && count > 0) {
                    res[num.index] = (int)Math.ceil(num.val);
                    count--;
                } else {
                    res[num.index] = (int)Math.round(num.val);
                }
            }
        } else {
            Arrays.sort(numbers, (a, b) -> (Double.compare(a.frac, b.frac)));
            int count = sumOfRounds - roundOfSum;
            for (int i = 0; i < prices.length; i++) {
                Number num = numbers[i];
                if (num.frac >= 0.5 && count > 0) {
                    res[num.index] = (int)Math.floor(num.val);
                    count--;
                } else {
                    res[num.index] = (int)Math.round(num.val);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        double[] prices1 = {1.2, 2.3, 3.4};
        int[] res1 = round(prices1);
        for (int r : res1) {
          System.out.print(r + " ");
        }
        System.out.println();

        double[] prices2 = {2.5, 2.3, 3.1, 6.5};
        int[] res2 = round(prices2);
        for (int r : res2) {
          System.out.print(r + " ");
        }
        System.out.println();

        double[] prices3 = {2.9, 2.3, 1.4, 3, 6};
        int[] res3 = round(prices3);
        for (int r : res3) {
          System.out.print(r + " ");
        }
        System.out.println();

        double[] prices4 = {-0.4,1.3,1.3,1.3,1.3,1.3,1.3,1.3,1.3,1.3,1.3};
        int[] res4 = round(prices4);
        for (int r : res4) {
          System.out.print(r + " ");
        }
        System.out.println();
    }
}
