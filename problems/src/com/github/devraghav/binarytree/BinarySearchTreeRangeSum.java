package com.github.devraghav.binarytree;


public class BinarySearchTreeRangeSum {
    private int sum = 0;

    public int rangeSum(TreeNode root, int low, int high) {
        if(root == null) return sum;
        if(root.val >= low && root.val <= high){
            sum+=root.val;
        }
        rangeSum(root.left,low,high);
        rangeSum(root.right,low,high);
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
        BinarySearchTreeRangeSum bst_rangeSum = new BinarySearchTreeRangeSum();
        System.out.println(bst_rangeSum.rangeSum(root,7,15));
    }
}
