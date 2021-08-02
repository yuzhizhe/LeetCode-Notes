package DP;
public class LeetCode_DP_338 {
    public static int[] countBits(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++){
            if (i % 2 == 0){
                dp[i] = dp[i/2];
            }else{
                dp[i] = dp[i-1] + 1;
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        int[] S = countBits(2);
        for (int i : S){
            System.out.println(i);
        }
    }
}
