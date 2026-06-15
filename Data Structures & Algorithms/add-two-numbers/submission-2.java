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
        int length1 = getLength(l1);
        int length2 = getLength(l2);

        if(length1 > length2) {
            addTrailingZeroes(l2,length1-length2);
        } else if(length2 > length1) {
            addTrailingZeroes(l1,length2-length1);
        }

        System.out.println(getLength(l1)+" "+getLength(l2));

        add(l1,l2,0);
        return l1;
    }

    private int getLength(ListNode node) {
        if(node == null) return 0;
        return getLength(node.next)+1;
    }

    private void addTrailingZeroes(ListNode node, int n) {
        while(node.next != null) {
            node = node.next;
        }

        for(int i = 0; i < n; i++){
            node.next = new ListNode(0);
            node = node.next;
        }
    }

    private ListNode add(ListNode node1, ListNode node2, int carry) {
        if(node1 == null) {
            if(carry == 1)
            return new ListNode(1);
            return null;
        }

        int sum = node1.val+node2.val+carry;
        if(sum >= 10) {
            node1.val = sum%10;
            carry = 1;
        } else {
            node1.val = sum;
            carry = 0;
        }
        node1.next = add(node1.next,node2.next,carry);
        return node1;
    }


}
