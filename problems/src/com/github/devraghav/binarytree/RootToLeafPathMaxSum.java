package com.github.devraghav.binarytree;


public class RootToLeafPathMaxSum {

    // @formatter: off
    /**
     *         5
     *    11       3
     *  4    2        1
     *
     */
    // @formatter: on

    public int calculate(TreeNode root){
        return root == null ? 0: calculate(root,0);
    }
    private int calculate(TreeNode root , int currentSum) {
        if(root == null) return currentSum;
        currentSum+=root.val;
        int leftSum = calculate(root.left,currentSum);
        int rightSum = calculate(root.right,currentSum);
        return Math.max(leftSum , rightSum);
    }

    public int calculateV2(TreeNode root) {
        if(root == null) return 0;
        return root.val + (Math.max(calculateV2(root.left), calculateV2(root.right)));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        // create left tree
        root.left = new TreeNode(11);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(2);

        // create right tree
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(1);

        RootToLeafPathMaxSum binaryTree_rootToLeaf_maxPathSum = new RootToLeafPathMaxSum();
        System.out.println(binaryTree_rootToLeaf_maxPathSum.calculate(root));
        System.out.println(binaryTree_rootToLeaf_maxPathSum.calculateV2(root));
    }
}
