package com.github.devraghav.binarytree;


public class BinarySearchTree {

    public boolean isValid(TreeNode root) {
        if(root == null ) return true;
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValid(TreeNode root, long minVal, long maxVal) {
        if(root == null) return true;

        if(root.val >= maxVal || root.val <= minVal) {
            return false;
        }
        return isValid(root.left ,minVal , root.val) && isValid(root.right , root.val, maxVal);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);

        // create left tree
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        BinarySearchTree bst_validate = new BinarySearchTree();
        System.out.println(bst_validate.isValid(root));

        root = new TreeNode(5);

        // create left tree
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);

        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);

        System.out.println(bst_validate.isValid(root));

    }

}
