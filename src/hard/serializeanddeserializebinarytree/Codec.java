package hard.serializeanddeserializebinarytree;

import common.TreeNode;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class Codec {

    private void serializeTree(TreeNode root, StringBuffer memo) {
        if (root == null)
            memo.append("N,");
        else {
            memo.append(root.val).append(",");
            serializeTree(root.left, memo);
            serializeTree(root.right, memo);
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer retval = new StringBuffer();
        serializeTree(root, retval);
        return retval.toString();
    }

    private TreeNode deserializeTree(Iterator<String> iter) {
        String current = iter.next();
        TreeNode node = null;
        if (!current.equals("N")) {
            node = new TreeNode(Integer.parseInt(current));
            node.left = deserializeTree(iter);
            node.right = deserializeTree(iter);
        }
        return node;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> nodes = Arrays.asList(data.split(","));
        return deserializeTree(nodes.iterator());
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));