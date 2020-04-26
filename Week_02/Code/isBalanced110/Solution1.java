package isBalanced110;

import maxDepth104.TreeNode;
/**
 * 从底至顶（提前阻断）
 * 此方法为本题的最优解法，但“从底至顶”的思路不易第一时间想到。
 *
 * 思路是对二叉树做先序遍历，从底至顶返回子树最大高度，若判定某子树不是平衡树则 “剪枝” ，直接向上返回。
 *
 * 算法流程：
 * recur(root):
 *
 * 递归返回值：
 * 当节点root 左 / 右子树的高度差 < 2<2 ：则返回以节点root为根节点的子树的最大高度，即节点 root 的左右子树中最大高度加 11 （ max(left, right) + 1 ）；
 * 当节点root 左 / 右子树的高度差 \geq 2≥2 ：则返回 -1−1 ，代表 此子树不是平衡树 。
 * 递归终止条件：
 * 当越过叶子节点时，返回高度 00 ；
 * 当左（右）子树高度 left== -1 时，代表此子树的 左（右）子树 不是平衡树，因此直接返回 -1−1 ；
 * isBalanced(root) ：
 *
 * 返回值： 若 recur(root) != 1 ，则说明此树平衡，返回 truetrue ； 否则返回 falsefalse 。
 *
 * 作者：jyd
 * 链接：https://leetcode-cn.com/problems/balanced-binary-tree/solution/balanced-binary-tree-di-gui-fang-fa-by-jin40789108/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author yangbaiyinnamula
 * 时间复杂度：O(N)
 * 空间复杂度：O(N)
 */
public class Solution1   {
    public boolean isBalanced(TreeNode root) {
        return recur(root) != -1;
    }

    private int recur(TreeNode root) {
        //如果 root 为 null 返回 0
        if (root == null) {
            return 0;
        }
        //如果左子树不是平衡树，那整个树也不是平衡树
        int left = recur(root.left);
        if (left == -1) {
            return -1;
        }
        //如果右子树不是平衡树，那整个树也不是平衡树
        int right = recur(root.right);
        if (right == -1) {
            return -1;
        }

        //如果左右子树高度相差2及以上，表示整个树也不是平衡树
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}
