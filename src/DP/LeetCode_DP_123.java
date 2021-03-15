package DP;

public class LeetCode_DP_123 {
    public static int maxProfit(int[] prices) {
        return helper1(prices,0);
    }

    public static int helper(int[] prices, int start) {
        if (start >= prices.length){
            return 0;
        }
        int res = 0;
        int min = prices[start];
        for (int i = start+1; i < prices.length; i ++){
            min = Math.min(min, prices[i]);
            res = Math.max(res, (prices[i] - min) + helper(prices,i+1));
        }
        return res;
    }

    public static int helper1(int[] prices, int start) {
        if (start >= prices.length){
            return 0;
        }
        int res = 0;
        //int min = prices[start];
        for (int i = start; i < prices.length; i ++){
            for (int j = start + 1; j < prices.length; j ++){
                res = Math.max(res, helper1(prices,j+1) + prices[j] - prices[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] S = {3,3,5,0,0,3,1,4};
        System.out.println(maxProfit(S));
    }
}
