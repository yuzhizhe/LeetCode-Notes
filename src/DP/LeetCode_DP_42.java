package DP;
public class LeetCode_DP_42 {

    /**
     * 按列求
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        int length = height.length;
        if (length < 3){
            return 0;
        }
        int sum = 0;
        int left_max = 0, right_max = 0;
        for (int i = 1; i < length - 1; i++){
            left_max = 0; right_max = 0;
            for (int j = i - 1; j >= 0; j--){
                if (height[j] > left_max){
                    left_max = height[j];
                }
            }

            for (int j = i + 1; j < length; j++){
                if (height[j] > right_max){
                    right_max = height[j];
                }
            }
            int min = Math.min(left_max, right_max);
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }

    /**
     * 按列求--优化版
     * @param height
     * @return
     */
    public static int trap1(int[] height) {
        int sum = 0;
        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];

        for (int i = 1; i < height.length - 1; i++) {
            max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(max_left[i], max_right[i]);
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap1(nums));
    }
}
