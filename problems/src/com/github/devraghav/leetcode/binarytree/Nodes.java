package com.github.devraghav.leetcode.binarytree;


public class Nodes {

    // @formatter: off
    /**
     *       1
     *    2      3
     *  4  5   6   7
     *
     */
    // @formatter: on

    public int count(TreeNode root) {
        if(root == null) return 0;
        return count(root.left) + count(root.right)+1;
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

        Nodes binaryTree_countNodes    = new Nodes();
        System.out.println(binaryTree_countNodes.count(root));


    }

}
