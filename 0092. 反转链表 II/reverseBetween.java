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
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode h = new ListNode(0, head);
        head = h;
        ListNode h1;
        ListNode n1, n2, n3;
        
        // 先找到 left 的前一个指针，存于 h1
        for(int i = 1; i < left; ++i){
            h = h.next;
        }
        h1 = h;
        
        // 三个指针分别存 当前更改连线的节点、其上一个节点、下一个节点
        n1 = h1;
        n2 = n1.next;
        n3 = n2.next; 
        for(int i = left; i < right; ++i){
            n1 = n2;
            n2 = n3;
            n3 = n3.next;
            n2.next = n1;
        }

        // 头尾连接
        n1 = h1.next;
        n1.next = n3;
        h1.next = n2;

        return head.next;

    }
}
