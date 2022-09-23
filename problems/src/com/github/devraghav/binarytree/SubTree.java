package com.github.devraghav.binarytree;


public class SubTree {

    // @formatter: off
    /**    main                   subtree
     *       1                       3
     *    2      3                 6   7
     *  4  5   6   7
     *      8
     *
     */
    // @formatter: on

    public boolean isReplica(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) return true;
        if(root == null || subRoot == null) return false;
        if(root.val == subRoot.val) {
            return isReplica(root.left,subRoot.left) && isReplica(root.right, subRoot.right);
        }
        return false;
    }


    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot == null) return true;
        if(root == null) return false;
        if(root.val == subRoot.val) {
            var isMatch = isReplica(root,subRoot);
            if(isMatch) return true;
        }
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }

    public static void main(String[] args) {

        TreeNode mainTreeRoot = new TreeNode(1);

        // create left tree
        mainTreeRoot.left = new TreeNode(2);
        mainTreeRoot.left.left = new TreeNode(4);
        mainTreeRoot.left.right = new TreeNode(5);
        mainTreeRoot.left.right.right = new TreeNode(8);

        // create right tree
        mainTreeRoot.right = new TreeNode(3);
        mainTreeRoot.right.left = new TreeNode(6);
        mainTreeRoot.right.right = new TreeNode(7);




        TreeNode subTreeRoot = new TreeNode(3);
        subTreeRoot.left = new TreeNode(6);
        subTreeRoot.right = new TreeNode(7);

        SubTree binaryTree_isSubTree    = new SubTree();
        System.out.println(binaryTree_isSubTree.isSubtree(mainTreeRoot,subTreeRoot));

        subTreeRoot = new TreeNode(3);
        subTreeRoot.left = new TreeNode(6);
        subTreeRoot.right = new TreeNode(8);
        System.out.println(binaryTree_isSubTree.isSubtree(mainTreeRoot,subTreeRoot));
    }

}
