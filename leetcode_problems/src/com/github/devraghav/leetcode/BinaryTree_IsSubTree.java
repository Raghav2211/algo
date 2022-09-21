package com.github.devraghav.leetcode;

public class BinaryTree_IsSubTree {

    // @formatter: off
    /**
     *       1
     *    2      3
     *  4  5   6   7
     *      8
     *
     */
    // @formatter: on

    public boolean isMatch(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) return true;
        if(root == null || subRoot == null) return false;
        if(root.val == subRoot.val) {
            return isMatch(root.left,subRoot.left) && isMatch(root.right, subRoot.right);
        }
        return false;
    }


    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null) return true;
        if(root == null) return false;
        if(root.val == subRoot.val) {
            var isMatch = isMatch(root,subRoot);
            if(isMatch) return true;
        }
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }

    public static void main(String[] args) {

        TreeNode mainTreeRoot = new TreeNode(1);

        // create left tree
        mainTreeRoot.left = new TreeNode(2);
        mainTreeRoot.left.left = new TreeNode(4);
        mainTreeRoot.left.right = new TreeNode(5);
        mainTreeRoot.left.right.right = new TreeNode(8);

        // create right tree
        mainTreeRoot.right = new TreeNode(3);
        mainTreeRoot.right.left = new TreeNode(6);
        mainTreeRoot.right.right = new TreeNode(7);




        TreeNode subTreeRoot = new TreeNode(3);
        subTreeRoot.left = new TreeNode(6);
        subTreeRoot.right = new TreeNode(7);

        BinaryTree_IsSubTree binaryTree_isSubTree    = new BinaryTree_IsSubTree();
        System.out.println(binaryTree_isSubTree.isSubtree(mainTreeRoot,subTreeRoot));

        subTreeRoot = new TreeNode(3);
        subTreeRoot.left = new TreeNode(6);
        subTreeRoot.right = new TreeNode(8);
        System.out.println(binaryTree_isSubTree.isSubtree(mainTreeRoot,subTreeRoot));
    }

}
