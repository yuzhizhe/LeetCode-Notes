package Array;

public class LeetCode_Array_674 {
    public static int findLengthOfLCIS(int[] nums) {
        int length = nums.length;
        if (length <= 0){
            return 0;
        }
        int sum = 1;
        int max = 1;
        for (int i = 1; i < length; i++){
            if (nums[i]>nums[i-1]){
                sum = sum + 1;
            }else{
                sum = 1;
            }
            max = Math.max(sum, max);
        }
        return max;
    }

    public static void main(String[] args){
        int[] T = {1,3,5,4,2,3,4,5};
        System.out.println(findLengthOfLCIS(T));
    }
}
