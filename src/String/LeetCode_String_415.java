package String;

import java.util.regex.Pattern;

public class LeetCode_String_415 {
        public static String addStrings(String num1, String num2) {
            StringBuilder res = new StringBuilder("");
            int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
            while(i >= 0 || j >= 0){
                int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
                int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
                int tmp = n1 + n2 + carry;
                carry = tmp / 10;
                res.append(tmp % 10);
                i--; j--;
            }
            if(carry == 1) res.append(1);
            return res.reverse().toString();
        }
    /*
     * 判断是否为整数
     * @param str 传入的字符串
     * @return 是整数返回true,否则返回false
     */
    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }


    public static void main(String[] args) {
        String[] nums ={"1","2","D","3","4"};
        System.out.println(addStrings("41324132","766576574"));
        //int a = "qewr".charAt(1) - '0';
        //System.out.println(a);
    }
    //计算两个大整数相加，整数使用字符串表示（有时间的话可以考虑带符号的情况），输入两个空格分隔的大整数（均不超过100000位），输出它们的和。
}
