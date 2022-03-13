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
class Solution { //递归调用
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}

 //循环
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null)return list2;
        if(list2 == null)return list1;
        ListNode list = new ListNode(-1), head = list;
        while(list1 != null ){
            while(list2 == null || list1.val <= list2.val){
                list.next = list1;
                list = list1;
                list1 = list1.next;
                if(list1 == null)break;
            }
            if( list2 == null )break;
            while(list1 == null || list1.val > list2.val){
                list.next = list2;
                list = list2;
                list2 = list2.next;
                if(list2 == null)break;
            }
        }
        return head.next;
    }
}

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode list = new ListNode(-1), head = list;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                list.next = list1;
                list = list1;
                list1 = list1.next;
            }
            else{
                list.next = list2;
                list = list2;
                list2 = list2.next;
            }
        }
        if(list1 == null){
            while(list2 != null){
                list.next = list2;
                list = list2;
                list2 = list2.next;
            }
        }
        if(list2 == null){
            while(list1 != null){
                list.next = list1;
                list = list1;
                list1 = list1.next;
            }
        }
        return head.next;
    }
}
