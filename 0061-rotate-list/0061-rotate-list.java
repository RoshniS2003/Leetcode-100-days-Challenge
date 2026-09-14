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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // 1. Calculate the length and find the current tail
        ListNode tail = head;
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // 2. Compute actual rotations needed
        k = k % length;
        if (k == 0) {
            return head;
        }

        // 3. Connect tail to head to make it circular
        tail.next = head;

        // 4. Find the new tail: (length - k) steps from head
        int stepsToNewTail = length - k;
        ListNode newTail = head;
        for (int i = 1; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        // 5. Break the cycle and return the new head
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}