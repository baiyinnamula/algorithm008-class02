package lowestCommonAncestor68;

import java.util.*;

public class Solution2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        //用于存储子节点和对应父节点 map
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        //用于建立子节点和对应父节点 map
        Deque<TreeNode> stack = new ArrayDeque<>();
        parent.put(root, null);
        stack.push(root);
        while (!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }

        //把存储p节点和它的所有祖先节点的集合
        Set<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }
        //p节点和它的所有祖先节点的集合中查找q 节点的祖先，找到的第一个祖先节点就是p,q 的最近公共祖先
        while (!ancestors.contains(q)) {
            q = parent.get(q);
        }
        return q;
    }
}
