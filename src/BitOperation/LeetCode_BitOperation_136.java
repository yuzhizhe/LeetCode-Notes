package BitOperation;

public class LeetCode_BitOperation_136 {
    public static int singleNumber(int[] nums){
        int single = 0;
        for (int i : nums){
            single ^= i;
        }
        return single;
    }

    public static void bitOperation(int a, int b){
        int c = a & b;
        System.out.println("(a & b)-->" + c);
        int d = a | b;
        System.out.println("(a | b)-->" + d);
        int e = a ^ b;
        System.out.println("(a ^ b)-->" + e);
        int f = a ^ ~1;
        System.out.println("(~a)-->" + f);
    }

    public static void bitOperations(int a){
        int c = a & 1;
        System.out.println("(a & b)-->" + c);
    }

    public static void main(String[] args) {
        int[] S = {4,1,2,1,2};
        bitOperations(1);
        //System.out.println(singleNumber(S));
    }
}
