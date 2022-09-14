package com.github.devraghav.leetcode;

import java.util.Stack;

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

    public void traverse(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            System.out.print(treeNode.val+",");
            if(treeNode.right !=null ){
                stack.push(treeNode.right);
            }
            if(treeNode.left !=null) {
                stack.push(treeNode.left);
            }
        }
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
        dfs.traverse(root);

    }
}
