package hard.binarytreepostordertraversal;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<Integer> walkSubTree(TreeNode root, List<Integer> memo) {
        if (root == null)
            return memo;
        if (root.left != null)
            walkSubTree(root.left, memo);
        if (root.right != null)
            walkSubTree(root.right, memo);
        memo.add(root.val);
        return memo;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        return walkSubTree(root, new ArrayList<Integer>());
    }
}
