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
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null){
            return res;
        }

        pathSum(root, targetSum, new ArrayList<Integer>());

        return res;
    }
    public void pathSum(TreeNode root, int targetSum, List list){

        // 当前值加入链表
        list.add(root.val);

        // 计算当前剩余目标值
        targetSum = targetSum - root.val;

        // 剩余目标值为0 且 当前节点为叶子节点
        if(targetSum == 0 && root.left == null && root.right == null){
            // 链表加入结果集
            res.add(list);
        }

        if(root.left != null){
            pathSum(root.left, targetSum, new ArrayList<Integer>(list));
        }
        if(root.right != null){
            pathSum(root.right, targetSum, list);
        }

    }
}
