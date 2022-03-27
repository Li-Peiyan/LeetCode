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
    public ListNode partition(ListNode head, int x) {
        ListNode smallH1 = new ListNode(0);
        ListNode n1 = smallH1;
        ListNode bigH2 = new ListNode(0);
        ListNode n2 = bigH2;
        while(head != null){
            if(head.val < x){
                n1.next = head;
                n1 = n1.next;
            }else{
                n2.next = head;
                n2 = n2.next;
            }
            head = head.next;
        }
        n1.next = bigH2.next;
        n2.next = null;
        return smallH1.next; 
    }
}
