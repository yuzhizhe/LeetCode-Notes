import java.util.*;

public class LeetCode_Sort_1086 {
    public static void highFive(int[][] items) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        //如果不相等，安装id排序，小的在前；如果相等，安装成绩大小排序，大的在前
        Arrays.sort(items,( (a,b)->((a[0] == b[0])?b[1]-a[1]:a[0] - b[0])));
//        for (int[] i : items){
//            if (map.get(i[0]) == null){
//                List<Integer> list = new ArrayList<>();
//                list.add(i[1]);
//                map.put(i[0],list);
//            }else{
//                map.get(i[0]).add(i[1]);
//            }
//        }
        for (int[] i : items){
            System.out.println(i[0]+"return-->"+i[1]);
        }
        //System.out.printf("return-->"+items.toString());
    }



    public static void main(String[] args) {
        int[][] S = {{1, 91},{1, 92},{1, 92},{1, 92},{2, 93},{2, 97},{3, 92},{3, 92}};
        int[] T = {1,1};
        highFive(S);
        //System.out.printf("return-->"+highFive(S));
    }
}
