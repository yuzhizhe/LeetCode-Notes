package Stack;

import java.util.Stack;

public class LeetCode_Stack_496 {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0 ){
            throw new IllegalArgumentException("参数长度不能为空");
        }
        if(nums1.length > nums2.length){
            throw new IllegalArgumentException("num1参数长度不能大于num2参数长度");
        }
        int[] array = new int[nums1.length];
        Stack<Integer> mStack = new Stack<>();
        Stack<Integer> mStack2 = new Stack<>();
        for (int a:nums2) {
            mStack.push(a);
        }
        for (int i = 0; i < nums1.length; i ++) {
            mStack2.addAll(mStack);
            while (!mStack2.empty()){
                if (mStack2.peek() == nums1[i]){
                    break;
                }else if (mStack2.peek() != nums1[i] && mStack2.peek() > nums1[i]){
                    array[i] = mStack2.pop();
                }else{
                    mStack2.pop();
                }
            }
            if (array[i] == 0){
                array[i] = -1;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] nums1 ={4,1,2};
        int[] nums2 ={1,2,3,4};
        int[] nums3 = nextGreaterElement(nums1, nums2);
        for (int a: nums3) {
            System.out.println(a);
        }
    }
}
