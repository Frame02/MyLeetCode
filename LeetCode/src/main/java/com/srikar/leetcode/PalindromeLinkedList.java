/*

Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?

 */
package com.srikar.leetcode;


public class PalindromeLinkedList{
    
    public boolean isPalindrome(ListNode head){
        boolean result = true;
        int size = 0;
        java.util.Stack<Integer> stack = new java.util.Stack<Integer>();
        ListNode node = null;
        for(node = head; node != null; node = node.next)
        {
            ++size;
            stack.push(node.val);
        }
        int halfSize = size >> 1;
        node = head;
        for(int i = 0; i < halfSize; ++i){
            int e = stack.pop();
            if(node.val != e){
                result = false;
                break;
            }
            node = node.next;
        }
        return result;
    }
    
    private void buildList(ListNode headNode, int[] elements){
        for(int element: elements){
            ListNode node = new ListNode(element);
            headNode.next = node;
            headNode = node;
        }
    }
    
    public static void main(String[] args){
        int[] elements = new int[]{1};
        PalindromeLinkedList pll = new PalindromeLinkedList();
        ListNode head = new ListNode(1);
        pll.buildList(head, elements);
        System.out.println("Is Palindrom Linked List? " + pll.isPalindrome(head));
    }
}
