package com.github.devraghav.binarytree;

public class LowestCommonAncestor {
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if ((p.val == root.val || q.val == root.val) || (p.val < root.val && q.val > root.val) || (p.val > root.val && q.val < root.val)) {
            return root;
        }
        TreeNode ans = root;
        if (p.val < root.val && q.val < root.val) {
            ans = lowestCommonAncestor(root.left, p, q);
        } else {
            ans = lowestCommonAncestor(root.right, p, q);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
        System.out.println(lowestCommonAncestor.lowestCommonAncestor(root, root.right, root.left).val);
    }
}
