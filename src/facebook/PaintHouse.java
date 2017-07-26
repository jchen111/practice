package facebook;

/**
 * Created by z001ktb on 6/21/17.
 */
public class PaintHouse {
    /**
     * time O(n*3)
     * space O(n*3)
     */
    public static int minCost(int[][] costs) {
        int n = costs.length;
        if(n == 0) return 0;
        int[][] dp = new int[n][3]; //dp[i][0] means the cost to paint house i in red, dp[i][0] means the cost to paint house i in blue, dp[i][0] means the cost to paint house i in green
        dp[0][0] = costs[0][0];
        dp[0][1] = costs[0][1];
        dp[0][2] = costs[0][2];

        for(int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1]) + costs[i][2];
        }

        return Math.min(Math.min(dp[n-1][0],dp[n-1][1]),dp[n-1][2]);
    }

    public static void main(String[] args) {
//        int[][] costs = {{17,2,17},{16,16,5},{14,3,19}};
        int[][] costs = {{3,5,3},{6,17,6},{7,13,18},{9,10,18}};
        minCost(costs);
    }
}
