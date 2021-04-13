package String;

import java.util.Stack;
import java.util.regex.Pattern;

public class LeetCode_String_682 {
    public static int calPoints(String[] ops) {
        if (ops == null || ops.length == 0){
            return 0;
        }
        Stack<Integer> sum = new Stack<>();
        for (int i = 0; i < ops.length; i ++){
            if(isInteger(ops[i])){
                sum.push(Integer.valueOf(ops[i]));
            }else if(ops[i].equals("C")){
                sum.pop();
            }else if(ops[i].equals("D")){
                sum.push(sum.peek()*2);
            }else if(ops[i].equals("+")){
                int top = sum.pop();
                int sum2 = sum.peek() + top;
                sum.push(top);
                sum.push(sum2);
            }else{
                sum.push(0);
            }
        }
        int returnSum = 0;
        while(!sum.empty()){
            returnSum = returnSum + sum.pop();
        }
        return returnSum;
    }
    public static int calPoints2(String[] ops) {
        //数组长度
        int length = ops.length;

        //建立一个数字数组，用来存储每次的操作结果
        int[] num = new int[length];
        //数字数组的当前下标
        int index = 0;

        //遍历符号数组
        for(int i = 0; i < length; i++)
        {
            //当前符号为“C”，需要清除一个数字
            if(ops[i].equals("C"))
            {
                //下标回退一格，且回退后位置上的数字置零
                index --;
                num[index] = 0;
            }
            //当前符号为“D”，需要翻倍
            else if(ops[i].equals("D"))
            {
                //当前数字等于前一个数字的两倍
                num[index] = 2 * num[index - 1];
                index ++;
            }
            //当前符号为“+”，需要相加
            else if(ops[i].equals("+"))
            {
                //当前数字等于前两个数字之和
                num[index] = num[index - 1] + num[index - 2];
                index ++;
            }
            //当前符号为数字，直接填入数字数组
            else
            {
                num[index] = Integer.parseInt(ops[i]);
                index ++;
            }
        }

        //对数字数组进行求和
        int sum = 0;
        for(int j = 0; j < length; j++)
        {
            sum += num[j];
        }

        return sum;

    }
    /*
     * 判断是否为整数
     * @param str 传入的字符串
     * @return 是整数返回true,否则返回false
     */
    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-]?[\\d]*$");
        return pattern.matcher(str).matches();
    }


    public static void main(String[] args) {
        String[] nums ={"5","-2","4","C","D","9","+","+"};
        System.out.println(calPoints2(nums));
    }
    //计算两个大整数相加，整数使用字符串表示（有时间的话可以考虑带符号的情况），输入两个空格分隔的大整数（均不超过100000位），输出它们的和。
}
