package easy.symmetrictree;

import common.TreeNode;

class Solution {
    private boolean checkSymmetric(TreeNode left, TreeNode right) {
        if (left==null || right==null)
            return left==right;
        return(left.val==right.val &&
                checkSymmetric(left.left, right.right) &&
                checkSymmetric(left.right, right.left));
    }
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return checkSymmetric(root.left, root.right);
    }
}
