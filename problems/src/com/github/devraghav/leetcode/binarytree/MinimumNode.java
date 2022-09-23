package com.github.devraghav.leetcode.binarytree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MinimumNode {

    // @formatter: off
    /**
     *        5
     *    11      3
     *  4  15      12
     *
     */
    // @formatter: on

    public int getUsingDFS(TreeNode root) {
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

    public int getUsingRecursive(TreeNode root) {
        if(root == null) return Integer.MAX_VALUE;
        return Math.min(root.val,Math.min(getUsingRecursive(root.left),
                getUsingRecursive(root.right)));
    }
    public int getUsingBFS(TreeNode root) {
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

        MinimumNode binaryTree_minimum = new MinimumNode();
        System.out.println(binaryTree_minimum.getUsingDFS(root));
        System.out.println(binaryTree_minimum.getUsingRecursive(root));
        System.out.println(binaryTree_minimum.getUsingBFS(root));

    }
}
