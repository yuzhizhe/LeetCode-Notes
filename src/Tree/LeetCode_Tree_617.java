package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_Tree_617 {
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

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null){
            return root1 == null? root2:root1;
        }
        root1.val += root2.val;
        root1.left = mergeTrees(root1.left,root2.left);
        root1.right = mergeTrees(root1.right,root2.right);
        return root1;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3,new TreeNode(5),null);
        root1.right = new TreeNode(2);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1,null,new TreeNode(4));
        root2.right = new TreeNode(3,null,new TreeNode(7));
        //levelPrintf(root);
        //invertTree(root);
        TreeNode index = mergeTrees(root1,root2);
        levelPrintf(index);
    }
}
