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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null){
            return false;
        }
        // 计算当前剩余目标值
        targetSum = targetSum - root.val;

        // 剩余目标值为0 且 当前节点为叶子节点
        if(targetSum == 0 && root.left == null && root.right == null){
            return true;
        }

        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);

    }

}
