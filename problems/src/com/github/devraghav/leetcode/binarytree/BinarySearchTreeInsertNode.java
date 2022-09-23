package com.github.devraghav.leetcode.binarytree;

import java.util.StringJoiner;

public class BinarySearchTreeInsertNode {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        } else if (root.val < val) {
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

        BinarySearchTreeInsertNode bst_insertNode = new BinarySearchTreeInsertNode();

        InorderTraversal binaryTree_inOrderTraversal = new InorderTraversal();
        System.out.println(binaryTree_inOrderTraversal.traverse(bst_insertNode.insertIntoBST(root, 5), new StringJoiner(",")));
    }
}
