import java.util.Stack;
import java.util.regex.Pattern;

public class LeetCode_Stack_682 {
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
        String[] nums ={"1"};
        System.out.println(calPoints(nums));
    }
    //计算两个大整数相加，整数使用字符串表示（有时间的话可以考虑带符号的情况），输入两个空格分隔的大整数（均不超过100000位），输出它们的和。
}
