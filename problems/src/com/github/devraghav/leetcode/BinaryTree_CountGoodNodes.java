package com.github.devraghav.leetcode;

public class BinaryTree_CountGoodNodes {
    int goodNodes = 0;

    public int goodNodes(TreeNode root) {
        if(root == null ) return goodNodes;
        return goodNodes(root,root.val);
    }
    private int goodNodes(TreeNode root , int max) {
        if(root == null) return goodNodes;
        if(root.val >= max) {
            goodNodes+=1;
        }
        goodNodes(root.left , Math.max(max , root.left == null ? max : root.left.val));
        goodNodes(root.right , Math.max(max , root.right == null ? max : root.right.val));
        return goodNodes;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        // create left tree
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(3);

        // create right tree
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);

        BinaryTree_CountGoodNodes binaryTree_countGoodNodes = new BinaryTree_CountGoodNodes();
        System.out.println( binaryTree_countGoodNodes.goodNodes(root));
    }

}
