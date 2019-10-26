package medium.binarytreelongestconsecutivesequence;

import common.TreeNode;

class Solution {
    private int incConsecutive(TreeNode root, int currLen, int prevVal) {
        int retLen = 1;
        if (root == null)
            return 0;
        if (root.val == (prevVal + 1))
            retLen = currLen+1;
        return Math.max(retLen,
                Math.max(incConsecutive(root.left, retLen, root.val),
                        incConsecutive(root.right, retLen, root.val))
        );
    }

    public int longestConsecutive(TreeNode root) {
        if (root == null)
            return 0;
        return incConsecutive(root, 1, root.val);
    }
}
