/*
 Given a sorted linked list, delete all duplicates such that each element appear only once.

 For example,
 Given 1->1->2, return 1->2.
 Given 1->1->2->3->3, return 1->2->3. 

 */
package com.srikar.leetcode;

/**
 *
 * @author vedantas
 */
public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if (head != null && head.next != null) {
            ListNode prevNode =  head, node = head.next;
            do{
                if(prevNode.val == node.val){
                    prevNode.next = node.next;
                }
                else{
                    prevNode = node;
                }
                node = node.next;
            }while (node != null);
        }
        return head;
    }
    
    public static void printList(ListNode head){
        System.out.print("[ ");
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);
                
        RemoveDuplicatesFromSortedList rdfs = new RemoveDuplicatesFromSortedList();
        printList(rdfs.deleteDuplicates(head));
    }
}
