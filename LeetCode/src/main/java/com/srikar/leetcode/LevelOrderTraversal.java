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

import java.util.ArrayList;
import java.util.List;

public class LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrderList = new ArrayList<List<Integer>>();
        List<TreeNode> levelNodeList, nextLevelNodeList = new ArrayList<TreeNode>();
        List<Integer> nextLevelValList = new ArrayList<Integer>();
        if (root != null) {
            nextLevelNodeList.add(root);
            nextLevelValList.add(root.val);
            
            do {
                levelNodeList = nextLevelNodeList;
                levelOrderList.add(nextLevelValList);
                
                nextLevelNodeList = new ArrayList<TreeNode>();
                nextLevelValList = new ArrayList<Integer>();
                
                for (TreeNode node : levelNodeList) {
                    if (node.left != null) {
                        nextLevelNodeList.add(node.left);
                        nextLevelValList.add(node.left.val);
                    }
                    if (node.right != null) {
                        nextLevelNodeList.add(node.right);
                        nextLevelValList.add(node.right.val);
                    }
                }
                
            } while (!nextLevelNodeList.isEmpty());
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
        /*// Level 3
        root.left.left.right = new TreeNode(2);*/
        
        LevelOrderTraversal lot = new LevelOrderTraversal();
        System.out.println(lot.levelOrder(root));
    }
}
