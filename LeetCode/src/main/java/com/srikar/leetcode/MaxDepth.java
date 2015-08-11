/*

 Given a binary tree, find its maximum depth.
 The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

 E.g.:
 5
 / \
 4   8
 /   / \
 11  13  4
 /  \    / \
 7    2  5   1
 /
 4

 */
package com.srikar.leetcode;

public class MaxDepth {

    private int maxDepth = 0;

    public int maxDepth(TreeNode root) {
        if (root != null) {
            preorderTraversal(root, 0);
        }
        return maxDepth;
    }

    private void preorderTraversal(TreeNode root, int depth) {
        boolean isLeaf = true;

        ++depth;
        if (root.left != null) {
            isLeaf = false;
            preorderTraversal(root.left, depth);
        }
        if (root.right != null) {
            isLeaf = false;
            preorderTraversal(root.right, depth);
        }
        if (isLeaf) {
            if (depth > maxDepth) {
                maxDepth = depth;
            }
        }
    }

    public static void main(String[] args) {
        /* Build Tree level by level */
        //Level 0
        TreeNode root = new TreeNode(5);

        //Level 1
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);

        //Level 2
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);

        //Level 3
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        //Level 4
        root.left.left.right.left = new TreeNode(4);

        MaxDepth md = new MaxDepth();
        System.out.println("Maximum depth of the tree: " + md.maxDepth(root));
    }

}
