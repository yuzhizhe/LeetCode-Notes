package DP;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class LeetCode_DP_5 {

    /**
     * 动态规划
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2){
            return s;
        }

        //定义dp
        boolean[][] dp = new boolean[len][len];

        //初始化dp
        for(int i = 0; i < len; i++){
            dp[i][i] = true;
        }

        //定义下标
        int maxLen = 1, start = 0;

        char[] charArray = s.toCharArray();
        for(int j = 1; j < len; j++){
            for(int i = 0; i < j; i++){
                if (charArray[i] != charArray[j]){
                    dp[i][j] = false;
                }else{
                    if(j - i < 3){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }

                if(dp[i][j] && (j - i + 1 > maxLen)){
                    maxLen = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start,start+maxLen);
    }

    /**
     * 中心扩散法
     * @param s
     * @return
     */
    public static String longestPalindrome1(String s) {
        int len = s.length();
        // 特判
        if (len < 2){
            return s;
        }
        int begin  = 0;
        int maxLen = 1;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < len-1; i++){
            int oddLen = center(charArray,i,i);
            int evenLen = center(charArray,i,i+1);
            int curMaxLen = Math.max(oddLen, evenLen);
            if (curMaxLen > maxLen){
                maxLen = curMaxLen;
                begin = i - (curMaxLen-1)/2;
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    private static int center(char[] charArray, int left, int right){
        int len = charArray.length;
        int i = left, j = right;
        while (i >= 0 && j < len){
            if (charArray[i] == charArray[j]){
                i--;
                j++;
            }else{
                break;
            }
        }
        return j - i - 1;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        String S = "abb";
        System.out.println(longestPalindrome1(S));
        System.out.println(longestPalindrome(S));
    }
}
