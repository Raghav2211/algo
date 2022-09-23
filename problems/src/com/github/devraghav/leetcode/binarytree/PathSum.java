package com.github.devraghav.leetcode.binarytree;


public class PathSum {

    // @formatter: off
    /**
     *           5
     *      4           8
     *   11          13    4
     * 7   2                 1
     *
     */
    // @formatter: on

    public boolean isEqualToTarget(TreeNode root, int targetSum) {
        if(root == null) return false;
        if(root.left == null && root.right == null ) return targetSum - root.val == 0;
        return isEqualToTarget(root.left, targetSum - root.val) || isEqualToTarget(root.right, targetSum - root.val);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        // create left tree
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        // create right tree
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        PathSum binaryTree_pathSum_target = new PathSum();
        System.out.println(binaryTree_pathSum_target.isEqualToTarget(root,22));
        System.out.println(binaryTree_pathSum_target.isEqualToTarget(root,26));
        System.out.println(binaryTree_pathSum_target.isEqualToTarget(root,18));
        System.out.println(binaryTree_pathSum_target.isEqualToTarget(root,23));



        TreeNode root2 = new TreeNode(1);
        // create left tree
        root.left = new TreeNode(2);
        System.out.println(binaryTree_pathSum_target.isEqualToTarget(root2,1));

    }
}
