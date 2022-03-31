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
    public void recoverTree(TreeNode root) {
        List<TreeNode> tree = new ArrayList<>();
        //中序遍历，从小到大排列
        recoverTree(root, tree);
        int i;
         //找到第一个位置错误节点 i
        for(i = 0; i < tree.size() - 1; ++i){
            if(tree.get(i).val > tree.get(i + 1).val){
                break;
            }
        }
        //封住末尾
        tree.add(new TreeNode(Integer.MAX_VALUE));
        //第二个错误节点位置 j-1，第一个大于 i节点值的前一位（j-1）
        for(int j = i + 1; j < tree.size(); ++j){
            if(tree.get(i).val < tree.get(j).val){
                int val = tree.get(i).val;
                tree.get(i).val = tree.get(j - 1).val;
                tree.get(j - 1).val = val;
                break;
            }
        }
    }
    public void recoverTree(TreeNode node, List<TreeNode> tree){
        if (node == null) {
            return;
        }
        recoverTree(node.left, tree);
        tree.add(node);
        recoverTree(node.right, tree);
    }
}
