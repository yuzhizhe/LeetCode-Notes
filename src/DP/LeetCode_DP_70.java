package DP;

import java.util.HashMap;

public class LeetCode_DP_70 {
    static int res = 0;
    static HashMap<Integer, Integer> table = new HashMap<>();
    public static int climbStairs(int n){
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        int index = table.getOrDefault(n,-1);
        if (index==-1){
            res = climbStairs(n - 1) + climbStairs(n-2);
            table.put(n,res);
        }else{
            res = index;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(20));
        System.out.println(table.toString());
    }
}
