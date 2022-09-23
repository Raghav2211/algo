package com.github.devraghav.linkedlist;


import com.github.devraghav.linkedlist.ListNode;

public class DeleteNode {

    public void delete(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;

    }
}
