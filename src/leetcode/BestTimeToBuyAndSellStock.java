package leetcode;

import java.util.Scanner;

public class BestTimeToBuyAndSellStock {
//    public static int maxProfit(int[] prices) {
//    	if(prices.length==0) return 0;
//        int max = prices[0];
//        int maxindex = 0;
//        int minindex = 0;
//        int min = prices[0];
//        int profit = max-min;
//        for(int i=1;i<prices.length;i++){
//        	if(prices[i]>max  && i>minindex){
//        		max = prices[i];
//        		maxindex = i;
//        	}
//        	if(prices[i]<min){
//        		max = prices[i];
//        		min = prices[i];
//        		minindex = i;
//        		maxindex = i;
//        	}
//        	if(max-min>profit){
//        		profit = max-min;
//        	}
//        }
//        return profit;
//    }
	public static int maxProfit(int[] prices) {
		if(prices.length == 0) return 0;
		int min = prices[0];
		int max = prices[0];
		int profit = max - min;
		for(int i = 0; i < prices.length; i++){
			if(prices[i] < min){
				min = prices[i];
				max = prices[i];
			}
			if(prices[i] > max){
				max = prices[i];
				profit = Math.max(profit,max-min);
			}
		}
		return profit;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] prices = {{7,1,5,3,6,4},{10,20,30,20},
						  {10,20,30,5,40},
						  {10,20,30,50,40},
						  {1,40,2,60},
						  {5,40,2,60}};
		Scanner sc = new Scanner(System.in);
		sc.next();
		maxProfit(prices[0]);
		for(int i=0;i<prices.length;i++){
			System.out.println(maxProfit(prices[i]));
		}
	}

}
