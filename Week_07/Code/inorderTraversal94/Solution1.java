package inorderTraversal94;

import java.util.ArrayList;
import java.util.List;

/**
 * 解题思路：递归
 * 时间复杂度：O(N)
 * 时间复杂度：O(N)
 */
public class Solution1 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        dfs(root, ans);

        return ans;

    }

    public void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            dfs(root.left, list);
        }
        list.add(root.val);
        if (root.right != null) {
            dfs(root.right, list);
        }
    }
}
