package minDepth111;

import maxDepth104.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 解题思路：广度优先搜索迭代
 * 时间复杂度：O(N)
 * 空间复杂度：O(N)
 */
public class Solution3 {
    public int minDepth(TreeNode root) {
        //如果是空的树返回 0
        if (root == null) {
            return 0;
        }
        Queue<Map.Entry<TreeNode, Integer>> stack = new LinkedList<>();
        stack.add(new HashMap.SimpleEntry(root, 1));

        int currentDepth = 0;
        while (!stack.isEmpty()) {
            Map.Entry<TreeNode, Integer> current = stack.poll();
            root = current.getKey();
            currentDepth = current.getValue();
            if (root.left == null && root.right == null) {
                break;
            }
            if (root.left != null) {
                stack.add(new HashMap.SimpleEntry<>(root.left, currentDepth + 1));
            }
            if (root.right != null) {
                stack.add(new HashMap.SimpleEntry<>(root.right, currentDepth + 1));
            }
        }

        return currentDepth;
    }
}
