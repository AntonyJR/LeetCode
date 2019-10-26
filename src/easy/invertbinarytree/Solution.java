package easy.invertbinarytree;

import common.TreeNode;

class Solution {
    @SuppressWarnings({"WeakerAccess", "UnusedReturnValue"})
    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }
}
