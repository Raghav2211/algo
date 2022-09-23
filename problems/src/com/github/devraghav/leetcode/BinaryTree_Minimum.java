package com.github.devraghav.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree_Minimum {

    // @formatter: off
    /**
     *        5
     *    11      3
     *  4  15      12
     *
     */
    // @formatter: on

    public int getMinimum_usingDFS(TreeNode root) {
        int minimum = Integer.MAX_VALUE;
        if(root == null) return minimum;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            minimum = Math.min(minimum,treeNode.val);
            if(treeNode.right !=null ){
                stack.push(treeNode.right);
            }
            if(treeNode.left !=null) {
                stack.push(treeNode.left);
            }
        }
        return minimum;
    }

    public int getMinimum_usingDFS_Recursive(TreeNode root) {
        if(root == null) return Integer.MAX_VALUE;
        return Math.min(root.val,Math.min(getMinimum_usingDFS_Recursive(root.left),
                getMinimum_usingDFS_Recursive(root.right)));
    }
    public int getMinimum_usingBFS(TreeNode root) {
        int minimum = Integer.MAX_VALUE;
        if(root == null) return minimum;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            minimum = Math.min(minimum , treeNode.val);
            if(treeNode.left!=null ){
                queue.add(treeNode.left);
            }
            if(treeNode.right!=null ){
                queue.add(treeNode.right);
            }
        }
        return minimum;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);

        // create left tree
        root.left = new TreeNode(11);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(15);

        // create right tree
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(12);

        BinaryTree_Minimum binaryTree_minimum = new BinaryTree_Minimum();
        System.out.println(binaryTree_minimum.getMinimum_usingDFS(root));
        System.out.println(binaryTree_minimum.getMinimum_usingDFS_Recursive(root));
        System.out.println(binaryTree_minimum.getMinimum_usingBFS(root));

    }
}
