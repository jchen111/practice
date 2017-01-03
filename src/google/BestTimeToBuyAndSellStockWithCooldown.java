package google;

import java.util.Scanner;

/**
 * Created by jiaqichen on 11/23/16.
 */
public class BestTimeToBuyAndSellStockWithCooldown {
    public static int maxProfit(int[] prices) {
        return helper(0, prices, 0, 0);
    }

    public static int helper(int profit, int[] prices, int day, int stock) {
        if(day >= prices.length){
            return Math.max(0,profit);
        }else if(day == prices.length - 1){
            return profit + stock*prices[day];
        }
        else if(day == prices.length - 2){
            if(prices[day] < prices[day+1]) {
                profit = Math.max(profit + stock*prices[day+1], profit + (prices[day+1] - prices[day]));
            }
            return profit;
        }else{
            if(prices[day+1] >= prices[day]){
                int low = prices[day];
                day++;
                int p = profit;
                while(day < prices.length && prices[day] >= low){
                    profit = Math.max(profit + stock*prices[day], helper(p + prices[day] - low, prices, day+2, stock));
                    day++;
                }
                return profit;
            }else{
                int high = prices[day];
                day++;
                while(day < prices.length && prices[day] < high){
                    high = prices[day];
                    day++;
                }
                if(day < prices.length)
                    return Math.max(helper(profit-prices[day-1], prices, day, stock+1),helper(profit+prices[day]-prices[day-1], prices, day+2, stock));
                else
                    return helper(profit-prices[day-1], prices, day, stock+1);
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] prices = new int[N];
        for(int i = 0; i < N; i++){
            prices[i] = sc.nextInt();
        }
        System.out.println(maxProfit(prices));
    }
}
