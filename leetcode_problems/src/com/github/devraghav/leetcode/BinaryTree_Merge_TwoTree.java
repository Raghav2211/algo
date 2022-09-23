package com.github.devraghav.leetcode;

import java.util.StringJoiner;

public class BinaryTree_Merge_TwoTree {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root2 == null && root1 == null) return null;
        if(root2 == null) return root1;
        if(root1 == null) return root2;
        root1.val+=root2.val;
        root1.left = mergeTrees(root1.left,root2.left);
        root1.right = mergeTrees(root1.right,root2.right);
        return root1;
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);

        // create left tree
        root1.left = new TreeNode(3);
        root1.left.left = new TreeNode(5);

        // create right tree
        root1.right = new TreeNode(2);

        TreeNode root2 = new TreeNode(2);

        // create left tree
        root2.left = new TreeNode(1);
        root2.left.right = new TreeNode(4);

        // create right tree
        root2.right = new TreeNode(3);
        root2.right.right = new TreeNode(7);

        BinaryTree_Merge_TwoTree binaryTree_merger_twoTree = new BinaryTree_Merge_TwoTree();
        root1 = binaryTree_merger_twoTree.mergeTrees(root1,root2);

        BinaryTree_InOrderTraversal binaryTree_inOrderTraversal = new BinaryTree_InOrderTraversal();
        System.out.println(binaryTree_inOrderTraversal.traverse(root1, new StringJoiner(",")));

    }

}
