package com.github.devraghav.binarytree;

import java.util.StringJoiner;

public class BinarySearchTreeNodeDelete {

    public TreeNode deleteNodeV2(TreeNode root, int key) {
        if (root == null) return null;
        if (key < root.val) {
            root.left = deleteNodeV1(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNodeV1(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            var maximumOfLeft = maximumOfLeft(root.left);
            root.val = maximumOfLeft.val;
            root.left = deleteNodeV1(root.left, maximumOfLeft.val);
        }
        return root;
    }


    public TreeNode deleteNodeV1(TreeNode root, int key) {
        if (root == null) return null;
        if (key < root.val) {
            root.left = deleteNodeV1(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNodeV1(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            var minimumNodeOfRight = minimumOfRight(root.right);
            root.val = minimumNodeOfRight.val;
            root.right = deleteNodeV1(root.right, minimumNodeOfRight.val);
        }
        return root;
    }


    private TreeNode minimumOfRight(TreeNode root) {
        TreeNode ans = root;
        while (root.left != null) {
            ans = root.left;
            root = ans;
        }
        return ans;
    }

    private TreeNode maximumOfLeft(TreeNode root) {
        TreeNode ans = root;
        while (root.right != null) {
            ans = root.right;
            root = ans;
        }
        return ans;
    }

    public static void main(String[] args) {

        BinarySearchTreeNodeDelete binarySearchTreeNodeDelete = new BinarySearchTreeNodeDelete();

        TreeNode root = binarySearchTreeNodeDelete.deleteNodeV1(createBST(), 2);
        InorderTraversal inorderTraversal = new InorderTraversal();
        System.out.println(inorderTraversal.traverse(root, new StringJoiner(",")));

        root = binarySearchTreeNodeDelete.deleteNodeV2(createBST(), 2);
        System.out.println(inorderTraversal.traverse(root, new StringJoiner(",")));

        root = binarySearchTreeNodeDelete.deleteNodeV1(createBST(), 4);
        System.out.println(inorderTraversal.traverse(root, new StringJoiner(",")));

        root = binarySearchTreeNodeDelete.deleteNodeV2(createBST(), 4);
        System.out.println(inorderTraversal.traverse(root, new StringJoiner(",")));

        root = binarySearchTreeNodeDelete.deleteNodeV1(createBST(), 3);
        System.out.println(inorderTraversal.traverse(root, new StringJoiner(",")));

        root = binarySearchTreeNodeDelete.deleteNodeV2(createBST(), 3);
        System.out.println(inorderTraversal.traverse(root, new StringJoiner(",")));
    }

    private static TreeNode createBST() {
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);
        return root;
    }
}
