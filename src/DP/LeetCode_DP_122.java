package DP;

public class LeetCode_DP_122 {

    public static int maxProfit(int[] prices) {
        int length = prices.length;
        if (length < 2){
            return 0;
        }
        int[][] dp = new int[length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < length; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[length-1][0];
    }

    public static int maxProfit1(int[] prices) {
        int length = prices.length;
        if (length < 2){
            return 0;
        }
        int pre_0 = 0;
        int pre_1 = -prices[0];
        int cur_0 = 0, cur_1 = 0;
        for (int i = 1; i < length; i++){
            cur_0 = Math.max(pre_0, pre_1 + prices[i]);
            cur_1 = Math.max(pre_1, pre_0 - prices[i]);
            pre_0 = cur_0;
            pre_1 = cur_1;
        }
        return pre_0;
    }

    public static void main(String[] args) {
        int[] S = {7,1,5,3,6,4};
        System.out.println(maxProfit1(S));
    }
}
