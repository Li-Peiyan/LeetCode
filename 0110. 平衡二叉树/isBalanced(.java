/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode leftH;
 *     TreeNode rightH;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode leftH, TreeNode rightH) {
 *         this.val = val;
 *         this.leftH = leftH;
 *         this.rightH = rightH;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null)return true;
        // 深度优先遍历
        return dfs(root) > 0;
    }
    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftH = dfs(root.left);
        int rightH = dfs(root.right);

        // 子树不平衡时返回 -1
        if( leftH == -1 || rightH == -1 || Math.abs(leftH - rightH) > 1 )return -1;

        if(leftH > rightH)return leftH+1;
        else return rightH+1;

    }
}
