

public class LeetCode_String_38 {
    public static String countAndSay(int n) {
        String lastString = "1";
        StringBuilder sumString = new StringBuilder();
        for(int i = 1; i < n; i++){
            int j = 1;
            int start = 0;
            while(j < lastString.length()){
                if(lastString.charAt(j)!=lastString.charAt(start)){
                    sumString.append(j-start).append(lastString.charAt(start));
                    start=j;
                }
                lastString = sumString.toString();
                j ++;
            }
            sumString.append(lastString.length()-start).append(lastString.charAt(start));
        }
        return lastString;
    }
    public static void main(String[] args) {
        String S = "1010";
        String T = "10  11  ";
        System.out.println("return-->"+countAndSay(3));
        //System.out.println("return-->"+T.trim());
//        List<String> list = generatePossibleNextMoves(S);
//        for (String s : list){
//            System.out.println("return-->"+s);
//        }
    }
}
