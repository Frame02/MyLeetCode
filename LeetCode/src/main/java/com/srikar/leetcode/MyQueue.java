/*

 Implement the following operations of a queue using stacks.

 push(x) -- Push element x to the back of queue.
 pop() -- Removes the element from in front of queue.
 peek() -- Get the front element.
 empty() -- Return whether the queue is empty.
 Notes:
 You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
 Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
 You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).

 */
package com.srikar.leetcode;

public class MyQueue {

    java.util.Stack<Integer> stack = new java.util.Stack<Integer>();
    java.util.Stack<Integer> tmpStack = new java.util.Stack<Integer>();
    
    // Push element x to the back of queue
    public void push(int x) {
        while (!stack.isEmpty()) {
            tmpStack.push(stack.pop());
        }
        stack.push(x);
        while(!tmpStack.isEmpty()){
            stack.push(tmpStack.pop());
        }
    }

    // Removes the element from in front of queue
    public void pop() {
        stack.pop();
    }

    // Get the front element
    public int peek() {
        return stack.peek();
    }

    // Return whether the queue is empty
    public boolean empty() {
        return stack.isEmpty();
    }
    
    public static void main(String[] args){
        MyQueue mq = new MyQueue();
        mq.push(1);
        mq.push(2);
        mq.push(3);
        System.out.println(mq.peek());
        mq.pop();
        mq.push(4);
        System.out.println(mq.peek());
    }
}
