import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode_Tree_257 {
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

    public static List<String> binaryTreePaths(TreeNode root) {
        if (root == null){
            return list;
        }
        if (root.left == null && root.right == null){
            list.add(root.val+"");
            return list;
        }
        helper(root,new String());
        return list;
    }

    static List<String> list = new ArrayList<>();
    public static void helper(TreeNode root,String sum) {
        if (root == null){
            return;
        }

        if (root.left == null && root.right == null){
            sum = sum + "->"+ root.val;
            list.add(sum);
            return;
        }
        if(sum.equals("")){
            sum = root.val+"";
        }else{
            sum = sum + "->"+ root.val;
        }
        helper(root.left,sum);
        helper(root.right,sum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        //root.left = new TreeNode(3,new TreeNode(4),new TreeNode(2));
        root.right = new TreeNode(5);
        levelPrint(root);
        List<String> list = binaryTreePaths(root);
        System.out.print(list.size());
    }
}
