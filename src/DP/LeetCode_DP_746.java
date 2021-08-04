package DP;
public class LeetCode_DP_746 {
    /**
     * 动态规划版
     * 时间复杂度：O()
     * 时间复杂度：O()
     * @param cost
     * @return
     */
    public static int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        dp[0] = 0;
        dp[1] = Math.min(cost[0], cost[1]);
        for (int i = 2; i < cost.length; i ++){
            dp[i] = Math.min(dp[i-1] + cost[i], dp[i-2] + cost[i-1]);
        }
        return dp[cost.length-1];
    }

    /**
     * 优化版
     * @param cost
     * @return
     */
    public static int minCostClimbingStairs1(int[] cost) {
        int pre_1 = 0;
        int pre = Math.min(cost[0], cost[1]);
        for (int i = 2; i < cost.length; i ++){
            int S = Math.min(pre + cost[i], pre_1 + cost[i-1]);
            pre_1 = pre;
            pre = S;
        }
        return pre;
    }

    public static void main(String[] args) {
        int[] nums = {10, 15, 20};
        System.out.println(minCostClimbingStairs1(nums));
    }
}
