package minDepth111;

import maxDepth104.TreeNode;

/**
 * 解题思路：递归
 * 时间复杂度：O(N)
 * 时间复杂度：最坏情况O(N)，最好情况：O(logN)
 */
public class Solution1 {
    public int minDepth(TreeNode root) {
        //如果是空的树返回 0
        if (root == null) {
            return 0;
        }

        //如果左右节点都是空（也就是当前节点是叶子节点）返回 1
        if (root.left == null && root.right == null) {
            return 1;
        }

        int depth = Integer.MAX_VALUE;
        //获取左右子节点里深度最小的
        if (root.left != null) {
            depth = Math.min(depth, minDepth(root.left));
        }
        if (root.right != null) {
            depth = Math.min(depth, minDepth(root.right));
        }

        return depth + 1;
    }
}
