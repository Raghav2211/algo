package com.github.devraghav.binarytree;

public class InorderSuccessorBinarySearchTree {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode x) {
        TreeNode successorNode = null;
        if (x.right != null) {
            successorNode = minNodeOnLeft(x.right);
        } else {
            successorNode = inorderSuccessor(root, x, root.val > x.val ? root : x);
        }
        return successorNode.val == x.val ? null : successorNode;
    }

    public TreeNode inorderSuccessor(TreeNode root, TreeNode x, TreeNode max) {
        // 12 , 14, 20
        // 14, 14, 20
        if (root.val == x.val) {
            return max;
        }
        // if (root.data < max.data && root.data > x.data) max = root;
        if (x.val < root.val) max = root;
        return x.val < root.val ? inorderSuccessor(root.left, x, max) : inorderSuccessor(root.right, x, max);
    }

    private TreeNode minNodeOnLeft(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftNode = minNodeOnLeft(root.left);
        return leftNode == null ? root : leftNode;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);

        root.left = new TreeNode(8);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);

        root.right = new TreeNode(22);

        InorderSuccessorBinarySearchTree inorderSuccessorBinarySearchTree = new InorderSuccessorBinarySearchTree();
        System.out.println(inorderSuccessorBinarySearchTree.inorderSuccessor(root, root.left.right.right).val);
        System.out.println(inorderSuccessorBinarySearchTree.inorderSuccessor(root, root.left).val);
        System.out.println(inorderSuccessorBinarySearchTree.inorderSuccessor(root, root.right));


        root = new TreeNode(33);

        root.left = new TreeNode(12);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(23);
        root.left.left.left = new TreeNode(1);
        root.left.left.right = new TreeNode(4);

        root.right = new TreeNode(64);
        root.right.left = new TreeNode(33);
        root.right.right = new TreeNode(83);

        System.out.println(inorderSuccessorBinarySearchTree.inorderSuccessor(root, root));


    }
}
