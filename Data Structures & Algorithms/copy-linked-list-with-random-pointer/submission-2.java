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
        createCopyNodes(head);

        Node node = head;
        while(node != null) {
            Node temp = node.random;
            if(temp != null) {
                node.next.random = temp.next;
            }
            node = node.next.next;
        }


        Node dummy = new Node(0);
        dummy.next = head;

        node = dummy;
        while(node != null && node.next != null) {
            Node temp = node.next;
            node.next = temp.next;
            temp.next = null;
            node = node.next;
        }

        return dummy.next;
    }

    private void createCopyNodes(Node head) {
        Node node = head;

        while(node != null) {
            Node n = new Node(node.val);
            n.next = node.next;
            node.next = n;
            node = n.next;
        }
    }
}
