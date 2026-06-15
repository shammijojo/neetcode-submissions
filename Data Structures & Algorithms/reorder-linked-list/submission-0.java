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
    public void reorderList(ListNode head) {
        ListNode middle = getMiddleNode(head);
        ListNode first = head;
        ListNode second = middle.next;
        middle.next = null;
        merge(first,reverse(second));        
    }

    private ListNode getMiddleNode(ListNode node) {
        ListNode slow = node, fast = node.next;

        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private void merge(ListNode first, ListNode second) {
        ListNode current = first, prev = null;
        boolean firstTurn = true;
        while(first!=null || second!=null) {
            ListNode temp = current.next;

            if(firstTurn) {
                current.next = second;
                current = second;
                first = temp;
                firstTurn =  false;
            } else {
                current.next = first;
                current = first;
                second = temp;
                firstTurn  = true;
            }
        }
    }

    private ListNode reverse(ListNode node) {
        ListNode current = node, prev = null;
        ListNode temp = null;
        while(current != null) {
            temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }

}
