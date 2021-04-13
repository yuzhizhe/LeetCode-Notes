package Array;

public class LeetCode_Array_11 {
    public static int maxArea(int[] height) {
        int start = 0, end = height.length-1;
        int max = Integer.MIN_VALUE;
        while(start < end){
            int index;
            if (height[start] > height[end]){
                index = Math.min(height[start],height[end]) * (end - start);
                end--;
            }else{
                index = Math.min(height[start],height[end]) * (end - start);
                start++;
            }
            if (index > max){
                max = index;
            }
        }
        return max;
    }

    public static void main(String[] args){
        int[] T = {1,1};
        System.out.println(maxArea(T));
    }
}
