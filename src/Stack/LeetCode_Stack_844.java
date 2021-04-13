package Stack;

import java.util.Stack;

public class LeetCode_Stack_844 {
    public static boolean backspaceCompare(String S, String T) {
        int sCharIndex = S.length() - 1,tCharIndex = T.length() - 1;
        int skipS = 0, skipT = 0;
        while(sCharIndex >= 0 || tCharIndex >= 0){
            while (sCharIndex >= 0) {
                if (S.charAt(sCharIndex) == '#') {
                    skipS++;
                    sCharIndex--;
                } else if (skipS > 0) {
                    skipS--;
                    sCharIndex--;
                } else {
                    break;
                }
            }
            while (tCharIndex >= 0) {
                if (T.charAt(tCharIndex) == '#') {
                    skipT++;
                    tCharIndex--;
                } else if (skipT > 0) {
                    skipT--;
                    tCharIndex--;
                } else {
                    break;
                }
            }
            if (sCharIndex >= 0 && tCharIndex >= 0) {
                if (S.charAt(sCharIndex) != T.charAt(tCharIndex)) {
                    return false;
                }
            } else {
                if (sCharIndex >= 0 || tCharIndex >= 0) {
                    return false;
                }
            }
            sCharIndex--;
            tCharIndex--;
        }
        return true;
    }

    public static void main(String[] args) {
        String S = "rjhbpvh", T = "rjh#bpvh";
        System.out.printf("return-->"+backspaceCompare(S,T));
    }
}
