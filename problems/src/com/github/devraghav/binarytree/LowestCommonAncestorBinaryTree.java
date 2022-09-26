package com.github.devraghav.binarytree;

public class LowestCommonAncestorBinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : right == null ? left : root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        LowestCommonAncestorBinaryTree lowestCommonAncestor = new LowestCommonAncestorBinaryTree();
        System.out.println(lowestCommonAncestor.lowestCommonAncestor(root, root.left.left, root.left.right).val);
    }
}
