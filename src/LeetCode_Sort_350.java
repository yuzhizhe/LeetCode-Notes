import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_Sort_350 {
    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        if (nums1.length < nums2.length){
            for (int i = 0; i < nums1.length; i ++){
                for (int j = 0; j < nums2.length; j ++){
                    if (nums1[i] == nums2[j]){
                        list.add(nums1[i]);
                        i ++;
                        break;
                    }
                }
            }
        }else{
            for (int i = 0; i < nums2.length; i ++){
                for (int j = 0; j < nums1.length; j ++){
                    if (nums1[j] == nums2[i]){
                        list.add(nums1[j]);
                        i ++;
                        break;
                    }
                }
            }
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }



    public static void main(String[] args) {
        int[] S = {1,2};
        int[] T = {1,1};
        System.out.printf("return-->"+intersect(S,T).length);
    }
}
