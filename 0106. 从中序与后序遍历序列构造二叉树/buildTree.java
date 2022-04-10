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
    HashMap<Integer, Integer> hashMap = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;

        for(int i = 0; i < len; ++i){
            // 存中序遍历值对应下标
            hashMap.put(inorder[i], i);
        }
        // 后序遍历 尾开始 第一个位于 中序遍历 左区间 或 右区间 的节点 必是其区间的 根节点
        return buildTree(inorder, postorder, len - 1, 0, len);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder, int index, int left, int right){
        if(right <= left || index < 0 ){
            return null;
        }

        int i = hashMap.get(postorder[index]);
        TreeNode node = new TreeNode();

        // 判断是否在区间内
        if( left <= i && i < right){
            node.val = inorder[i];
            node.left = buildTree(inorder, postorder, index - 1, left, i);
            node.right = buildTree(inorder, postorder, index - 1, i+1, right);

        }else{
            // 不在区间则后续遍历节点继续移动
            for(int j = index - 1; j >= 0; j--){
                i = hashMap.get(postorder[j]);
                // 判断是否在区间内
                if(left <= i && i < right){
                    node.val = inorder[i];
                    node.left = buildTree(inorder, postorder, j - 1, left, i);
                    node.right = buildTree(inorder, postorder, j - 1, i+1, right);
                    break;
                }
            }
        }
        return node;
        
    }
}
