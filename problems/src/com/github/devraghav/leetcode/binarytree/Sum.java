package com.github.devraghav.leetcode.binarytree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Sum {

    // @formatter: off
    /**
     *       1
     *    2      3
     *  4  5   6   7
     *
     */
    // @formatter: on

    public int calculateUsingDFS(TreeNode root) {
        int sum = 0;
        if(root == null) return sum;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            sum+=treeNode.val;
            if(treeNode.right !=null ){
                stack.push(treeNode.right);
            }
            if(treeNode.left !=null) {
                stack.push(treeNode.left);
            }
        }
        return sum;
    }

    public int calculateUsingBFS(TreeNode root) {
        int sum = 0;
        if(root == null) return sum;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            sum+=treeNode.val;
            if(treeNode.left!=null ){
                queue.add(treeNode.left);
            }
            if(treeNode.right!=null ){
                queue.add(treeNode.right);
            }
        }
        return sum;
    }

    public int calculateUsingRecursive(TreeNode root) {
        if(root == null) return 0;
        return root.val+ calculateUsingRecursive(root.left)+ calculateUsingRecursive(root.right);
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

        Sum binaryTree_sum = new Sum();
        System.out.println(binaryTree_sum.calculateUsingDFS(root));
        System.out.println(binaryTree_sum.calculateUsingBFS(root));
        System.out.println(binaryTree_sum.calculateUsingRecursive(root));
    }
}
