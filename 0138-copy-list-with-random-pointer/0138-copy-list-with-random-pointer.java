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
        if (head == null) return null;

        // Step 1: Create duplicate nodes and interweave them (A -> A' -> B -> B')
        Node curr = head;
        while (curr != null) {
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }

        // Step 2: Assign random pointers for the copied nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: Separate the original and copied lists cleanly
        curr = head;
        Node newHead = head.next;
        Node copyCurr = newHead;

        while (curr != null) {
            curr.next = curr.next.next;
            copyCurr.next = (copyCurr.next != null) ? copyCurr.next.next : null;

            curr = curr.next;
            copyCurr = copyCurr.next;
        }

        return newHead;
    }
}