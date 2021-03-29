import java.util.List;
import java.util.ArrayList;

public class LeetCode_Tree_94 {

	public static class TreeNode{
		private int val;
		private TreeNode left;
		private TreeNode right;
		
		public TreeNode(){}
		
		public TreeNode(int value){
			this.val = value;
		}
		
		public TreeNode(int root, TreeNode left, TreeNode right){
			this.val = root;
			this.left = left;
			this.right = right;
		}
	}
	

	static List<Integer> list = new ArrayList<>();
	public static List<Integer> inorderTraversal(TreeNode root){
		if(root == null){
			return null;
		}
		if(root.left != null){
			inorderTraversal(root.left);
		}
		list.add(root.val);
		if(root.right != null){
			inorderTraversal(root.right);
		}
		return list;
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2, new TreeNode(3), new TreeNode(4));
		root.right = new TreeNode(5, new TreeNode(6), new TreeNode(7));
		inorderTraversal(root);
		for(int index : list){
			System.out.println(index);
		}
	}
}