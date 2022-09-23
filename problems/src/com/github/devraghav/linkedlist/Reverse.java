package com.github.devraghav.linkedlist;


public class Reverse {
    //[1,2,3,4,5]
    public ListNode reverse(ListNode head) {
        ListNode prevNode = null;
        while (head != null) {
            ListNode next = head.next;//2,3
            head.next = prevNode;//1-> null , 2->1->null
            prevNode = head;// 1 , 2
            head = next; // 2 ,3
        }
        return prevNode;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        Reverse reverse_linkedList = new Reverse();
        System.out.println(reverse_linkedList.reverse(listNode).val);
    }
}
