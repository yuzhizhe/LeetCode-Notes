package Array;

import java.util.HashMap;
import java.util.Map;

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

    public static int[] twoSum1(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }


    public static void main(String[] args) {
        int[] S = {2,7,11,15};
        int[] T = twoSum1(S, 9);
        for(int i : T){
            System.out.println(i);
        }
    }
}
