package com.github.devraghav.binarytree;


import java.util.StringJoiner;

public class Invert {

    public TreeNode doAndReturn(TreeNode root) {

        if(root == null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        doAndReturn(root.left);
        doAndReturn(root.right);
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

        Invert binaryTree_invert = new Invert();
        root = binaryTree_invert.doAndReturn(root);
        InorderTraversal binaryTree_inOrderTraversal = new InorderTraversal();
        System.out.println(binaryTree_inOrderTraversal.traverse(root, new StringJoiner(",")));
    }
}
