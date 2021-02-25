public class LeetCode_String_345 {
    public static String reverseVowels(String s) {
        char[] sArray = s.toCharArray();
        int start = 0, end = sArray.length - 1;
        while (start < end){
            while (!Vowels(sArray[start]) && start < end){
                start ++;
            }
            while (!Vowels(sArray[end]) && start < end){
                end --;
            }
            char index = sArray[start];
            sArray[start] = sArray[end];
            sArray[end] = index;
            start ++;
            end --;
        }
        return new String(sArray);
    }

    public static boolean Vowels(char s) {
        if (s == 'a' || s == 'e' || s == 'i' || s == 'o' || s == 'u'){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        String S = "hello";
        System.out.println("return-->" + reverseVowels(S));
    }
}