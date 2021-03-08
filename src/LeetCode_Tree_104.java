import java.util.LinkedList;
import java.util.Queue;

public class LeetCode_Tree_104 {
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

    //广度优先
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }

    //深度优先
    public static int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }else{
            int left = maxDepth2(root.left);
            int right = maxDepth2(root.right);
            return Math.max(left, right)+1;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2,new TreeNode(4),new TreeNode(5));
        root.right = new TreeNode(3,new TreeNode(6),new TreeNode(7));
        System.out.println(maxDepth(root));
    }
}
