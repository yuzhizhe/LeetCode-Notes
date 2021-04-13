package String;

public class LeetCode_String_58 {
    public static int lengthOfLastWord(String s) {
        int i = s.length()-1;
        int length = s.length();
        boolean isD = true;
        while (i >= 0){
            if (s.charAt(i) == ' ' && isD){
                i --;
                length --;
                continue;
            }else{
                isD = false;
            }
            if (s.charAt(i) == ' '){
                return length - i -1;
            }
            if (i == 0){
                return length - i;
            }
            i --;
        }
        return 0;
    }

    public static void main(String[] args) {
        String S = "1010";
        String T = "10  11  ";
        System.out.println("return-->"+lengthOfLastWord(S));
        //System.out.println("return-->"+T.trim());
//        List<String> list = generatePossibleNextMoves(S);
//        for (String s : list){
//            System.out.println("return-->"+s);
//        }
    }
}
