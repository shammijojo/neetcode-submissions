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
        ListNode last = null, temp = null;
        ListNode node = head;

        while(node!=null) {
            temp = node.next;
            node.next = last;
            last = node;
            node = temp;
        }

        return last;
        

    }
}
