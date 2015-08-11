/*

 Given a binary tree, find its minimum depth.
 The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

 E.g.:
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1

 */
package com.srikar.leetcode;

public class MinDepth {

    private int minDepth = -1;

    public int minDepth(TreeNode root) {
        if (root != null) {
            preorderTraversal(root, 0);
        }
        else{
            minDepth = 0;
        }
        return minDepth;
    }

    private void preorderTraversal(TreeNode root, int depth) {
        ++depth;

        if (root.left == null && root.right == null) {
            if (minDepth == -1 || depth < minDepth) {
                minDepth = depth;
            } 
        } else {
            if (minDepth == -1 || depth < minDepth) {
                if (root.left != null) {
                    preorderTraversal(root.left, depth);
                }
                if (root.right != null) {
                    preorderTraversal(root.right, depth);
                }
            }
        }
    }

    public static void main(String[] args) {
        /* Build tree level by level */
        // Level 0
        TreeNode root = new TreeNode(5);
        // Level 1
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        // Level 2
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        // Level 3
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        MinDepth md = new MinDepth();
        System.out.println("Has the tree got PathSum: " + md.minDepth(root));
    }

}
