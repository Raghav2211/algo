package com.github.devraghav.binarytree;


public class GoodNodes {
    int goodNodes = 0;

    public int count(TreeNode root) {
        if(root == null ) return goodNodes;
        return count(root,root.val);
    }
    private int count(TreeNode root , int max) {
        if(root == null) return goodNodes;
        if(root.val >= max) {
            goodNodes+=1;
        }
        count(root.left , Math.max(max , root.left == null ? max : root.left.val));
        count(root.right , Math.max(max , root.right == null ? max : root.right.val));
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

        GoodNodes binaryTree_countGoodNodes = new GoodNodes();
        System.out.println( binaryTree_countGoodNodes.count(root));
    }

}
