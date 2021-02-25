import java.util.Stack;

public class LeetCode_String_20 {
    public static boolean isValid(String s) {
        if (s == null || s.length() == 0){
            return false;
        }
        if (s.length() %2 != 0){
            return false;
        }
        Stack<Character> mStack = new Stack<>();
        boolean flag = true;
        for (int i = 0; i < s.length(); i ++){
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                mStack.push(s.charAt(i));
            }else if (s.charAt(i) == ')'&&!mStack.empty()){
                if (mStack.pop() != '('){
                    flag = false;
                    break;
                }
            }else if (s.charAt(i) == '}'&&!mStack.empty()){
                if (mStack.pop() != '{'){
                    flag = false;
                    break;
                }
            }else if (s.charAt(i) == ']'&&!mStack.empty()){
                if (mStack.pop() != '['){
                    flag = false;
                    break;
                }
            }else{
                flag = false;
                break;
            }
        }
        if (!mStack.empty()){
            flag = false;
        }
        return flag;
    }

    public static void main(String[] args) {
        String s = "){";
        System.out.printf("return-->"+isValid(s));
    }
}
