/*

 Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

 For example:
 Given binary tree {3,9,20,#,#,15,7},

 3
 / \
 9  20
 /  \
 15   7

 return its level order traversal as:

 [
 [3],
 [9,20],
 [15,7]
 ]

 */
package com.srikar.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrderList = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();

        TreeNode node;
        if (root != null) {
            queue.add(root);
            int levelSize = 1, nextLevelSize;
            List<Integer> levelValList;
            while (levelSize != 0) {
                levelValList = new ArrayList<Integer>(levelSize);
                nextLevelSize = 0;
                for (int i = 0; i < levelSize; ++i) {
                    node = queue.remove();
                    levelValList.add(node.val);
                    if (node.left != null) {
                        queue.add(node.left);
                        ++nextLevelSize;
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                        ++nextLevelSize;
                    }
                }
                levelOrderList.add(levelValList);
                levelSize = nextLevelSize;
            }
        }
        return levelOrderList;
    }
    

    public static void main(String[] args) {
        /*Build binary tree level by level */
        // Level 0
        TreeNode root = new TreeNode(3);
        // Level 1
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        // Level 2
        root.left.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        // Level 3
         root.left.left.right = new TreeNode(2);

        LevelOrderTraversal lot = new LevelOrderTraversal();
        System.out.println(lot.levelOrder(root));
    }
}
