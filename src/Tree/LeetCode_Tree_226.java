package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_Tree_226 {
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

    public static TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2,new TreeNode(4),new TreeNode(5));
        root.right = new TreeNode(3,new TreeNode(6),new TreeNode(7));
        levelPrintf(root);
        invertTree(root);
        levelPrintf(root);
    }
}
