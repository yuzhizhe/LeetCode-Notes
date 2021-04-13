package String;

public class LeetCode_String_28 {
    public static int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0){
            return 0;
        }
        if (haystack == null || haystack.length() == 0){
            return -1;
        }
        int flag = needle.length();
        String s = haystack;
        s.indexOf(needle);
        int i = 0;
        while (i < haystack.length()){
            if(i+flag > haystack.length()-1){
                s = haystack.substring(i);
            }else{
                s = haystack.substring(i, i + flag);
            }
            if (s.equals(needle)){
                return i;
            }
            i = i + 1;
        }
        return -1;
    }

    public static int strStr2(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        String S = "hello", T = "he";
        System.out.printf("return-->"+strStr2(S,T));
    }
}
