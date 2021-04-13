package BitOperation;

public class LeetCode_BitOperation_461 {
    public static int hammingDistance(int x, int y) {
        return Integer.bitCount(x^y);
    }

    public static void main(String[] args) {
        //int[] S = binaryToDecimal(4);
        //hammingDistance(4,1);
        System.out.print(hammingDistance(8,1));
    }
}
