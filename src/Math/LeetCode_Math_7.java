package Math;

import java.util.ArrayList;

public class LeetCode_Math_7 {
    public static int reverse(int x) {
        if (x == 0){
            return 0;
        }
        boolean isMin = false;
        if (x < 0){
            isMin = true;
            x = -1 * x;
        }
        String value = String.valueOf(x);
        char[] values = value.toCharArray();
        char[] valuesCopy = new char[values.length];
        boolean falg = true;
        int i = values.length-1;
        int j = 0;
        while (i >= 0){
            if (falg && values[i] == '0'){
                i--;
                continue;
            }else{
                falg = false;
                valuesCopy[j] = values[i];
                j++;
                i--;
            }
        }
        int returnValue = Integer.parseInt(String.valueOf(valuesCopy,0,j));
        if (isMin){
            returnValue = -1 * returnValue;
        }
        return returnValue;
    }

    public static void main(String[] args) {
        //System.out.println(reverse(1233456789));
        ArrayList<Integer> list = null;
//        System.out.println(list.size());
        for (int item : list){
            System.out.println("---");
        }
    }
}
