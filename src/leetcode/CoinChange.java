package leetcode;

import java.util.Arrays;

public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        if(coins.length == 0 || amount == 0) return 0;
        Arrays.sort(coins);
        int i = coins.length - 1;
        int count = 0;
        while(amount > 0 && i >= 0) {
            if(amount >= coins[i]) {
                count += amount / coins[i];
                amount = amount % coins[i];
            }
            i--;
        }
        if(amount != 0) return -1;
        return count;
    }

    public static void main(String[] args) {
        int[] coins = {83,186,408,419};
        int amount = 6249;
        System.out.println(coinChange(coins, amount));
    }
}
