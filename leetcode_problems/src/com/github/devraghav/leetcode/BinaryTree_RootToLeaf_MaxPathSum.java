package com.github.devraghav.leetcode;

import java.util.StringJoiner;

public class BinaryTree_RootToLeaf_MaxPathSum {

    // @formatter: off
    /**
     *         5
     *    11       3
     *  4    2        1
     *
     */
    // @formatter: on

    public int get(TreeNode root){
        return root == null ? 0: get(root,0);
    }
    private int get(TreeNode root , int currentSum) {
        if(root == null) return currentSum;
        currentSum+=root.val;
        int leftSum = get(root.left,currentSum);
        int rightSum = get(root.right,currentSum);
        return Math.max(leftSum , rightSum);
    }

    public int getV2(TreeNode root) {
        if(root == null) return 0;
        return root.val + (Math.max(getV2(root.left), getV2(root.right)));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        // create left tree
        root.left = new TreeNode(11);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(2);

        // create right tree
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(1);

        BinaryTree_RootToLeaf_MaxPathSum binaryTree_rootToLeaf_maxPathSum = new BinaryTree_RootToLeaf_MaxPathSum();
        System.out.println(binaryTree_rootToLeaf_maxPathSum.get(root));
        System.out.println(binaryTree_rootToLeaf_maxPathSum.getV2(root));
    }
}
