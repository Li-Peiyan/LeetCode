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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null)return head;
        ListNode h = new ListNode(0, head);
        int num = 0;
        while(h.next != null){
            h = h.next;
            ++num;//计数
        }
        if(k >= num){//当k大于节点数时取余数
            k %= num;
            if(k == 0)return head;
        }
        h.next = head;//首尾相连
        num -= k;//计算旋转前一位的位置
        while(num != 0){//取旋转前一位
            h = h.next;
            --num;
        }
        head = h.next;//设置头节点
        h.next =null;//断开连接
        return head;
    }
}
