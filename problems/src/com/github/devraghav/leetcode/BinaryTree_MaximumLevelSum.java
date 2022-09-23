package com.github.devraghav.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringJoiner;

public class BinaryTree_MaximumLevelSum {
    // @formatter: off
    /**
     *       1
     *    2      3
     *  4  5   6   7
     *
     */
    // @formatter: on
    public int maxLevelSum(TreeNode root) throws InterruptedException {
        if(root == null) return 0;

        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(root);
        treeNodes.add(null);

        long max = Integer.MIN_VALUE;
        long currentLevelSum = 0;

        int level = 0;
        int maxSumLevel = 0;

        while (true) {
            TreeNode node = treeNodes.poll();
            if(node == null) {
                level++;
                if((currentLevelSum > max)  ){
                    max = currentLevelSum;
                    maxSumLevel = level;
                }
                currentLevelSum = 0;
                if(treeNodes.isEmpty()){
                    break;
                }
                treeNodes.add(null);
                continue;
            }
            currentLevelSum += node.val;
            if(node.left != null){
                treeNodes.add(node.left);
            }
            if(node.right != null){
                treeNodes.add(node.right);
            }
        }
        return maxSumLevel;
    }

    public static void main(String[] args) throws InterruptedException {
        TreeNode root = new TreeNode(1);

        // create left tree
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // create right tree
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        BinaryTree_MaximumLevelSum binaryTree_maximumLevelSum  = new BinaryTree_MaximumLevelSum();
        System.out.println(binaryTree_maximumLevelSum.maxLevelSum(root));



        root = new TreeNode(-1);

        // create left tree
        root.left = new TreeNode(-2);
        root.left.left = new TreeNode(-4);
        root.left.right = new TreeNode(-5);

        // create right tree
        root.right = new TreeNode(-3);
        root.right.left = new TreeNode(-6);
        root.right.right = new TreeNode(-7);
        System.out.println(binaryTree_maximumLevelSum.maxLevelSum(root)); // TODO : handle negative nodes
    }
}
