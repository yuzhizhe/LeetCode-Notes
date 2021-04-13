package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_Tree_110 {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void levelPrint(TreeNode root){
        if (root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            while(levelSize > 0){
                TreeNode index = queue.poll();
                if (index == null){
                    System.out.print("$");
                }else{
                    System.out.print(index.val);
                    if (index.left != null){
                        queue.offer(index.left);
                    }else{
                        queue.offer(null);
                    }
                    if (index.right != null){
                        queue.offer(index.right);
                    }else{
                        queue.offer(null);
                    }
                }
                levelSize = levelSize - 1;
            }
            System.out.println("");
        }
    }

    public static boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        int leftLength = minDepth(root.left);
        int rightLength = minDepth(root.right);
        if (Math.abs(leftLength-rightLength)>1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public static int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int leftLength = minDepth(root.left);
        int rightLength = minDepth(root.right);
        return Math.max(leftLength, rightLength) +1;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(3);
        root.right = new TreeNode(5, new TreeNode(7),new TreeNode(9));
        levelPrint(root);
        System.out.print(isBalanced(root));
    }
}
