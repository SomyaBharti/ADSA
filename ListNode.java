//237 leetcode
// Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

class delete {
    /** 
     * Deletes the given node (which is guaranteed not to be the tail).
     */
    public void deleteNode(ListNode node) {
        // Copy value from the next node
        node.val = node.next.val;
        // Bypass the next node
        node.next = node.next.next;
    }
}
