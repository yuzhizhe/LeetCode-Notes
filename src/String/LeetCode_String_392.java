package String;
public class LeetCode_String_392 {
    public static boolean isSubsequence(String s, String t) {
        if(s == null || s.equals("")){
            return true;
        }
        if(t == null || t.equals("")){
            return false;
        }
        char[] S = s.toCharArray();
        char[] T = t.toCharArray();
        int sLength = S.length;
        int tLength = T.length;
        int i = 0, j = 0;
        while (i < sLength && j < tLength){
            if (S[i] == T[j]){
                i++;
            }
            j++;
            if (i == sLength){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String S = "axc", T = "ahbgdc";
        System.out.printf("return-->"+isSubsequence(S, T));
    }
}
