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
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }
    // 对比传入的两个节点的数是否相等
    public boolean isSymmetric(TreeNode leftNode, TreeNode rightNode) {
        if(leftNode == null && rightNode == null){
            return true;
        }
        if(leftNode != null && rightNode != null && leftNode.val == rightNode.val){
            // 递归对比对称结点
            return isSymmetric(leftNode.left, rightNode.right) && isSymmetric(leftNode.right, rightNode.left);
        }
        return false;
    }
}
