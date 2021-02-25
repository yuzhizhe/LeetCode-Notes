public class LeetCode_String_13 {
    public static int romanToInt(String s) {
        int sum = 0;
        int preNum = romanToInteger(s.charAt(0));
        for(int i = 1;i < s.length(); i ++) {
            int num = romanToInteger(s.charAt(i));
            if(preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    public static int romanToInteger(char c){
        int returnValue = 0;
        switch(c){
            case 'I':
                returnValue = 1;
                break;
            case 'V':
                returnValue = 5;
                break;
            case 'X':
                returnValue = 10;
                break;
            case 'L':
                returnValue = 50;
                break;
            case 'C':
                returnValue = 100;
                break;
            case 'D':
                returnValue = 500;
                break;
            case 'M':
                returnValue = 1000;
                break;
            default:
                returnValue = 0;
                break;
        }
        return returnValue;
    }

    public static void main(String[] args) {
        String S = "LVIII", T = "rjh#bpvh";
        System.out.printf("return-->"+romanToInt(S));
    }
}
