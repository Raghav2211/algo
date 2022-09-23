package com.github.devraghav.linkedlist;


public class OddEvenSequence {
    //[1,2,3,4,5]
    //[1,3,5,2,4]
    //[1,2,3,4,5,6,7,8]
    public ListNode generate(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return head;
        ListNode oddList = head;
        ListNode even = head.next;
        ListNode evenList = even;
        while (evenList != null && evenList.next != null) {
            oddList.next = oddList.next.next;
            oddList = oddList.next;
            evenList.next = evenList.next.next;
            evenList = evenList.next;
        }
        oddList.next = even;
        return head;

    }
}
