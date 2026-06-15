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

       int length = getLength(head);
        return reverse(head,k,length);


    }

    private ListNode reverse(ListNode head,int k, int leftNodes) {
         if(leftNodes < k) {
            return head;
        }

        ListNode current = head;
        ListNode prev = null;
        int counter = k;
        while(counter > 0 && current!=null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
            counter--;
        }

        head.next = reverse(current,k,leftNodes-k);
        return prev;
    }


    private int getLength(ListNode node) {
        if(node==null) return 0;

        return getLength(node.next)+1;
    }

}
