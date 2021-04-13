package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_Tree_543 {
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

    public static int compteLevel(TreeNode root){
        if (root == null){
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while(!queue.isEmpty()){
            int length = queue.size();
            while(length > 0){
                TreeNode index = queue.poll();
                if (index.left != null){
                    queue.offer(index.left);
                }
                if (index.right != null){
                    queue.offer(index.right);
                }
                length--;
            }
            level++;
        }
        return level;
    }

    static int maxLength = 0;
    public static int depth(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftLength = 0;
        int rightLength = 0;
        leftLength = depth(root.left);
        rightLength = depth(root.right);
        if (leftLength + rightLength > maxLength){
            maxLength = leftLength + rightLength;
        }
        return Math.max(leftLength, rightLength) + 1;
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return maxLength;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2,new TreeNode(4),new TreeNode(5));
        root.right = new TreeNode(3);
        //levelPrintf(root);
        System.out.println(diameterOfBinaryTree(root));
        //levelPrintf(root);
    }
}
