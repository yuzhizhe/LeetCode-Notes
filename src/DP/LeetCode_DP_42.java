package DP;
public class LeetCode_DP_42 {
    public static int trap(int[] height) {
        int length = height.length;
        if (length < 3){
            return 0;
        }
        int left_max = 0;
        int[] right_max = new int[length];
        int sum = 0;
        for (int i = length - 2; i >= 0; i--){
            right_max[i] = Math.max(right_max[i + 1], height[i + 1]);
        }
        for (int i = 1; i < length-1; i++){
            left_max = Math.max(height[i-1],left_max);
            int min = Math.min(right_max[i], left_max);
            if (min > height[i]){
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {4,2,0,3,2,5};
        System.out.println(trap(nums));
    }
}
