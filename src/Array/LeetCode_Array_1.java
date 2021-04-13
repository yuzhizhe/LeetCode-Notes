package Array;

public class LeetCode_Array_1 {
    public static int[] twoSum(int[] nums, int target){
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++){
            for (int j = i+1; j < nums.length; j++){
                if(nums[i]+nums[j] == target){
                    res[0] = i;
                    res[1] = j;
                    return res;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] S = {3,3};
        int[] T = twoSum(S, 6);
        for(int i : T){
            System.out.println(i);
        }
    }
}
