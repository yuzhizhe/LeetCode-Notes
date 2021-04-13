package String;

import java.util.Date;
import java.util.HashMap;

public class LeetCode_String_387 {
    public static int firstUniqChar(String s) {
        if (s.length() == 0){
            return -1;
        }
        if (s.length() == 1){
            return 0;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        for (int i = 0; i < s.length(); i++){
            if (map.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String S = "leetcode", T = "rjh#bpvh";
        Date start = new Date();
        System.out.println("return-->"+firstUniqChar(S));
        System.out.println("time-->"+(new Date().getTime() - start.getTime()));
    }
}
