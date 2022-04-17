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
    public void flatten(TreeNode root) {
        // 节点为空说明到叶子节点了
        if(root == null){
            return;
        }

        // 左节点不为空时需要交换节点
        if(root.left != null){
          
            TreeNode node = root.left;
            // 找到左子树的最右节点
            while(node.right != null){
                node = node.right;
            }

            // 右子树接到 左子树的最右节点 的 右子树上
            // 左子树接到 右子树
            // 左子树置空
            node.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        // 继续展开右子树
        flatten(root.right);
    }
}
