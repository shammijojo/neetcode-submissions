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
        ListNode middle = getMiddleElement(head);
        ListNode list = middle.next;
        middle.next = null;

        // System.out.println(middle.val+" "+list.val);

        // ListNode node = head;
        // while(node != null) {
        //     System.out.println(node.val);
        //     node = node.next;
        // }

        list = reverse(null, list);

        // node = list;
        // while(node != null) {
        //     System.out.println(node.val);
        //     node = node.next;
        // }



        ListNode node = new ListNode();
        merge(node,head,list,true);
    }


    private ListNode getMiddleElement(ListNode head) {
        ListNode slow = head, fast = head.next;
        ListNode prev = null;

        while(fast != null && fast.next!=null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode reverse(ListNode prev, ListNode current) {
        if(current == null) {
            return prev;
        }

        ListNode head = reverse(current, current.next);
        current.next = prev;
        return head;
    }

    private void merge(ListNode head, ListNode list1, ListNode list2,boolean bool) {
        if(!(list1 != null || list2 != null)) {
            return;
        }

        if(bool) {
            head.next = list1;
            merge(head.next, list1.next, list2, !bool);
        } else {
            head.next = list2;
            merge(head.next, list1, list2.next,!bool);
        }
    }


}
