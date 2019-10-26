package easy.diameterofbinarytree;

import common.TreeNode;

class Solution {
    private int pathLen(TreeNode root, int[] longest) {
        int llen = root.left == null ? 0 : pathLen(root.left, longest);
        int rlen = root.right == null ? 0 : pathLen(root.right, longest);
        longest[0] = Math.max(longest[0], llen+rlen);
        return 1 + Math.max(rlen, llen);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        int[] longest = {0};
        if (root != null)
            pathLen(root, longest);
        return longest[0];
    }
}
