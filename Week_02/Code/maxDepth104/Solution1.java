package maxDepth104;

/**
 * @author yangbaiyinnamula
 * 解题思路：使用递归
 * 当前树的最大深度 = 最深子树的长（左子树或右子树）+1
 * 时间复杂度：O(N) 每个节点访问一次
 * 空间复杂度：最坏情况O(N) ，最好情况O(logN)
 *
 */
public class Solution1 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
