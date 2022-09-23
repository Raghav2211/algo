package com.github.devraghav.leetcode;

import java.util.StringJoiner;

public class BST_InsertNode {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        } else if(root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);

        root.left.left = new TreeNode(1);
        root.left.right
                = new TreeNode(3);

        BST_InsertNode bst_insertNode = new BST_InsertNode();

        BinaryTree_InOrderTraversal binaryTree_inOrderTraversal = new BinaryTree_InOrderTraversal();
        System.out.println(binaryTree_inOrderTraversal.traverse(bst_insertNode.insertIntoBST(root,5), new StringJoiner(",")));
    }
}
