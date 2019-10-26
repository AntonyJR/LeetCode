package easy.balancedbinarytree;

import common.TreeNode;

class Solution {
    private int height(TreeNode root) {
        if (root == null)
            return 0;
        else {
            int lHeight = height(root.left);
            if (lHeight == -1)
                return -1;
            int rHeight = height(root.right);
            if (rHeight == -1 || Math.abs(lHeight - rHeight) > 1)
                return -1;
            return 1+Math.max(lHeight, rHeight);
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        else
            return height(root) != -1;
    }
}
