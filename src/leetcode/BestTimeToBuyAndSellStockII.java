package leetcode;

public class BestTimeToBuyAndSellStockII {
    public static int maxProfit(int[] prices) {
        if(prices.length ==0) return 0;
        int profit = 0;
        int i=0;
        for(i=0;i<prices.length-1;i++){
        	if(prices[i]<prices[i+1]){
        		profit+=(prices[i+1]-prices[i]);
        	}
        }
        return profit;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] prices = {{6,1,3,2,4,7},
						  {1,2,0,1},
				          {1,4,2},
					      {1,2,4},
					      {10,20,1,50}
						  };
		for(int i=0;i<prices.length;i++){
			System.out.println(maxProfit(prices[i]));
		}
	}
}
