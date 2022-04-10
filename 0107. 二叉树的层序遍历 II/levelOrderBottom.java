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

    List<List<Integer>> list;

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        list = new ArrayList<>();

        if(root == null){
            return list;
        }
        // 深度优先遍历
        dfs(root, 0);

        List<List<Integer>> res = new ArrayList<>();
        int n = list.size();

        while(n > 0){
            n--;
            res.add(list.get(n));
        }

        return res;
    }

    private void dfs(TreeNode root, int depth){
        
        if(root == null){
            return ;
        }

        if(list.size() == depth){
            list.add(new ArrayList<Integer>());
        }

        list.get(depth).add(root.val);
        dfs(root.left, depth+1);
        dfs(root.right, depth+1);

    }
}
