import java.util.Arrays;

public class LeetCode_Sort_InsertSort {
    public static void insertSort(int[] intervals) {
        for (int i = 1; i < intervals.length; i ++){
            //System.out.println(intervals[i][0]+"return-->"+intervals[i][1]);
            int index = intervals[i];
            int j = i - 1;
            while(j >= 0 && intervals[j] > index){
                intervals[j+1] = intervals[j];
                j--;
            }
            intervals[j+1] = index;
        }
    }



    public static void main(String[] args) {
        int[] S = {4,5,6,2,8,7,1,3,9};
        int[] T = {1,1};
        int[][] D = {{15,20},{5,10},{0,30}};
        insertSort(S);
        for (int i : S){
            System.out.println("return-->"+i);
        }
        //System.out.println("return-->"+insertSort(S));
    }
}
