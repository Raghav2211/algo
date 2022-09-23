package com.github.devraghav.leetcode;

import java.util.StringJoiner;

public class BinaryTree_Invert {
    public TreeNode invertTree(TreeNode root) {

        if(root == null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);

        // create left tree
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        // create right tree
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        BinaryTree_Invert binaryTree_invert = new BinaryTree_Invert();
        root = binaryTree_invert.invertTree(root);
        BinaryTree_InOrderTraversal binaryTree_inOrderTraversal = new BinaryTree_InOrderTraversal();
        System.out.println(binaryTree_inOrderTraversal.traverse(root, new StringJoiner(",")));
    }
}
