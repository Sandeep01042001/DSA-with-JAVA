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
        
        // Find the length of the list
        int length = 1;
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
            length++;
        }
        
        // Connect last node to head to make it circular
        temp.next = head;
        
        // Find new head after rotation
        k = k % length; // if k > length
        int stepsToNewHead = length - k;
        ListNode newTail = temp;
        
        while (stepsToNewHead-- > 0) {
            newTail = newTail.next;
        }
        
        ListNode newHead = newTail.next;
        newTail.next = null; // break the circle
        
        return newHead;

    }
}
