//Given the head of a linked list, remove the nth node from the end of the list and return its head.

public class Problem19 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // set new dummy node at the beginning and two pointers: slow(at the dummy) and fast(next one, head)
        ListNode dummy = new ListNode(0, head);
        ListNode slow = dummy;
        ListNode fast = head;
        // move fast pointer until n is zero (shifted fast pointer n times)
        while (fast != null && n > 0) {
            fast = fast.next;
            n -= 1;
        }
        // move both pointers until fast pointer reaches end of list
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // remove link between slow and fast pointer node
        slow.next = slow.next.next;
        // return next node from dummy to return correct list
        return dummy.next;
    }
}
