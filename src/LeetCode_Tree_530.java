import java.util.*;

public class LeetCode_Tree_530 {
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

    public static int getMinimumDifference(TreeNode root) {
        helper(root);
        for (int i = 0; i < list.size()-1; i++){
            int mMin = Math.abs(list.get(i)- list.get(i+1));
            if(mMin<min){
                min = mMin;
            }
        }
        return min;
    }
    static List<Integer> list = new ArrayList<>();
    static int min = Integer.MAX_VALUE;
    public static void helper(TreeNode root){
        if (root == null){
            return;
        }
        helper(root.left);
        list.add(root.val);
        helper(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        //root.left = new TreeNode(3,null,new TreeNode(2,null,new TreeNode(1)));
        root.right = new TreeNode(5, new TreeNode(3),null);
        levelPrint(root);
        int S = getMinimumDifference(root);
        System.out.println(S);
    }
}
