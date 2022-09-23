package com.github.devraghav.leetcode;

public class BinaryTree_Diameter {

    // @formatter: off
    /**
     *       1
     *    2      3
     *  4  5   6   7
     *      8
     *
     */
    // @formatter: on
        int diam = 0;
    private int height(TreeNode root) {
        if (root == null) return 0;
        int left = height(root.left);
        int right = height(root.right);
        diam = Math.max(diam, left + right);
        return Math.max(left, right) + 1;
    }

    public int diameter(TreeNode root){
        height(root);
        return diam;
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

        BinaryTree_Diameter binaryTree_countNodes    = new BinaryTree_Diameter();
        System.out.println(binaryTree_countNodes.diameter(root));


    }

}
