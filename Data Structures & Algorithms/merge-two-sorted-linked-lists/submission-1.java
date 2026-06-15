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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        merge(head,list1,list2);
        return head.next;
    }

    private void merge(ListNode head, ListNode list1, ListNode list2) {
        if(list1 == null && list2 == null) {
            return;
        } else if(list1 == null) {
            head.next = list2;
            merge(head.next,list1,list2.next);
            return;
        } else if(list2 == null) {
            head.next = list1;
            merge(head.next,list1.next,list2);
            return;
        }

        if(list1.val > list2.val) {
            head.next = list2;
            merge(head.next,list1,list2.next);
        } else {
            head.next = list1;
            merge(head.next,list1.next,list2);
        }

    }
}