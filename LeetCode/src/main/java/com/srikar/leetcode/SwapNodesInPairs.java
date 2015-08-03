/*

 Given a linked list, swap every two adjacent nodes and return its head.

 For example,
 Given 1->2->3->4, you should return the list as 2->1->4->3.

 Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

 */
package com.srikar.leetcode;

public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode swappedHead, node = head, nextNode, prevNode = null;
        
        if (head != null && head.next != null) {
            swappedHead = head.next;
        } else {
            swappedHead = head;
        }

        while (node != null && node.next != null) {
            nextNode = node.next;
            node.next = node.next.next;
            nextNode.next = node;
            if (prevNode != null) {
                prevNode.next = nextNode;
            }
            prevNode = node;
            node = node.next;
        }

        return swappedHead;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        
        ListNode node = head;
        System.out.println("Original list:");
        SwapNodesInPairs.printList(head);
        
        SwapNodesInPairs snip = new SwapNodesInPairs();
        ListNode updatedHead = snip.swapPairs(head);
        System.out.println("Updated list:");
        SwapNodesInPairs.printList(updatedHead);
    }

}
