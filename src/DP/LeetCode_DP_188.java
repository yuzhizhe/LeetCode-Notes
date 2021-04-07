package DP;

public class LeetCode_DP_188 {

    public static int maxProfit(int[] prices , int t) {
        int length = prices.length;
        if (length == 0){
            return 0;
        }
        int mK = t;
        int[][][] dp = new int[length][mK+1][2];
        for(int i = 0; i < length; i++){
            for (int k = mK; k >= 1; k--){
                if (i-1 < 0){
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i-1][k][0],dp[i-1][k][1]+prices[i]);
                dp[i][k][1] = Math.max(dp[i-1][k][1],dp[i-1][k-1][0]-prices[i]);
            }
        }
        return dp[length-1][mK][0];
    }

    public static void main(String[] args) {
        int[] S = {3,3,5,0,0,3,1,4};
        System.out.println(maxProfit(S,2));
    }
}
