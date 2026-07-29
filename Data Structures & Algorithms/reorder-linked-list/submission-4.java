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
        int n = getLength(head);
        ListNode middle=head;
        for(int i = 0; i < n/2;i++) {
            middle = middle.next;
        }
        

        ListNode secondHead = reverse(middle.next);
        middle.next = null;

        ListNode firstHead = head;
        boolean turn = false;
        while(firstHead != null && secondHead != null) {
            if(!turn) {
                ListNode temp = firstHead.next;
                firstHead.next = secondHead;
                firstHead = temp;
                turn = true;
            }  else {
                ListNode temp = secondHead.next;
                secondHead.next = firstHead;
                secondHead = temp;
                turn = false;
            }
        }
    }

    private int getLength(ListNode root) {
        if(root == null) {
            return 0;
        }
        return getLength(root.next)+1;
    }

    private ListNode reverse(ListNode root) {
        ListNode prev = null;
        while(root!=null) {
            ListNode temp = root.next;
            root.next = prev;
            prev = root;
            root = temp;
        }
        return prev;
    }
}
