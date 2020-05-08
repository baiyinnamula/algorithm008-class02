package lowestCommonAncestor68;


/**
 * 面试题68 - II. 二叉树的最近公共祖先
 */
public class Solution1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //root 是叶子节点或p,q 中的一个则返回 root
        if (root == null || p == root || q == root) {
            return root;
        }
        //在左子树中找最近公共祖先
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        //在右子树中找最近公共祖先
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //左子树和右子树都没有找到 p 的祖先和q 的祖先（一个节点也可以是它自己的祖先）
        //说明当前子树里没有 p,q ，所以返回 null
        if(left == null && right == null) {
            return null;
        }
        //说明q,p 一个在左子树里一个在右子树里（因为不可能出现，p,q 两个同时出现在两个不同的子树里）
        if(left != null && right != null) {
            return root;
        }
        //说明 p,q 不是在左子树里就是在右子树里
        return left == null ? right : left;
    }
}
