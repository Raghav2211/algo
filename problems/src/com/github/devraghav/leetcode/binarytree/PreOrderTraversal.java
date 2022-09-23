package com.github.devraghav.leetcode.binarytree;



import java.util.StringJoiner;

public class PreOrderTraversal {

    // @formatter: off
    /**
     *       1
     *    2      3
     *  4  5   6   7
     *
     */
    // @formatter: on

    private StringJoiner traverse(TreeNode root, StringJoiner stringJoiner) {
        if(root == null) return stringJoiner;
        stringJoiner.add(String.valueOf(root.val));
        traverse(root.left,stringJoiner);
        traverse(root.right,stringJoiner);
        return stringJoiner;
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

        PreOrderTraversal binaryTree_preOrderTraversal  = new PreOrderTraversal();
        System.out.println(binaryTree_preOrderTraversal.traverse(root, new StringJoiner(",")));
    }
}
