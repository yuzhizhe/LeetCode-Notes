package DP;
public class LeetCode_DP_1035 {

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
        for (int i = 1; i <= length_1; i++){
            for (int j = 1; j <= length_2; j++){
                if (nums1[i-1] == nums2[j-1]){
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
     * @param nums1
     * @param nums2
     * @return
     */
    public static int maxUncrossedLines1(int[] nums1, int[] nums2) {
        int length_1 = nums1.length;
        int length_2 = nums2.length;
        int[] dp = new int[length_2+1];
        int pre = 0;
        for (int i = 1; i <= length_1; i++){
            pre = 0;
            for (int j = 1; j <= length_2; j++){
                int temp = dp[j];
                if (nums1[i-1] == nums2[j-1]){
                    dp[j] = pre + 1;
                }else{
                    dp[j] = Math.max(dp[j-1], dp[j]);
                }
                pre = temp;
            }
        }
        return dp[length_2];
    }

    public static void main(String[] args) {
        int[] S = {2,5,1,2,5};
        int[] T = {10,5,2,1,5,2};
        System.out.println(maxUncrossedLines(S, T));
        System.out.println(maxUncrossedLines1(S, T));
    }
}
