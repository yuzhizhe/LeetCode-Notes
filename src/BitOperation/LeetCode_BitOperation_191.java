package BitOperation;

public class LeetCode_BitOperation_191 {
    public static int hammingWeight(int n) {
        int sum = 0;
        for(int i = 0; i < 32; i ++){
            if ((n & 1)==1){
                sum = sum +1;
            }
            n >>= 1;
            if (n == 0){//优化，所有1右移完，就可以结束了
                break;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        //int[] S = binaryToDecimal(4);
        System.out.print(hammingWeight(4));
    }
}
