package Tree;

import java.util.*;

public class LeetCode_Tree_501 {
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

    public static int[] findMode(TreeNode root) {
        helper(root);
        List<Integer> res = new ArrayList<>();
        int max = 0;
        for (int key : map.keySet()){
            System.out.println("kye:"+key+"value:"+map.get(key));
            if (map.get(key) >= max){
                max = map.get(key);
                //res.add(key);
            }
        }
        for (int key : map.keySet()){
            //System.out.println("kye:"+key+"value:"+map.get(key));
            if (map.get(key) == max){
                //max = map.get(key);
                res.add(key);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    static HashMap<Integer, Integer> map = new HashMap<>();
    public static void helper(TreeNode root){
        if (root == null){
            return;
        }
        map.put(root.val,map.getOrDefault(root.val,0)+1);
        helper(root.left);
        helper(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(3,null,new TreeNode(2,null,new TreeNode(1)));
        root.right = new TreeNode(5, new TreeNode(2),new TreeNode(4));
        levelPrint(root);
        int[] S = findMode(root);
        for(int i : S){
            System.out.print(i);
        }
        //System.out.print(hasPathSum(root,10));
    }
}
