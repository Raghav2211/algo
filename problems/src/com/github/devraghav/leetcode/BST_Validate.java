package com.github.devraghav.leetcode;

public class BST_Validate {

    public boolean isValidBST(TreeNode root) {
        if(root == null ) return true;
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if(root == null) return true;

        if(root.val >= maxVal || root.val <= minVal) {
            return false;
        }
        return isValidBST(root.left ,minVal , root.val) && isValidBST(root.right , root.val, maxVal);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);

        // create left tree
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        BST_Validate bst_validate = new BST_Validate();
        System.out.println(bst_validate.isValidBST(root));

        root = new TreeNode(5);

        // create left tree
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);

        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);

        System.out.println(bst_validate.isValidBST(root));

    }

}
