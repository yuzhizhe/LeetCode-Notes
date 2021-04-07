import java.util.Arrays;

public class LeetCode_Sort_InsertSort {

    //插入排序
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

    //快速排序
    public static void QuickSort(int[] intervals, int start, int end) {
        int i = start, j = end;
        int index = intervals[start];
        if (i >= j) {
            //没必要排序
            return;
        }
        while (i < j){
            while (i < end && intervals[j] >= index){
                j--;
            }
            if (i < j){
                intervals[i] = intervals[j];
                i++;
            }
            while (i < j && intervals[i] <= index){
                i++;
            }
            if (i < j){
                intervals[j] = intervals[i];
                j--;
            }
        }
        intervals[i] = index;
        QuickSort(intervals,start,i-1);
        QuickSort(intervals,i+1,end);
    }



    public static void main(String[] args) {
        int[] S = {4,5,6,2,8,7,1,3,9};
        int[] T = {1,1};
        int[][] D = {{15,20},{5,10},{0,30}};
        //insertSort(S);
        QuickSort(S, 0, S.length-1);
        for (int i : S){
            System.out.println("return-->"+i);
        }
        //System.out.println("return-->"+insertSort(S));
    }
}
