package com.srikar.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class MyStack {

    Deque<Integer> deque = new ArrayDeque<Integer>();

    // Push element x onto stack.
    public void push(int x) {
        deque.addFirst(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        deque.removeFirst();
    }

    // Get the top element.
    public int top() {
        return deque.getFirst();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return deque.isEmpty();
    }
    
 }
