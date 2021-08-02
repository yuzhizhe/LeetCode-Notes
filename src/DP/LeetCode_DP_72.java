package DP;

import java.util.HashMap;

public class LeetCode_DP_72 {
    public static int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        int[][] dp = new int[length1+1][length2+1];
        for (int i = 1; i <= length1; i++){
            dp[i][0] = dp[i-1][0] + 1;
        }
        for(int j = 1; j <= length2; j++){
            dp[0][j] = dp[0][j-1] + 1;
        }
        for (int i = 1; i <= length1; i++){
            for(int j = 1; j <= length2; j++){
                // 如果 word1[i] 与 word2[j] 相等。第 i 个字符对应下标是 i-1
                if (word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                }
            }
        }
        return dp[length1][length2];
    }

    public static int minDistance1(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        int[] dp = new int[length2+1];
        for (int i = 0; i <= length2; i++){
            dp[i] = i;
        }
        for (int i = 1; i <= length1; i++){
            int temp = dp[0];
            // 相当于初始化
            dp[0] = i;
            for(int j = 1; j <= length2; j++){
                // pre 相当于之前的 dp[i-1][j-1]
                int pre = temp;
                temp = dp[j];
                // 如果 word1[i] 与 word2[j] 相等。第 i 个字符对应下标是 i-1
                if (word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[j] = pre;
                }else {
                    dp[j] = Math.min(Math.min(dp[j - 1], pre), dp[j]) + 1;
                }
            }
        }
        return dp[length2];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("horse","ros"));
        System.out.println(minDistance1("horse","ros"));
    }
}
