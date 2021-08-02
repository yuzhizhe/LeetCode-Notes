package DP;
public class LeetCode_DP_509 {
    public static  int fib(int n) {
        int pre = 1, pre_1 = 0 , cur = 0;
        if (n == 0){
            return pre_1;
        }
        if (n == 1){
            return pre;
        }
        for (int i = 2; i <= n; i++){
            cur = pre + pre_1;
            pre_1 = pre;
            pre = cur;
        }
        return pre;
    }

    public static void main(String[] args) {
        System.out.print(fib(9));
    }
}
