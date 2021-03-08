public class LeetCode_BitOperation_371 {
    public static int getSum(int a, int b) {
        int sum, carry;
        sum = a ^ b;
        carry = (a & b) << 1;
        if(carry != 0)//有进位，递归
        {
            return getSum(sum, carry);
        }
        return sum;
    }

    public static void main(String[] args) {
        //int[] S = binaryToDecimal(4);
        System.out.print(getSum(1,0));
    }
}
