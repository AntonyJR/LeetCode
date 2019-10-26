package easy.binarytreetilt;

import common.TreeNode;

class Solution {
    private int tilt = 0;

    private int walkSubTree(TreeNode root) {
        if (root == null)
            return 0;
        int left = walkSubTree(root.left);
        int right = walkSubTree(root.right);
        tilt += Math.abs(left-right);
        return root.val+left+right;
    }

    public int findTilt(TreeNode root) {
        walkSubTree(root);
        return tilt;
    }
}
