package DP;

import java.util.HashMap;

public class LeetCode_DP_121 {

    public static int maxProfit(int[] prices) {
        int res = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i ++){
            min = Math.min(min, prices[i]);
            res = Math.max(res, prices[i] - min);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] S = {7,6,4,3,1};
        System.out.println(maxProfit(S));
    }
}
