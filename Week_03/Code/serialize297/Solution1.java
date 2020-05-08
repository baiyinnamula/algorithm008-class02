package serialize297;

import lowestCommonAncestor68.TreeNode;

import java.util.*;

public class Solution1 {
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        if (root == null){
            builder.append("null,");
        }else {
            builder.append(root.val);
            builder.append(",");
            builder.append(serialize(root.left));
            builder.append(serialize(root.right));
        }
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        Queue<String> queue = new ArrayDeque();
        queue.addAll(Arrays.asList(arr));
        return buildTree(queue);
    }

    private TreeNode buildTree(Queue<String> nodes){
        String val = nodes.remove();
        if (val.equals("null")){
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = buildTree(nodes);
        root.right = buildTree(nodes);

        return root;
    }
}
