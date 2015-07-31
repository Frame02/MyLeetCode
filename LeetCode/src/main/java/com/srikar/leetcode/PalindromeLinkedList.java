/*

 Given a singly linked list, determine if it is a palindrome.

 Follow up:
 Could you do it in O(n) time and O(1) space?

 */
package com.srikar.leetcode;

public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        boolean result = true;
        int size = 0;
        ListNode node;

        if (head != null) {
            //Calculate the size of the list
            for (node = head; node != null; node = node.next) {
                ++size;
            }

            int halfSize = size >> 1;
            node = head;

            // Tracverse half way through the list
            for (int i = 0; i < halfSize; ++i) {
                node = node.next;
            }

            ListNode nextNode = node.next;
            node.next = null;

            // Reverse the links
            while (nextNode != null) {
                ListNode temp = nextNode.next;
                nextNode.next = node;
                node = nextNode;
                nextNode = temp;
            }
            //Now, "node" refers to the tail node of original list.

            //Compare the first half and the latter half of the list element by element traversing in opposite directions
            ListNode node2 = head;
            for (int i = 0; i < halfSize; ++i) {
                if (node.val != node2.val) {
                    result = false;
                    break;
                }
                node2 = node2.next;
                node = node.next;
            }
        }

        return result;
    }

    private void buildList(ListNode headNode, int[] elements) {
        for (int element : elements) {
            ListNode node = new ListNode(element);
            headNode.next = node;
            headNode = node;
        }
    }

    public static void main(String[] args) {
        int[] elements = new int[]{2, 3, 4, 2, 1};
        PalindromeLinkedList pll = new PalindromeLinkedList();
        ListNode head = new ListNode(1);
        pll.buildList(head, elements);
        System.out.println("Is Palindrom Linked List? " + pll.isPalindrome(null));
    }
}
