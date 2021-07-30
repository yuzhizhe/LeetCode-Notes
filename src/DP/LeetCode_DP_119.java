package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode_DP_119 {
    public static List<Integer> getRow(int rowIndex) {
        rowIndex = rowIndex + 1;
        if (rowIndex < 1) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>(1);
        list.add(1);
        if (rowIndex == 1) return list;
        ans.add(list);
        for (int i = 1; i < rowIndex; i++) {
            Integer[] arr = new Integer[i + 1];
            arr[0] = arr[i] = 1;
            for (int x = 1; x < i; x++)
                arr[x] = ans.get(i - 1).get(x) + ans.get(i - 1).get(x - 1);
            ans.add(Arrays.asList(arr));
        }
        return ans.get(rowIndex-1);
    }

    public static List<Integer> getRow1(int rowIndex) {
        List<Integer> pre = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> cru = new ArrayList<>();
            for (int j = 0; j <= i; j++){
                if (j == 0 || j == i){
                    cru.add(1);
                }else{
                    cru.add(pre.get(j-1) + pre.get(j));
                }
            }
            pre = cru;
        }
        return pre;
    }

    public static void main(String[] args) {
        int[] nums = {-2};
        List<Integer> list = getRow1(4);
        for (int i : list){
            System.out.print(i);
        }
    }
}
