package com.github.devraghav.leetcode.binarytree;


public class Height {

    // @formatter: off
    /**
     *       1
     *    2      3
     *  4  5   6   7
     *      8
     *
     */
    // @formatter: on

    public int calculate(TreeNode root) {
        if(root == null) return 0;

        return Math.max(calculate(root.left) , calculate(root.right)) + 1;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);

        // create left tree
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(8);

        // create right tree
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        Height binaryTree_countNodes    = new Height();
        System.out.println(binaryTree_countNodes.calculate(root));


    }

}
