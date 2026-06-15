/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) {
            return null;
        }

        createCopyNodes(head);
        copyArbitraryPointer(head);
        Node copyHead = head.next;
        reset(head);
        return copyHead;
    }

    private void createCopyNodes(Node head) {
        Node current = head;

        while(current != null) {
            Node next = current.next;

            Node node = new Node(current.val);
            current.next = node;
            node.next = next;

            current = next;
        }
    }

    private void copyArbitraryPointer(Node head) {
        Node current = head;

        while(current != null) {
            if(current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }
    }

    private void reset(Node head) {
        Node current = head;
        Node copy = current.next;

        while(copy!=null && current != null) {
            current.next = copy.next;
            if(copy.next!=null) {
                copy.next = copy.next.next;
            }

            current = current.next;
            copy = copy.next;
        }
    }

}
