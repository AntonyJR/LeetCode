package easy.longestunivaluepath;

import common.TreeNode;

class Solution {
    private int walkLongest(TreeNode root, int[] longest) {
        int llen = 0;
        int rlen = 0;
        if (root.left != null) {
            int temp = walkLongest(root.left, longest);
            if (root.left.val == root.val)
                llen = 1+temp;
        }
        if (root.right != null) {
            int temp = walkLongest(root.right, longest);
            if (root.right.val == root.val)
                rlen = 1+temp;
        }
        if (root.left == null && root.right == null)
            return 0;
        longest[0] = Math.max(longest[0], llen+rlen);
        return Math.max(rlen, llen);
    }

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        int[] longest = new int[1];
        walkLongest(root, longest);
        return longest[0];
    }
}
