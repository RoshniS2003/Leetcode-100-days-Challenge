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
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroupEnd = dummy;

        while (true) {
            // 1. Check if there are at least k nodes left
            ListNode kth = getKthNode(prevGroupEnd, k);
            if (kth == null) {
                break; // Fewer than k nodes remaining, stop
            }

            ListNode nextGroupStart = kth.next;
            ListNode curr = prevGroupEnd.next;
            ListNode prev = nextGroupStart;

            // 2. Reverse k nodes
            while (curr != nextGroupStart) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            // 3. Connect reversed group to previous group and advance pointer
            ListNode groupStart = prevGroupEnd.next;
            prevGroupEnd.next = kth;
            prevGroupEnd = groupStart;
        }

        return dummy.next;
    }

    private ListNode getKthNode(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }
}