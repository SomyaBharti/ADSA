// 724 leetcode
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class pivotIndex {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        // Move fast twice as fast as slow
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // They meet => has a cycle
            if (slow == fast) {
                return true;
            }
        }

        // fast reached end => no cycle
        return false;
    }
}

