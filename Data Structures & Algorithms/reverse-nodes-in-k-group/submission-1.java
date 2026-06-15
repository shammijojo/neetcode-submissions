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
    public ListNode reverseKGroup(ListNode head, int k) {
        int len = getLen(head);
        return reverse(head,k,len,len);
    }

    private ListNode reverse(ListNode head, int k, int total, int left) {
        int count = 0;

        if(left < k) {
            return head;
        }

        ListNode node = head;
        ListNode prev = null;
        while(count < k && node != null) {
            ListNode temp = node.next;
            node.next=prev;
            prev = node;
            node = temp;
            count++;
        }

        if(node != null)
        head.next = reverse(node, k, total, total-k);
        return prev;
    }

    private int getLen(ListNode node) {
        if(node == null) return 0;
        return getLen(node.next)+1;
    }
}
