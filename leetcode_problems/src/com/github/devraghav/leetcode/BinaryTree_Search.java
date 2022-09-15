package com.github.devraghav.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.TimeUnit;

public class BinaryTree_Search {
    // @formatter: off
    /**
     *       1
     *    2      3
     *  4  5   6   7
     *
     */
    // @formatter: on


    public boolean using_bfs(TreeNode root , int target) {
        if(root == null) return false;
        if(root.val == target) return true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {

            TreeNode treeNode = queue.poll();
            if(treeNode.val == target ) return true;

            if(treeNode.left!=null ){
                if(treeNode.left.val == target) return true;
                queue.add(treeNode.left);
            }
            if(treeNode.right!=null ){
                if(treeNode.right.val == target) return true;
                queue.add(treeNode.right);
            }
        }

        return false;
    }

    public boolean using_dfs(TreeNode root , int target) {
        if(root == null) return false;
        if(root.val == target) return true;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            if(treeNode.val == target ) return true;
            if(treeNode.right !=null ){
                if(treeNode.right.val == target) return true;
                stack.push(treeNode.right);
            }
            if(treeNode.left !=null) {
                if(treeNode.left.val == target) return true;
                stack.push(treeNode.left);
            }
        }
        return false;
    }

    public boolean using_dfs_recursive(TreeNode root , int target) {
        if(root == null ) return false;
        if(root.val == target) return true;
        return using_dfs_recursive(root.left,target) || using_dfs_recursive(root.right,target);
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

        BinaryTree_Search binaryTree_search = new BinaryTree_Search();
        long startTimeInNanos = System.nanoTime();
        boolean isPresent = binaryTree_search.using_bfs(root,5);
        long endTimeInNanos = System.nanoTime();
        System.out.println(
                String.format("Time elapsed to in search using bfs %d(in nanos) with result %s",
                        (endTimeInNanos-startTimeInNanos),isPresent));

         startTimeInNanos = System.nanoTime();
         isPresent=binaryTree_search.using_dfs(root,5);
         endTimeInNanos = System.nanoTime();
        System.out.println(
                String.format("Time elapsed to in search using dfs %d(in nanos) with result %s",
                        (endTimeInNanos-startTimeInNanos),isPresent));


        startTimeInNanos = System.nanoTime();
        isPresent=binaryTree_search.using_dfs_recursive(root,5);
        endTimeInNanos = System.nanoTime();
        System.out.println(
                String.format("Time elapsed to in search using dfs_recursive %d(in nanos) with result %s",
                        (endTimeInNanos-startTimeInNanos),isPresent));

//        System.out.println(binaryTree_search.using_bfs(root,3));
//        System.out.println(binaryTree_search.using_dfs(root,3));
//        System.out.println(binaryTree_search.using_dfs_recursive(root,3));
//
        startTimeInNanos = System.nanoTime();
        isPresent=binaryTree_search.using_bfs(root,9);
        endTimeInNanos = System.nanoTime();
        System.out.println(
                String.format("Time elapsed to in search(not available) using bfs %d(in nanos) with result %s",
                        (endTimeInNanos-startTimeInNanos),isPresent));


        startTimeInNanos = System.nanoTime();
        isPresent=binaryTree_search.using_dfs(root,9);
        endTimeInNanos = System.nanoTime();
        System.out.println(
                String.format("Time elapsed to in search(not available) using dfs %d(in nanos) with result %s",
                        (endTimeInNanos-startTimeInNanos),isPresent));

        startTimeInNanos = System.nanoTime();
        isPresent=binaryTree_search.using_dfs_recursive(root,9);
        endTimeInNanos = System.nanoTime();
        System.out.println(
                String.format("Time elapsed to in search(not available) using dfs_recursive %d(in nanos) with result %s",
                        (endTimeInNanos-startTimeInNanos),isPresent));
    }
}
