package medium.binarysearchtreeiterator;

import common.TreeNode;

class BSTIterator {
    private TreeNode current;

    private TreeNode findRightmost() {
        TreeNode rightmost = current.left;
        while (rightmost.right != null && rightmost.right != current) {
            rightmost = rightmost.right;
        }
        return rightmost;
    }

    private void moveLeftmost() {
        while (current.left != null) {
            TreeNode rightmost = findRightmost();
            rightmost.right = current;
            current = current.left;
        }
    }

    public BSTIterator(TreeNode root) {
        current = root;
        if (current != null)
            moveLeftmost();
    }

    /** @return the next smallest number */
    public int next() {
        int retval = current.val;
        current = current.right;
        if (current != null && current.left != null) {
            TreeNode rightmost = findRightmost();
            if (current == rightmost.right)
                rightmost.right = null;
            else
                moveLeftmost();
        }
        return retval;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return current != null;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
