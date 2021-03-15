package DP;
public class LeetCode_DP_53 {
    public static int maxSubArray(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++){
            int preSum = nums[i];
            if (preSum > res){
                res = preSum;
            }
            for (int j = i + 1; j < nums.length; j++){
                preSum = preSum + nums[j];
                if (preSum > res){
                    res = preSum;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-2};
        System.out.println(maxSubArray(nums));
    }
}
