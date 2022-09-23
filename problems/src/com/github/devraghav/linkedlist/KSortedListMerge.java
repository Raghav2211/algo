package com.github.devraghav.linkedlist;

public class KSortedListMerge {

    public ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        ListNode head = new ListNode();
        ListNode mergeList = head;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                mergeList.next = list1;
                list1 = list1.next;
            } else {
                mergeList.next = list2;
                list2 = list2.next;
            }
            mergeList = mergeList.next;
        }
        if (list1 != null) {
            mergeList.next = list1;
        } else {
            mergeList.next = list2;
        }
        return head.next;
    }

    public ListNode merge(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        ListNode head = merge(lists[0], lists[1]);
        for (int i = 2; i < lists.length; i++) {
            head = merge(head, lists[i]);
        }
        return head;
    }
}
