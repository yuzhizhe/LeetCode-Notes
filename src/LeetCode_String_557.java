public class LeetCode_String_557 {
    public static String reverseWords(String s) {
        if (s == null || s.equals("")){
            return "";
        }
        String[] array = s.split(" ");
        StringBuilder reString = new StringBuilder();
        for (int i = 0; i < array.length; i ++){
            if (i == array.length -1){
                reString.append(reverseString(array[i].toCharArray()));
            }else {
                reString.append(reverseString(array[i].toCharArray()) + " ");
            }
        }
        return reString.toString();
    }

    public static String reverseString(char[] s) {
        int i = 0, j = s.length-1;
        while (i < j){
            char index = s[i];
            s[i] = s[j];
            s[j] = index;
            i++;
            j--;
        }
        return new String(s);
    }

    public static void swap(char a , char b){
        char index = a;
        a = b;
        b = index;
    }

    public static void main(String[] args) {
        String S = "Let's take LeetCode contest", T = "LeetCode";
        char[] mChar = {};
        System.out.printf("return-->"+reverseWords(T));
//        reverseString(mChar);
//        for (char c : mChar){
//            System.out.println("return-->"+c);
//        }
    }
}
