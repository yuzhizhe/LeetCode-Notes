public class LeetCode_String_344 {
    public static void reverseString(char[] s) {
        int i = 0, j = s.length-1;
        while (i < j){
            //swap(s[i], s[j]);
            char index = s[i];
            s[i] = s[j];
            s[j] = index;
            i++;
            j--;
        }
    }

    public static void swap(char a , char b){
        char index = a;
        a = b;
        b = index;
    }

    public static void main(String[] args) {
        String S = "LVIII", T = "rjh#bpvh";
        char[] mChar = {};
        //System.out.printf("return-->"+reverseString(mChar));
        reverseString(mChar);
        for (char c : mChar){
            System.out.println("return-->"+c);
        }
    }
}
