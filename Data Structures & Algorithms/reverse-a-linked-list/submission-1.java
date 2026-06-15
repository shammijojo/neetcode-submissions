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
    public ListNode reverseList(ListNode head) {
        return reverseList(null,head);
    }

    private ListNode reverseList(ListNode prev, ListNode current) {
        if(current == null) {
            return prev;
        }

        ListNode head = reverseList(current, current.next);
        current.next = prev;
        return head;
    }
}
