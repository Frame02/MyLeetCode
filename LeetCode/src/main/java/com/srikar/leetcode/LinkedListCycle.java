/*

Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space? 

 */
package com.srikar.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
    
    public boolean hasCycle(ListNode head){
        ListNode node = head;
        boolean hasCycle = false, result;
        Set<ListNode> hashSet = new HashSet<ListNode>();
        while(node != null){
            result = hashSet.add(node);
            if(!result){
                hasCycle = true;
                break;
            }
            node = node.next;
        }
       return hasCycle;
    }
    
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        //head.next = new ListNode(1);
        //head.next.next = head;
        
        LinkedListCycle llc = new LinkedListCycle();
        System.out.println(llc.hasCycle(head));
    }
}
