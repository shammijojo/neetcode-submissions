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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode current = head;
        int pos = 1;
        ListNode leftNode = null;
        ListNode leftParent = null;
        ListNode rightNode = null;
        ListNode prev = null;

        while(current != null) {
            if(pos == left) {
                leftParent = prev;
                leftNode = current;
            } if(pos == right) {
                rightNode = current;
            }
            pos++;
            prev = current;
            current = current.next;
        }

        ListNode rightNext = rightNode.next;
        reverse(leftNode,rightNode).next = rightNext;

        if(leftParent == null) {
            return rightNode;
        }

        leftParent.next = rightNode;
        return head;
    }

    private ListNode reverse(ListNode node, ListNode lastNode) {
        if(node == lastNode) {
            return node;
        }

        reverse(node.next,lastNode).next = node;
        return node;
    }
}