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
    // 记录总和
    int sum;

    public int sumNumbers(TreeNode root) {
        sum = 0;

        sumNumbers(root, 0);

        return sum;
    }
    
    // 深度优先遍历，num 存到根节点的值
    public void sumNumbers(TreeNode root, int num) {
        num = num * 10 + root.val;

        if(root.left == null && root.right == null){
            sum += num;
            return;
        }

        if(root.left != null){
            sumNumbers(root.left, num);
        }
        if(root.right != null){
            sumNumbers(root.right, num);
        }

    }
}
