/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if (head == null) return head;

        Node curr = head;

        while (curr != null) {
            // Case 1: If current node has no child, move to next node
            if (curr.child == null) {
                curr = curr.next;
                continue;
            }

            // Case 2: Node has a child list
            Node childHead = curr.child;

            // Find the tail of the child list
            Node childTail = childHead;
            while (childTail.next != null) {
                childTail = childTail.next;
            }

            // Connect child tail to curr.next if curr.next exists
            if (curr.next != null) {
                childTail.next = curr.next;
                curr.next.prev = childTail;
            }

            // Connect curr to child head
            curr.next = childHead;
            childHead.prev = curr;

            // Clear the child pointer
            curr.child = null;

            // Advance curr pointer
            curr = curr.next;
        }

        return head;
    }
}