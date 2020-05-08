package isValidBST98;

import invertTree226.TreeNode;

public class Solution1 {
    private boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }
        int val = node.val;
        //如果当前结点的值小于等于下界，则不是二叉搜索树
        if (lower != null && val <= lower) {
            return false;
        }
        //如果当前结点的值大于等于上界，则不是二叉搜索树
        if (upper != null && upper <= val) {
            return false;
        }
        //遍历右节点的下界为当前节点值
        if (!helper(node.right, val, upper)) {
            return false;
        }
        //遍历左节点的上界为当前节点值
        if (!helper(node.left, lower, val)) {
            return false;
        }

        return true;
    }

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }
}
