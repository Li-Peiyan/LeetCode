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

    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, 0, n);
    }
    // index 前序对应位置， [left, right) 中序遍历根节点左、右子树对应的范围
    public TreeNode buildTree(int[] preorder, int[] inorder, int index, int left, int right){
        if(right <= left || index >= preorder.length ){
            return null;
        }
        TreeNode node = new TreeNode();
        int i = indexMap.get(preorder[index]);
        // 存入当前节点
        node.val = inorder[i];
        // 构建左右节点
        node.left = buildTree(preorder, inorder, index + 1, left, i);
        node.right = buildTree(preorder, inorder, index +1+(i-left), i+1, right); 
        
        return node;
    }
}
