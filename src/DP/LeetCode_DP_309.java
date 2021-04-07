package DP;

public class LeetCode_DP_309 {

    public static int maxProfit(int[] prices) {
        int length = prices.length;
        if (length == 0){
            return 0;
        }
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE, dp_pre_0 = 0;
        for(int i = 0; i < length; i++){
            int index = dp_i_0;
            dp_i_0 = Math.max(dp_i_0,dp_i_1+prices[i]);
            dp_i_1 = Math.max(dp_i_1,dp_pre_0-prices[i]);
            dp_pre_0 = index;
        }
        return dp_i_0;
    }

    public static void main(String[] args) {
        int[] S = {1,2,3,0,2};
        int a = "hello".hashCode();
        int b = "hello".hashCode();
        System.out.println(a);
    }
}
