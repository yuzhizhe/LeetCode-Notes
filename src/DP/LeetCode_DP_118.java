package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_DP_118 {
    public static List<Integer> generate1(int numRows) {
        if (numRows <= 1) return Arrays.asList(1);
        Integer[] dp = new Integer[numRows];
        int pre = 1;
        for (int i = 1; i < numRows; i++) {
            dp[0] = dp[i] = 1;
            for (int x = 1; x < i; x++) {
                pre = dp[x-1];
                dp[x] = pre + dp[x];
            }
        }
        return  Arrays.asList(dp);
    }

    public List<List<Integer>> generate(int numRows) {
        if (numRows < 1) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>(2);
        list.add(1);
        ans.add(list);
        for (int i = 1; i < numRows; i++) {
            Integer[] arr = new Integer[i + 1];
            arr[0] = arr[i] = 1;
            for (int x = 1; x < i; x++)
                arr[x] = ans.get(i - 1).get(x) + ans.get(i - 1).get(x - 1);
            ans.add(Arrays.asList(arr));
        }
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> lists = generate1(4);
            for (int i : lists){
                System.out.print(i);
            }

    }
}
