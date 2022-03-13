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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int n=0;
        ListNode add = new ListNode(0), head = add;
        while(l1!=null || l2!=null || n!=0)
        {
            if(l1 != null){
                n+=l1.val;
                l1=l1.next;
            }
            if(l2 != null)
            {
                n+=l2.val;
                l2=l2.next;
            }
            add.next=new ListNode( n%10 );
            n=n/10;
            add=add.next;
        }
        return head.next;
    }
}
