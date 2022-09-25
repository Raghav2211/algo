package com.github.devraghav.binarytree;

import java.util.ArrayList;
import java.util.List;

public class RightSideOfView {

    public List<Integer> rightSideViewRecursive(TreeNode root) {
        List<Integer> rightSideView = new ArrayList<>();
        if (root == null) return rightSideView;
        rightSideViewRecursive(root, 0, rightSideView);
        return rightSideView;
    }

    private void rightSideViewRecursive(TreeNode root, int level, List<Integer> rightSideView) {
        if (root == null) {
            return;
        }
        if (level == rightSideView.size()) {
            rightSideView.add(root.val);
        }
        rightSideViewRecursive(root.right, level + 1, rightSideView);
        rightSideViewRecursive(root.left, level + 1, rightSideView);
    }
}
