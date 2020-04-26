package minDepth111;

import maxDepth104.TreeNode;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 解题思路：深度优先搜索迭代
 * 时间复杂度：O(N)
 * 空间复杂度：O(N)
 */
public class Solution2 {
    public int minDepth(TreeNode root) {
        //如果是空的树返回 0
        if (root == null) {
            return 0;
        }
        LinkedList<Map.Entry<TreeNode, Integer>> stack = new LinkedList<>();
        stack.add(new HashMap.SimpleEntry(root, 1));

        int depth = Integer.MAX_VALUE;
        while (!stack.isEmpty()) {
            Map.Entry<TreeNode, Integer> current = stack.poll();
            root = current.getKey();
            int currentDepth = current.getValue();
            //访问到叶子节点时更新最小深度
            if (root.left == null && root.right == null) {
                depth = Math.min(depth, currentDepth);
            }
            if (root.left != null) {
                stack.add(new HashMap.SimpleEntry<>(root.left, currentDepth + 1));
            }
            if (root.right != null) {
                stack.add(new HashMap.SimpleEntry<>(root.right, currentDepth + 1));
            }
        }

        return depth;
    }
}
