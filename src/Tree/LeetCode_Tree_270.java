package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_Tree_270 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void levelPrintf(TreeNode root){
        if (root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size > 0) {
                TreeNode index = queue.poll();
                System.out.print(index.val);
                if (index.left != null){
                    queue.offer(index.left);
                }
                if (index.right != null){
                    queue.offer(index.right);
                }
                size--;
            }
            System.out.println();
        }
    }

    public static int closestValue1(TreeNode root, double target){
        int min = Integer.MAX_VALUE;
        if (root == null){
            return min;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        double midlle = Double.MAX_VALUE;
        while (!queue.isEmpty()){
            TreeNode index = queue.poll();
            double i = Math.abs(index.val-target);
            if(i<midlle){
                midlle = i;
                min = index.val;
                if (index.left != null){
                    queue.offer(index.left);
                }
            }
        }
        return min;
    }

    static double midlle = Double.MAX_VALUE;
    static int min;
    public static int closestValue(TreeNode root, double target) {
        if (root == null){
            return min;
        }
        double i = root.val - target;
        if (i < 0){
            if(-i < midlle) {
                min = root.val;
                midlle = -i;
            }
        }else{
            if(i < midlle) {
                min = root.val;
                midlle = i;
            }
        }
        return  target > root.val ? closestValue(root.right, target) : closestValue(root.left, target);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(2,new TreeNode(1),new TreeNode(3));
        root1.right = new TreeNode(5);

        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(2);
        //levelPrintf(root);
        //invertTree(root);
        int index = closestValue1(root2,3.428571);
        //levelPrintf(index);
        System.out.println(index);
    }
}
