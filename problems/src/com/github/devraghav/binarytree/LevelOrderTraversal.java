package com.github.devraghav.binarytree;



import java.util.LinkedList;
import java.util.Queue;
import java.util.StringJoiner;

public class LevelOrderTraversal {

    // @formatter: off
    /**
     *       1
     *    2      3
     *  4  5   6   7
     *
     */
    // @formatter: on

    public StringJoiner traverse(TreeNode root, StringJoiner stringJoiner) {
        if(root == null) return stringJoiner;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            stringJoiner.add(String.valueOf(treeNode.val));
            if(treeNode.left !=null) {
                queue.add(treeNode.left);
            }
            if(treeNode.right !=null) {
                queue.add(treeNode.right);
            }
        }
        return stringJoiner;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        // create left tree
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        // create right tree
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        LevelOrderTraversal binaryTree_preOrderTraversal  = new LevelOrderTraversal();
        System.out.println(binaryTree_preOrderTraversal.traverse(root, new StringJoiner(",")));
    }
}
