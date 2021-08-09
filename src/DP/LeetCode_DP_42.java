package DP;
public class LeetCode_DP_42 {

    /**
     * 动态规划版本
     * 时间复杂度：O(n)
     * 时间复杂度：O(2n)
     * @param height
     * @return
     */
    public static int trap(int[] height) {
        int length = height.length;
        if (length < 3){
            return 0;
        }
        int[] left_max = new int[length];
        int[] right_max = new int[length];
        int sum = 0;
        for (int i = 1; i < length; i++){
            left_max[i] = Math.max(left_max[i - 1], height[i - 1]);
        }
        for (int i = length - 2; i >= 0; i--){
            right_max[i] = Math.max(right_max[i + 1], height[i + 1]);
        }
        for (int i = 1; i < length-1; i++){
            int min = Math.min(right_max[i], left_max[i]);
            if (min > height[i]){
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }

    /**
     * 动态规划版本--空间优化
     * 时间复杂度：O(n)
     * 时间复杂度：O(n)
     * @param height
     * @return
     */
    public static int trap1(int[] height) {
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

    /**
     * 双指针法
     * 时间复杂度：O(n)
     * 时间复杂度：O(1)
     * @param height
     * @return
     */
    public static int trap2(int[] height) {
        int length = height.length;
        if (length < 3){
            return 0;
        }
        int left_max = 0, right_max = 0;
        int left = 0, right = length - 1;
        int sum = 0;
        while (left <= right){
            if (left_max < right_max){
                sum = sum + Math.max(0 , left_max - height[left]);
                left_max = Math.max(left_max, height[left]);
                left++;
            }else {
                sum = sum + Math.max(0 , right_max - height[right]);
                right_max = Math.max(right_max, height[right]);
                right--;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {4,2,0,3,2,5};
        System.out.println(trap1(nums));
        System.out.println(trap2(nums));
    }
}
