package DP;
public class LeetCode_DP_718 {

    /**
     * 动态规划版本
     * 时间复杂度：O(n*m)
     * 空间复杂度：O(n*m)
     * @param nums1
     * @param nums2
     * @return
     */
    public static int maxUncrossedLines(int[] nums1, int[] nums2) {
        int length_1 = nums1.length;
        int length_2 = nums2.length;
        int[][] dp = new int[length_1+1][length_2+1];
        int max = 0;
        for (int i = 1; i <= length_1; i++){
            for (int j = 1; j <= length_2; j++){
                if (nums1[i-1] == nums2[j-1]){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                max = Math.max(dp[i][j], max);
            }
        }
        return max;
    }

    /**
     * 动态规划版本--优化版
     * 时间复杂度：O(n*m)
     * 空间复杂度：O(n)
     * @param nums1
     * @param nums2
     * @return
     */
    public static int maxUncrossedLines1(int[] nums1, int[] nums2) {
        int length_1 = nums1.length;
        int length_2 = nums2.length;
        int[] dp = new int[length_2+1];
        int pre = 0;
        int max = 0;
        for (int i = 1; i <= length_1; i++){
            pre = 0;
            for (int j = 1; j <= length_2; j++){
                int temp = dp[j];
                if (nums1[i-1] == nums2[j-1]){
                    dp[j] = pre + 1;
                }else{
                    dp[j] = 0;
                }
                max = Math.max(dp[j], max);
                pre = temp;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] S = {1,0,0,0,1};
        int[] T = {1,0,0,1,1};
        System.out.println(maxUncrossedLines(S, T));
        System.out.println(maxUncrossedLines1(S, T));
    }
}
