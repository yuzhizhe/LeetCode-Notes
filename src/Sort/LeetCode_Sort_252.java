package Sort;

import java.util.Arrays;

public class LeetCode_Sort_252 {
    public static boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->(a[0] == b[0])?b[1]-a[1] : a[0]-b[0]);
        for (int i = 0; i < intervals.length-1; i ++){
            //System.out.println(intervals[i][0]+"return-->"+intervals[i][1]);
            if (intervals[i+1][0] < intervals[i][1]){
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {
        int[] S = {1,2};
        int[] T = {1,1};
        int[][] D = {{15,20},{5,10},{0,30}};
        System.out.printf("return-->"+canAttendMeetings(D));
    }
}
