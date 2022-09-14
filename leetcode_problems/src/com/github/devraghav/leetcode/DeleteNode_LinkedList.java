package com.github.devraghav.leetcode;



public class DeleteNode_LinkedList {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;

    }
}
