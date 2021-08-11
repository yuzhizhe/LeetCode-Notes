package DP;
public class LeetCode_DP_1143 {

    /**
     * 动态规划版本
     * 时间复杂度：O(n*m)
     * 空间复杂度：O(n*m)
     * @param text1
     * @param text2
     * @return
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        int length_1 = text1.length();
        int length_2 = text2.length();
        int[][] dp = new int[length_1 + 1][ length_2 + 1];
        for (int i = 1; i <= length_1; i++){
            char I = text1.charAt(i-1);
            for (int j = 1; j <= length_2; j++){
                char J = text2.charAt(j-1);
                if (I == J){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[length_1][length_2];
    }

    /**
     * 动态规划版本--优化版
     * 时间复杂度：O(n*m)
     * 空间复杂度：O(n)
     * @param text1
     * @param text2
     * @return
     */
    public static int longestCommonSubsequence1(String text1, String text2) {
        int length_1 = text1.length();
        int length_2 = text2.length();
        int pre = 0;
        int[] dp = new int[ length_2 + 1];
        for (int i = 1; i <= length_1; i++){
            char I = text1.charAt(i-1);
            pre = 0;
            for (int j = 1; j <= length_2; j++){
                char J = text2.charAt(j-1);
                if (I == J){
                    dp[j] = dp[j-1] + 1;
                }else{
                    dp[j] = Math.max(pre, dp[j]);
                }
                pre = dp[j];
            }
        }
        return dp[length_2];
    }

    public static void main(String[] args) {
        int[] nums = {4,2,0,3,2,5};
        System.out.println(longestCommonSubsequence1("abcba", "abcbcba"));
    }
}
