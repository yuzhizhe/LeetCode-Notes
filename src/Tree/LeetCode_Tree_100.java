package Tree;

import java.util.LinkedList;

public class LeetCode_Tree_100 {
    private static class TreeNode {
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

    public static void prePrintf(TreeNode root){
        if (root == null){
            return;
        }
        System.out.println(root.val);
        prePrintf(root.left);
        prePrintf(root.right);
    }

    public static void middlePrintf(TreeNode root){
        if (root == null){
            return;
        }
        middlePrintf(root.left);
        System.out.println(root.val);
        middlePrintf(root.right);
    }

    public static void postPrintf(TreeNode root){
        if (root == null){
            return;
        }
        postPrintf(root.left);
        postPrintf(root.right);
        System.out.println(root.val);
    }

    public static void levelPrintf(TreeNode root){
        if (root == null){
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        while (!queue.isEmpty()){
            TreeNode index = queue.removeFirst();
            if (index != null){
                System.out.println(index.val);
                queue.addLast(index.left);
                queue.addLast(index.right);
            }
        }
    }

    public static boolean check(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        }
        if (leftNode == null || rightNode == null) {
            return false;
        }
        return leftNode.val == rightNode.val && check(leftNode.left, rightNode.left) && check(leftNode.right, rightNode.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2,new TreeNode(4),new TreeNode(5));
        root.right = new TreeNode(3,new TreeNode(6),new TreeNode(7));

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2,new TreeNode(4),new TreeNode(5));
        root1.right = new TreeNode(3,new TreeNode(6),new TreeNode(7));
        System.out.println(check(root, root1));
    }
}
