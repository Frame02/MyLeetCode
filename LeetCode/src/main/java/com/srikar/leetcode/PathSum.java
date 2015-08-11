/*

 Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 For example:
 Given the below binary tree and sum = 22,

 5
 / \
 4   8
 /   / \
 11  13  4
 /  \      \
 7    2      1

 return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

 */
package com.srikar.leetcode;

/**
 *
 * @author vedantas
 */
public class PathSum {
    
    private int sum = 0;

    public boolean hasPathSum(TreeNode root, int sum) {
        boolean result;
        
        this.sum = sum;
        
        if (root != null) {
            result = preorderTraversal(root, 0);
        } else {
            result = false;
        }

        return result;
    }

    private boolean preorderTraversal(TreeNode root, int pathSum) {
        boolean result = false;

        pathSum += root.val;

        if (root.left == null && root.right == null) {
            if (pathSum == sum) {
                result = true;
            } else {
                result = false;
            }
        } else {
            if (root.left != null) {
                result = preorderTraversal(root.left, pathSum);
            }
            if (!result && root.right != null) {
                result = preorderTraversal(root.right, pathSum);
            }
        }

        return result;
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
        root.right.right.right = new TreeNode(1);

        PathSum ps = new PathSum();
        System.out.println("Has the tree got PathSum: " + ps.hasPathSum(null, 0));

    }
}
