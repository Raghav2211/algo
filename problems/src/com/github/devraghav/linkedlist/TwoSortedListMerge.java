package com.github.devraghav.linkedlist;

import java.util.StringJoiner;

public class TwoSortedListMerge {

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

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        TwoSortedListMerge merge_2_sorted_linkedList = new TwoSortedListMerge();
        ListNode mergedListNodeHead = merge_2_sorted_linkedList.merge(list1, list2);
        StringJoiner stringJoiner = new StringJoiner(",");
        while (mergedListNodeHead != null) {
            stringJoiner.add(String.valueOf(mergedListNodeHead.val));
            mergedListNodeHead = mergedListNodeHead.next;
        }
        System.out.println(stringJoiner);

    }
}
