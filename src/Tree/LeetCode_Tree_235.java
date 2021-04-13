package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_Tree_235 {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
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
                System.out.print(index.val);
                if (index.left != null){
                    queue.offer(index.left);
                }
                if (index.right != null){
                    queue.offer(index.right);
                }
                levelSize = levelSize - 1;
            }
            System.out.println("");
        }
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return root;
        }
        if (p.val < root.val && q.val < root.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        if (p.val > root.val && q.val > root.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2,new TreeNode(0),new TreeNode(4,new TreeNode(3),new TreeNode(5)));
        root.right = new TreeNode(8, new TreeNode(7),new TreeNode(9));
        //levelPrint(root);
        System.out.print(lowestCommonAncestor(root,new TreeNode(2),new TreeNode(4)).val);
    }
}
