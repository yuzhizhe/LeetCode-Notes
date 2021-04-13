package String;

public class LeetCode_String_14 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length <= 0){
            return "";
        }
        int minLength = strs[0].length();
        for (int i = 0; i < minLength; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }



    public static void main(String[] args) {
        String[] S = {"d","do"};
        System.out.printf("return-->"+longestCommonPrefix(S));
    }
}
