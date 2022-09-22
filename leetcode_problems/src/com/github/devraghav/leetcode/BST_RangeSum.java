package com.github.devraghav.leetcode;

public class BST_RangeSum {
    private int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return sum;
        if(root.val >= low && root.val <= high){
            sum+=root.val;
        }
        rangeSumBST(root.left,low,high);
        rangeSumBST(root.right,low,high);
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);

        // create left tree
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);

        // create right tree
        root.right = new TreeNode(15 );
        root.right.right = new TreeNode(18);
        BST_RangeSum bst_rangeSum = new BST_RangeSum();
        System.out.println(bst_rangeSum.rangeSumBST(root,7,15));
    }
}
