package BitOperation;

public class LeetCode_BitOperation_190 {
    public static int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++){
            res <<= 1;
            res = (n & 1) | res;
            n >>= 1;
        }
        return res;
    }

    public static int[] binaryToDecimal(int n){
        int[] intBit = new int[32];

        for(int i = 31;i >= 0; i--){
            intBit[31-i] = (n >>> i & 1);
            //System.out.print(n >>> i & 1);
        }
        return intBit;
    }

    public static void main(String[] args) {
        int[] S = binaryToDecimal(4);
        System.out.print(reverseBits(-9));
    }
}
