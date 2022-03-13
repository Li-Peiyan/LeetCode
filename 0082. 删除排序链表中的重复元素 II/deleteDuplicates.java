 /* Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)return head;
        ListNode h = new ListNode();
        h.next = head;
        ListNode h0 = h, h1 = head, h2 = head.next;
        while(h2 != null){
            if(h2.val == h1.val){
                while(h2 != null && h2.val == h1.val){
                    h2 = h2.next;
                }
                h0.next = h2;
                if(h2 == null)break;
            }else{
                h0 = h1;
            }
            
            h1 = h2;
            h2 = h1.next;
        }
        return h.next;
    }
}
