package BitOperation;

import java.util.Arrays;

public class LeetCode_BitOperation_268 {
    public static int missingNumber(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }

    public static void main(String[] args) {
        int[] S = {3,0,1};
        System.out.print(missingNumber(S));
    }
}
