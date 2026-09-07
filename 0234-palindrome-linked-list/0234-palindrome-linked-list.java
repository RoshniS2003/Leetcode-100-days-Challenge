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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        
        // 1. Find middle using fast & slow pointers
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // 2. Reverse second half of the list
        ListNode secondHalfHead = reverseList(slow);
        
        // 3. Compare first and second halves
        ListNode firstHalfHead = head;
        ListNode p2 = secondHalfHead;
        boolean result = true;
        
        while (p2 != null) {
            if (firstHalfHead.val != p2.val) {
                result = false;
                break;
            }
            firstHalfHead = firstHalfHead.next;
            p2 = p2.next;
        }
        
        // Optional: Restore list structure before returning
        reverseList(secondHalfHead);
        
        return result;
    }
    
    private ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}