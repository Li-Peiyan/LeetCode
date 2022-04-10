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
    public int minDepth(TreeNode root) {
        if(root == null)return 0;

        int n = 1;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int num;

        while(!deque.isEmpty()){

            num = deque.size();

            for(int i = 0; i < num; ++i){
                TreeNode node = deque.poll();
                if(node.left == null && node.right == null){
                    return n;
                }
                else{
                    if(node.left != null){
                        deque.offer(node.left);
                    }
                    if(node.right != null){
                        deque.offer(node.right);
                    }
                }
            }
            n++;
        }
        
        return n;
    }
 
}
