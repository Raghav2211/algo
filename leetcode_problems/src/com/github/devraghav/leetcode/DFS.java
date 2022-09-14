package com.github.devraghav.leetcode;

import java.util.Stack;
import java.util.StringJoiner;

public class DFS {
    // @formatter: off
    /**
     *       1
     *    2      3
     *  4  5   6   7
     *
     *
     * @param root
     */
    // @formatter: on

    public StringJoiner traverseUsingStack(TreeNode root,StringJoiner dfsTraverse) {
        if(root == null) return dfsTraverse;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            dfsTraverse.add((String.valueOf(treeNode.val)));
            if(treeNode.right !=null ){
                stack.push(treeNode.right);
            }
            if(treeNode.left !=null) {
                stack.push(treeNode.left);
            }
        }
        return dfsTraverse;
    }

    public StringJoiner traverseUsingRecursive(TreeNode root , StringJoiner dfsTraverse) {
        if (root == null) return dfsTraverse;
        dfsTraverse.add(String.valueOf(root.val));
        traverseUsingRecursive(root.left,dfsTraverse);
        traverseUsingRecursive(root.right,dfsTraverse);
        return dfsTraverse;
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

        DFS dfs = new DFS();
        System.out.println(dfs.traverseUsingStack(root, new StringJoiner(",")));
        System.out.println(dfs.traverseUsingRecursive(root, new StringJoiner(",")));

    }
}
