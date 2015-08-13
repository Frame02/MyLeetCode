/*

 Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

 You must do this in-place without altering the nodes' values.

 For example,
 Given {1,2,3,4}, reorder it to {1,4,2,3}. 

 */
package com.srikar.leetcode;

/**
 *
 * @author vedantas
 */
public class ReorderList {

    public void reorderList(ListNode head) {
        // Ensure that the list has at least two nodes
        if (head != null && head.next != null) {
            ListNode node = head, tmp, tail;
            // Traverse to the end of the list and find its size
            int size = 1;
            while (node.next != null) {
                node = node.next;
                ++size;
            }
            tail = node;

            // Traverse the former half
            node = head;
            int halfSize = size >> 1;
            --halfSize;
            for (int i = 0; i < halfSize; ++i) {
                node = node.next;
            }

            // Reverse the links of the latter half
            ListNode nextNode = node.next;
            do {
                tmp = nextNode.next;
                nextNode.next = node;
                node = nextNode;
                nextNode = tmp;
            } while (nextNode != null);

            // Traverse the list from either directions and merge the nodes
            ListNode i = head, j = tail;
            while (i != j && i.next != j) {
                node = i.next;
                tmp = j.next;
                i.next = j;
                j.next = node;
                i = node;
                j = tmp;
            }
            j.next = null;
        }
    }
    
    public static void printList(ListNode head){
        System.out.print("[ ");
        ListNode node = head;
        while(node != null){
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        /*head.next.next.next.next = new ListNode(5);*/
        ReorderList rl = new ReorderList();
        System.out.print("Original List: ");
        printList(head);
        rl.reorderList(head);
        System.out.print("Reordered List: ");
        printList(head);
    }
}
