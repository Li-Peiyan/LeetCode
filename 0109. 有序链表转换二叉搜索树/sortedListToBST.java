/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    // 全局
    ListNode headGlobal;

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null ){
            return null;
        }
        headGlobal = head;

        // 计算链表长度
        int len = 0;
        while(head != null){
            len++;
            head = head.next;
        }
        
        return sortedListToBST(0, len - 1 );

    }
    public TreeNode sortedListToBST(int left, int right){
        // left > right 为空节点
        if(left > right){
            return null;
        }
        // 计算中间节点
        int mid = left + ((right - left) >> 1 );
        

        TreeNode tree = new TreeNode();

        // 中序遍历
        tree.left = sortedListToBST(left, mid - 1 );
        
        // 赋值
        tree.val = headGlobal.val;
        headGlobal = headGlobal.next;

        tree.right = sortedListToBST(mid + 1, right );

        return tree;

    }

}
