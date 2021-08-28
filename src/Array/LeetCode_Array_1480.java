package Array;

public class LeetCode_Array_1480 {
    public static int[] runningSum(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = nums[0];
        for (int i = 1; i <= nums.length - 1; i ++){
            ans[i] = ans[i-1] + nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] S = {3,1,2,10,1};
        int[] T = runningSum(S);
        for(int i : T){
            System.out.println(i);
        }
    }
}
