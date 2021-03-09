import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_Tree_559 {
    static class TreeNode {
        public int val;
        public List<TreeNode> children;

        public TreeNode() {}

        public TreeNode(int _val) {
            val = _val;
        }

        public TreeNode(int _val, List<TreeNode> _children) {
            val = _val;
            children = _children;
        }
    }

    public static int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.children.isEmpty()){
            return 1;
        }
        List<Integer> depths = new LinkedList<>();
        for (TreeNode tree : root.children){
            depths.add(maxDepth(tree));
        }
        return Collections.max(depths)+1;
    }

    public static void main(String[] args) {

    }
}
