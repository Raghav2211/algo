package com.github.devraghav.binarytree;

import java.util.ArrayList;
import java.util.List;

public class LeftSideOfView {

    public List<Integer> leftSideViewRecursive(TreeNode root) {
        List<Integer> leftSideView = new ArrayList<>();
        if (root == null) return leftSideView;
        leftSideViewRecursive(root, 0, leftSideView);
        return leftSideView;
    }

    private void leftSideViewRecursive(TreeNode root, int level, List<Integer> leftSideView) {
        if (root == null) {
            return;
        }
        if (level == leftSideView.size()) {
            leftSideView.add(root.val);
        }
        leftSideViewRecursive(root.left, level + 1, leftSideView);
        leftSideViewRecursive(root.right, level + 1, leftSideView);
    }
}
