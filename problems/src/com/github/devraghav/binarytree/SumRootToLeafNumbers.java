package com.github.devraghav.binarytree;

public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    private int sumNumbers(TreeNode root, int currentSum) {
        if (root == null) return 0;
        currentSum = ((currentSum * 10) + root.val);
        int leftSum = sumNumbers(root.left, currentSum);
        int rightSum = sumNumbers(root.right, currentSum);
        int totalSum = (leftSum == 0 && rightSum ==0) ? currentSum : (leftSum+rightSum);
        return totalSum;
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);

        // create left tree
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);

        // create right tree
        root.right = new TreeNode(0);

        SumRootToLeafNumbers binaryTree_sum = new SumRootToLeafNumbers();
        System.out.println(binaryTree_sum.sumNumbers(root));
    }
}
