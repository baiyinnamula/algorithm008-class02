package inorderTraversal94;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 解题思路:自己维护一个栈，遍历
 * 时间复杂度：O(N)
 * 空间复杂度：O(N)
 */
public class Solution2 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            ans.add(curr.val);
            curr = curr.right;
        }

        return ans;
    }
}
