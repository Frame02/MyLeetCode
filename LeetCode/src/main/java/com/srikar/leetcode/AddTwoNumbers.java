/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.srikar.leetcode;

/**
 *
 * @author vedantas
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode resultList = new ListNode(0);
        ListNode sumList = resultList;
        int carryForward = 0;
        int digitsSum;
        boolean nextIteration;

        while (true) {
            digitsSum = 0;
            nextIteration = false;
            if (l1 != null) {
                digitsSum += l1.val;
                l1 = l1.next;
                if (l1 != null) {
                    nextIteration = true;
                }
            }
            if (l2 != null) {
                digitsSum += l2.val;
                l2 = l2.next;
                if (l2 != null) {
                    nextIteration = true;
                }
            }
            if (carryForward != 0) {
                digitsSum += carryForward;
            }

            carryForward = digitsSum / 10;
            if (carryForward != 0) {
                nextIteration = true;
            }
            sumList.val = digitsSum % 10;

            if (nextIteration) {
                sumList.next = new ListNode(0);
                sumList = sumList.next;
            } else {
                break;
            }
        }
        return resultList;
    }

    private static ListNode buildList(int[] digits) {
        final ListNode rootNode = new ListNode(digits[0]);
        ListNode currentNode = rootNode;
        for (int i = 1; i < digits.length; ++i) {
            currentNode.next = new ListNode(digits[i]);
            currentNode = currentNode.next;
        }
        return rootNode;
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{0};
        int[] num2 = new int[]{7,3};

        ListNode l1 = buildList(num1);
        ListNode l2 = buildList(num2);

        AddTwoNumbers atn = new AddTwoNumbers();
        ListNode resultList = atn.addTwoNumbers(l1, l2);
        System.out.println("Sum of specified numbers (in reverse order: ");
        while (resultList != null) {
            System.out.print(resultList.val);
            resultList = resultList.next;
        }
        System.out.println();
    }
}
