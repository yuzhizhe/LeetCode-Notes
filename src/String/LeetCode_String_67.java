package String;

public class LeetCode_String_67 {
    public static String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1;
        StringBuilder reString = new StringBuilder();
        boolean isB = false;
        while (i >= 0 || j >= 0){
            char aChar = i >= 0 ? a.charAt(i) : '0';
            char bChar = j >= 0 ? b.charAt(j) : '0';
            if (aChar == '0' && bChar == '0'){
                if (isB){
                    reString.append(1);
                    isB = false;
                }else{
                    reString.append(0);
                    isB = false;
                }
            }else if (aChar == '0' && bChar == '1'){
                if (isB){
                    reString.append(0);
                    isB = true;
                }else{
                    reString.append(1);
                    isB = false;
                }
            }else if (aChar == '1' && bChar == '0'){
                if (isB){
                    reString.append(0);
                    isB = true;
                }else{
                    reString.append(1);
                    isB = false;
                }
            }else{
                if (isB){
                    reString.append(1);
                    isB = true;
                }else{
                    reString.append(0);
                    isB = true;
                }
            }
            i --;
            j --;
        }
        if (isB){
            reString.append(1);
        }
        return reString.reverse().toString();
    }

    public static void main(String[] args) {
        String S = "1010";
        String T = "1011";
        StringBuffer  reString = new StringBuffer ();
        reString.append("1").append("2").append("3");
        System.out.println("return-->"+addBinary(S,T));
        //System.out.println("return-->"+reString.toString());
//        List<String> list = generatePossibleNextMoves(S);
//        for (String s : list){
//            System.out.println("return-->"+s);
//        }
    }
}
