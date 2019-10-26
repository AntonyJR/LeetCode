package medium.binarytreepreordertraversal;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    private TreeNode getRightmost(TreeNode root) {
        TreeNode current = root.left;
        while (current.right != null && current.right != root)
            current = current.right;
        return current;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> resp = new ArrayList();
        TreeNode current = root;
        while (current != null) {
            if (current.left == null) {
                resp.add(current.val);
                current = current.right;
            }
            else {
                TreeNode rightmost = getRightmost(current);
                if (rightmost.right == current) {
                    rightmost.right = null;
                    current = current.right;
                }
                else {
                    resp.add(current.val);
                    rightmost.right = current;
                    current = current.left;
                }
            }
        }
        return resp;
    }
}
