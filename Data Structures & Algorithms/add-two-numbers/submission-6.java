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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = getLength(l1);
        int len2 = getLength(l2);

        if(len1 > len2) {
            addZeroes(l2,l1);
        } else if(len1 < len2) {
            addZeroes(l1,l2);
        }

        add(l1,l2,0);
        return l1;
    }

    private int getLength(ListNode head) {
        if(head == null) {
            return 0;
        }

        return getLength(head.next)+1;
    }

    private void addZeroes(ListNode l1, ListNode l2) {
        while(l1.next != null) {
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l2.next != null) {
            l1.next = new ListNode(0);
            l1 = l1.next;
            l2 = l2.next;
        }
    }

    private ListNode add(ListNode l1,ListNode l2, int carry) {
        if(l1 == null) {
            if(carry == 1) {
                return new ListNode(1);
            }
            return null;
        }

        System.out.println(l1.val);
        System.out.println(l1.val+" "+l2.val+" "+carry);
        int sum = l1.val+l2.val+carry;
        if(sum > 9) {
            l1.val = sum%10;
            l1.next = add(l1.next,l2.next,1);
        } else {
            l1.val = sum;
            l1.next = add(l1.next,l2.next,0);
        }

        return l1;
    }




}
