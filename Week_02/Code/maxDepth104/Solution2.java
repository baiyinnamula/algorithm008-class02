package maxDepth104;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author yangbaiyinnamula
 * 时间复杂度：O(N)
 * 空间复杂度：O(N)
 */
public class Solution2 {
    public int maxDepth(TreeNode root) {
        Queue<Map.Entry<TreeNode, Integer>> stack = new LinkedList<>();
        if (root != null) {
            //把根节点压入栈
            stack.add(new HashMap.SimpleEntry<TreeNode, Integer>(root, 1));
        }


        //记录深度
        int depth = 0;
        while (!stack.isEmpty()) {
            Map.Entry<TreeNode, Integer> current = stack.poll();
            root = current.getKey();
            int currentDepth = current.getValue();
            if (root != null) {
                depth = Math.max(depth, currentDepth);
                //把左右节点压入栈
                if (root.left != null) {
                    stack.add(new HashMap.SimpleEntry<TreeNode, Integer>(root.left, currentDepth + 1));
                }
                if (root.right != null) {
                    stack.add(new HashMap.SimpleEntry<TreeNode, Integer>(root.right, currentDepth + 1));
                }
            }
        }

        return depth;
    }
}
