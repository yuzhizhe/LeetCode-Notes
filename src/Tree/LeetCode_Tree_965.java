package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode_Tree_965 {
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

    public static int sumRootToLeaf(TreeNode root) {
        if(root == null){
            return 0;
        }
        helper(root,new String());
        return sumInt;
    }

    static List<String> list = new ArrayList<>();
    static int sumInt = 0;
    public static void helper(TreeNode root, String sum){
        if(root == null){
            return;
        }
        StringBuilder mSum = new StringBuilder(sum);
        mSum.append(root.val);
        if (root.left == null && root.right == null){
            sumInt = sumInt + BitToInt(mSum.toString());
            return;
        }else{
            //mSum.append("-");
            helper(root.left,mSum.toString());
            helper(root.right,mSum.toString());
        }
    }

    public static int BitToInt(String s){
        return Integer.parseInt(s,2);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        //root.right = new TreeNode(1, new TreeNode(0),new TreeNode(1));
        //levelPrint(root);
        System.out.print(sumRootToLeaf(root));
    }
}
