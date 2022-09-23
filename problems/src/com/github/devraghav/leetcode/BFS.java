package com.github.devraghav.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringJoiner;

public class BFS {
// @formatter: off
    /**
     *       1
     *    2      3
     *  4  5   6   7
     *
     */
    // @formatter: on

    public StringJoiner traverseUsingStack(TreeNode root, StringJoiner bfsTraverse) {
        if(root == null) return bfsTraverse;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            bfsTraverse.add(String.valueOf(treeNode.val));
            if(treeNode.left!=null ){
                queue.add(treeNode.left);
            }
            if(treeNode.right!=null ){
                queue.add(treeNode.right);
            }
        }
        return bfsTraverse;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        // create left tree
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // create right tree
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        BFS bfs = new BFS();
        System.out.println(bfs.traverseUsingStack(root, new StringJoiner(",")));

    }
}
