import sun.reflect.generics.tree.Tree;

import java.net.BindException;
import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_Tree_Offer_26 {
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

    public static boolean isSubStructure(TreeNode A, TreeNode B) {

        return helper(A,B)||isSubStructure(index.left,B)||isSubStructure(index.right,B);
    }

    public static boolean helper(TreeNode A, TreeNode B){
        if(B == null) return true;
        if (A.val != B.val&&A == null){
            return false;
        }else{
            return helper(index.left,B.left)&&helper(index.right,B.right);
        }
    }
    static TreeNode index;
    public static void findHead(TreeNode root, TreeNode B){
        if (root == null){
            //index = null;
            return;
        }
        if (root.val == B.val){
            index = root;
            return;
        }
        findHead(root.left, B);
        findHead(root.right, B);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4,new TreeNode(1),new TreeNode(2));
        root.right = new TreeNode(5);

        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(1);
        levelPrint(root);
        System.out.print(isSubStructure(root,root2));
        int[] S = {1,2,3,4,5};
    }
}
