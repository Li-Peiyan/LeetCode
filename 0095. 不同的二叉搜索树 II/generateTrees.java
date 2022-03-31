/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
          if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return creatTrees(1, n);
    }
    public List<TreeNode> creatTrees(int left, int right){
        List<TreeNode> tree = new LinkedList<TreeNode>();
        
        if(left > right){
            tree.add(null);
            return tree;
        }

        for(int i = left; i <= right; ++i){
            //创建左子树集合
            List<TreeNode> treeLeft = creatTrees(left, i - 1);
            //创建右子树集合
            List<TreeNode> treeRight = creatTrees(i + 1, right);

            //创建树集合
            for(TreeNode nodeL : treeLeft){
                for(TreeNode nodeR : treeRight){
                    tree.add(new TreeNode(i, nodeL, nodeR));
                }
            }
        }
        return tree;
    }
}
