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
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        midSearch(root, list);
        int n = list.get(0), m;
        for(int i = 1; i < list.size(); ++i){
            m = list.get(i);
            if(n < m){
                n = m;
            }else{
                return false;
            }
        }
        return true;
    }
    public void midSearch(TreeNode root, List<Integer> list){
        if(root.left != null)midSearch(root.left, list);
        list.add(root.val);
        if(root.right != null)midSearch(root.right, list);
    }
}
