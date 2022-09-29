package com.github.devraghav.linkedlist;

public class Palindrome {
    private ListNode node;

    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode slow = head;
        ListNode fast = head;

        // Reach middle node
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // reverse pointer from middle to end
        ListNode prevNode = null;
        while (slow != null) {
            var nextNode = slow.next;
            slow.next = prevNode;
            prevNode = slow;
            slow = nextNode;
        }

        // match head-> & <-end
        ListNode left = head;
        ListNode right = prevNode;

        while (right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }


    public boolean isPalindromeV2(ListNode head) {
        if (head == null) return true;
        node = head;
        return isPalindromeRecursive(head);
    }

    public boolean isPalindromeRecursive(ListNode head) {
        if (head == null) return true;
        boolean isPalindrome = isPalindromeRecursive(head.next);
        if (isPalindrome) {
            boolean condition = node.val == head.val;
            node = node.next;
            return condition;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        Palindrome palindrome = new Palindrome();
        System.out.println(palindrome.isPalindromeV2(head));
        System.out.println(palindrome.isPalindrome(head));


        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(2);
        System.out.println(palindrome.isPalindromeV2(head));
        System.out.println(palindrome.isPalindrome(head));

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        System.out.println(palindrome.isPalindromeV2(head));
        System.out.println(palindrome.isPalindrome(head));


        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(1);
        System.out.println(palindrome.isPalindromeV2(head));
        System.out.println(palindrome.isPalindrome(head));

    }


}
