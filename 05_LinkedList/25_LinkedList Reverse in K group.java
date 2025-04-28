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
        if(head == null){
            return null;
        }
        ListNode curr = head, prev = null;
        int count = k;
        while(curr != null && count > 0){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            count--;
        }
        if(curr == null && count >0){
            curr = prev;
            prev = null;
            while(curr != null){
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
        }
        if(count > 0){
            return prev;
        }else{
            head.next = reverseKGroup(curr, k);
        }
        return prev;
    }
}
