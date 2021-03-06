/*

 Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 For example:
 Given the below binary tree and sum = 22,

 5
 / \
 4   8
 /   / \
 11  13  4
 /  \    / \
 7    2  5   1

 */
package com.srikar.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vedantas
 */
public class PathSum2 {

    private int sum = 0;
    private final List<List<Integer>> resultList = new ArrayList<List<Integer>>();
    List<Integer> pathList = new ArrayList<Integer>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        // Commenting the below statement as LeetCode seems to execute each test case in isolation (i.e. by creating a new Solution instance)
        // Obviously, this improves runtime performance
        //resultList.clear(); 
        this.sum = sum;

        if (root != null) {
            preorderTraversal(root, 0);
        }
        return resultList;
    }

    private void preorderTraversal(TreeNode root, int pathSum) {
        boolean isLeaf = true;
        
        pathList.add(root.val);
        pathSum += root.val;

        if (root.left != null) {
            isLeaf = false;
            preorderTraversal(root.left, pathSum);
        }
        if (root.right != null) {
            isLeaf = false;
            preorderTraversal(root.right, pathSum);
        }
        if (isLeaf) {
            if (pathSum == sum) {
                resultList.add(new ArrayList(pathList));
            }
        } 
        pathList.remove(pathList.size() - 1);
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

        PathSum2 ps2 = new PathSum2();
        System.out.println("Has the tree got PathSum: " + ps2.pathSum(root, 22));

    }

}
