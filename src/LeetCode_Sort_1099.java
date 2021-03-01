import java.util.Arrays;

public class LeetCode_Sort_1099 {
    public static int twoSumLessThanK(int[] nums, int k) {
        int result = -1, sub = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum < k) {
                if (Math.abs(sum - k) < sub) {
                    result = sum;
                    sub = Math.abs(sum - k);
                }
                left++;
            } else {
                right--;
            }
        }
        return result;
    }

    public static String[] subString(String[] s) {
        return Arrays.copyOfRange(s, 0, 3);
    }

    public static void main(String[] args) {
        int[] S= {34,23,1,24,75,33,54,8};
        int k = 60;
        String[] D = {"aaaa","bbbb","ccccc","ddddd"};
        String[] F = subString(D);
        for (String s : F){
            System.out.println(s);
        }

        //System.out.println(subString(D));
        //int[][] T = highFive(S);
//        for (int[] v : T){
//            System.out.println(v[0] + "--->"+v[1]);
//        }
    }
}
