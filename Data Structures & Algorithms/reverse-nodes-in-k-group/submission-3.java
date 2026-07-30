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
        int n = getLength(head);
        return reverse(head,k,n);
    }

    private ListNode reverse(ListNode root, int k, int nodesLeft) {
        if(nodesLeft < k) {
            return root;
        }


        int x = k;
        ListNode prev = null;
        ListNode current = root;
        ListNode tempHead = root;

        while(x > 0) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
            nodesLeft--;
            x--;
        }

        tempHead.next = reverse(current,k,nodesLeft);

        return prev;
    }

    private int getLength(ListNode root) {
        if(root == null) {
            return 0;
        }
        return getLength(root.next)+1;
    }
}
