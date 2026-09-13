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

        // 1. Calculate the length of the list and find the tail
        ListNode tail = head;
        int length = 1;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // 2. Normalize k using modulo
        k = k % length;
        if (k == 0) {
            return head;
        }

        // 3. Connect the tail to the head to form a circular list
        tail.next = head;

        // 4. Find the new tail: (length - k) steps from head
        int stepsToNewTail = length - k;
        ListNode newTail = head;
        for (int i = 1; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        // 5. Break the cycle and assign the new head
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}