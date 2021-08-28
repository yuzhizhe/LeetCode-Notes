package DP;

import java.util.Arrays;

public class LeetCode_DP_300 {

    /**
     * 动态规划版本
     * 时间复杂度：O(n*n)
     * 空间复杂度：O(n)
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int sum = 0;
        Arrays.fill(dp, 1);
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if (nums[i]>nums[j]){
                    dp[i] = Math.max(dp[j]+1 , dp[i]);
                }
            }
            sum = Math.max(sum, dp[i]);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,3,2,3};
        System.out.println(lengthOfLIS(nums));
    }
}
