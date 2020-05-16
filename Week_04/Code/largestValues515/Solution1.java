package largestValues515;

import levelOrder102.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 解题思路：使用广度优先遍历
 * 时间复杂度：O(N)
 * 空间复杂度：O(N)
 */
public class Solution1 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            Deque<TreeNode> temp = new LinkedList<>();
            int largest = Integer.MIN_VALUE;
            while (!deque.isEmpty()) {
                TreeNode node = deque.pop();
                largest = node.val > largest ? node.val : largest;
                if (node.left != null) {
                    temp.add(node.left);
                }
                if (node.right != null) {
                    temp.add(node.right);
                }
            }
            deque = temp;
            ans.add(largest);
        }
        return ans;
    }
}
