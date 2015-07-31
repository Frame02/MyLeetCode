/*

Given a binary search tree, write a function kthSmallest to find the kth smallest element in it. 

Note: 
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

*/
package com.srikar.leetcode;

import java.util.Scanner;

/**
 *
 * @author vedantas
 */

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){ val = x; }
}

public class KthSmallest{
    
    private int i = 0, val = 0;
    
    public int kthSmallest(TreeNode root, int k){
        i = val = 0;
        inorder(root, k);
        return val;
    }
    
    private void inorder(TreeNode root, int k){
        if(i != k && root.left != null) // To avoid tail recursion
            inorder(root.left, k);
        ++i;
        if(i == k){
           val = root.val;
        }
        if(i != k && root.right != null) // To avoid tail recursion
            inorder(root.right, k);
    }
    
    private void insertNode(TreeNode root, int val){
        if(val < root.val){
            if(root.left != null)
                insertNode(root.left, val);
            else{
                TreeNode node = new TreeNode(val);
                root.left = node;
            }
        }
        else{
            if(root.right != null)
                insertNode(root.right, val);
            else{
                TreeNode node = new TreeNode(val);
                root.right = node;
            }
        }
    }
    
    public static void main(String[] args){
        KthSmallest ks = new KthSmallest();
        TreeNode root = new TreeNode(40);
        int[] values = new int[]{24, 78, 43, -1, 34, -23, 56, 89};
        for(int value: values){
            ks.insertNode(root, value);
        }
        int k = 0;
        Scanner scanner = new Scanner(System.in);
        while(k != -1){
            System.out.println("Enter the kth value: ");
            k = scanner.nextInt();
            System.out.println(k + "th Smallest: " + ks.kthSmallest(root, k));
        }
    }
}
