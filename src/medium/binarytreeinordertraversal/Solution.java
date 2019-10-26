package medium.binarytreeinordertraversal;

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

    public List<Integer> inorderTraversal(TreeNode root) {
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
                    resp.add(current.val);
                    current = current.right;
                }
                else {
                    rightmost.right = current;
                    current = current.left;
                }
            }
        }
        return resp;
    }
}
