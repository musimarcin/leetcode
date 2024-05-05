//You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
//
//Merge all the linked-lists into one sorted linked-list and return it.

import java.util.ArrayList;
import java.util.HashMap;

public class Problem23 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0) return new ListNode().next;

        for (int i = 1; i < lists.length; i++) {
            lists[0] = mergeTwoLists(lists[0], lists[i]);
        }

        return lists[0];
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        if (list1 != null) tail.next = list1;
        else if (list2 != null) tail.next = list2;

        return dummy.next;
    }
}
