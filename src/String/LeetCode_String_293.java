package String;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_String_293 {
    public static List<String> generatePossibleNextMoves(String s) {
        List<String> list = new ArrayList<>();
        if (s == null || s.length() < 2){
            return list;
        }
        char[] s1 = s.toCharArray();
        for (int i = 0; i < s.length() -1; i++){
            if (s1[i] == '+' && s1[i+1] == '+'){
                s1[i] = '-';
                s1[i+1] = '-';
                list.add(new String(s1));
                s1[i] = '+';
                s1[i+1] = '+';
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String S = "+";
        List<String> list = generatePossibleNextMoves(S);
        for (String s : list){
            System.out.println("return-->"+s);
        }
    }
}
