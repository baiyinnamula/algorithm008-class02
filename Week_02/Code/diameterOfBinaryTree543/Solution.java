package diameterOfBinaryTree543;

import maxDepth104.TreeNode;

public class Solution {
    int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;

    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        //计算当前节点左子树深度
        int left = depth(node.left);
        //计算当前节点右子树深度
        int right = depth(node.right);
        //left + right + 1 ：当前节点为根节点的直径长度
        //更新目前为止最长直径
        ans = Math.max(ans, left + right + 1);
        //返回当前节点为根节点的数的深度
        return Math.max(left, right) + 1;

    }
}
