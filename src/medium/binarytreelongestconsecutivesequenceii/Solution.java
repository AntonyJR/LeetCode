package medium.binarytreelongestconsecutivesequenceii;

import common.TreeNode;

class Solution {
    static class Path {
        int lenInc = 0;
        int lenDec = 0;
        static final Path EMPTY = new Path();
    }

    private Path longestPath(TreeNode root, int[] memo) {
        Path lpath;
        Path rpath;
        Path retval = new Path();
        retval.lenInc = 1;
        retval.lenDec = 1;
        if (root.left != null)
            lpath = longestPath(root.left, memo);
        else
            lpath = Path.EMPTY;
        if (root.right != null)
            rpath = longestPath(root.right, memo);
        else
            rpath = Path.EMPTY;
        if (lpath != Path.EMPTY)
            if (root.val == root.left.val + 1)
                retval.lenInc = lpath.lenInc+1;
            else if (root.val == root.left.val - 1)
                retval.lenDec = lpath.lenDec+1;
        if (rpath != Path.EMPTY)
            if (root.val == root.right.val + 1)
                retval.lenInc = Math.max(rpath.lenInc+1, retval.lenInc);
            else if (root.val == root.right.val - 1)
                retval.lenDec = Math.max(rpath.lenDec+1, retval.lenDec);
        memo[0] = Math.max(retval.lenInc+retval.lenDec-1, memo[0]);
        return retval;
    }

    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        int[] retval = new int[1];
        longestPath(root, retval);
        return retval[0];
    }
}
