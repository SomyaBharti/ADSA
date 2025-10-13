//328 leetcode
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
    public ListNode deleteDuplicates(ListNode head) {
        
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode prev = temp;
        
        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                // skip all nodes with this value
                int dup = head.val;
                while (head != null && head.val == dup) {
                    head = head.next;
                }
                prev.next = head;
            } else {
                // no duplicate for head
                prev = head;
                head = head.next;
            }
        }
        return temp.next;
    }
}
