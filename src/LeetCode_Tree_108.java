import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_Tree_108 {
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

    public static TreeNode sortedArrayToBST(int[] nums) {

        return helper(nums,0,nums.length-1);
    }
    public static TreeNode helper(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        // 总是选择中间位置左边的数字作为根节点
        int mid = (left + right) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2,new TreeNode(0),new TreeNode(4,new TreeNode(3),new TreeNode(5)));
        root.right = new TreeNode(8, new TreeNode(7),new TreeNode(9));
        //levelPrint(root);
        //System.out.print(lowestCommonAncestor(root,new TreeNode(2),new TreeNode(4)).val);
        int[] S = {1,2,3,4,5};
        TreeNode T = sortedArrayToBST(S);
        levelPrint(root);
    }
}
